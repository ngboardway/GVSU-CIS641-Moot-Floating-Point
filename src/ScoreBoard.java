import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ScoreBoard extends JPanel {

	JButton clearScores;
	ClearButtonListener listener;
	List<JLabel> scores = new ArrayList<JLabel>();

	public ScoreBoard() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		drawHighScoresHeader();
		drawHighScores();
		drawClearButton();
	}

	private void drawHighScoresHeader() {
		ImageIcon image = new ImageIcon("src/high-scores-header.png");
		JLabel label = new JLabel();
		label.setIcon(image);
		add(label);
	}

	private void drawHighScores() {
		try {
			List<ScoreEntry> allScores = new ArrayList<ScoreEntry>();
			Scanner scanner = new Scanner(GetScoreFile());
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				allScores.add(processEntry(data));
			}

			allScores.sort(new ScoreEntryComparator());
			List<ScoreEntry> highScores = allScores.subList(0, 2);
			for (ScoreEntry score : highScores) {
				JLabel scoreLabel = constructScoreLabel(score);
				scores.add(scoreLabel);
				add(scoreLabel);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			drawNoScoresLabel();
		}
	}

	private ScoreEntry processEntry(String data) {
		String[] scoreData = data.split(",");
		String scoreString = scoreData[1];
		int score = Integer.parseInt(scoreString);
		return new ScoreEntry(score, scoreData[0]);
	}

	private void drawNoScoresLabel() {
		JLabel noScoreLabel = new JLabel("No Scores Yet");
		Font f = new Font("Serif", Font.PLAIN, 20);
		noScoreLabel.setFont(f);

		add(noScoreLabel);
	}

	private JLabel constructScoreLabel(ScoreEntry entry) {
		String text = entry.getPlayer() + "\t\t" + entry.getScore();

		JLabel scoreLabel = new JLabel(text);
		Font f = new Font("Serif", Font.PLAIN, 26);
		scoreLabel.setFont(f);

		scoreLabel.setForeground(Color.blue);

		scoreLabel.setBorder(new EmptyBorder(5, 10, 5, 10));

		return scoreLabel;
	}

	private void drawClearButton() {
		listener = new ClearButtonListener();
		clearScores = new JButton("Clear High Scores");
		clearScores.addActionListener(listener);

		add(clearScores);

	}

	private void clearHighScores() {
		File file = GetScoreFile();
		if (file.exists()) {
			file.delete();
			for (JLabel s : scores) {
				remove(s);
			}
			drawNoScoresLabel();
			revalidate();
		}
	}

	private File GetScoreFile() {
		return new File("scores.csv");
	}

	class ClearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == clearScores) {
				clearHighScores();
			}
		}
	}

	class ScoreEntry {
		private int score;
		private String player;

		ScoreEntry(int score, String player) {
			this.score = score;
			this.player = player;
		}

		public int getScore() {
			return score;
		}

		public String getPlayer() {
			return player;
		}
	}

	class ScoreEntryComparator implements Comparator<ScoreEntry> {

		@Override
		public int compare(ScoreEntry o1, ScoreEntry o2) {
			return o2.score - o1.score;
		}

	}
}

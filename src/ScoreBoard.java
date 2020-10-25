import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel {

	JButton clearScores;
	ClearButtonListener listener;

	public ScoreBoard() {
		System.out.println("In the score board");
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		drawHighScoresHeader();
		drawHighScores();
		drawClearButton();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		startDrawing(g);
	}

	/**
	 *
	 * @param g
	 */
	public void startDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.gray);
		g2d.fillRect(0, 100, 850, 800);

	}


	private void drawHighScoresHeader() {
		ImageIcon image = new ImageIcon("src/high-scores-header.png");
		JLabel label = new JLabel();
		label.setIcon(image);
		add(label);
	}

	private void drawHighScores() {
		try {
			Scanner scanner = new Scanner(new File("scores.csv"));
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				JLabel scoreLabel = constructScoreLabel(data);
				scoreLabel.setForeground(Color.CYAN);
				add(scoreLabel);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("No scores yet");
		}
	}

	private JLabel constructScoreLabel(String data) {
		JLabel scoreLabel = new JLabel();
		String[] scores = data.split(",");
		String text = scores[0] + "\t\t" + scores[1];

		scoreLabel.setText(text);

		return scoreLabel;
	}

	private void drawClearButton() {
		listener = new ClearButtonListener();
		clearScores = new JButton("Clear High Scores");
		clearScores.addActionListener(listener);

		add(clearScores);

	}

	private void clearHighScores() {
		File file = new File("scores.csv");
		if (file.exists()) {
			file.delete();
		}
	}

	class ClearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == clearScores) {
				clearHighScores();
			}
		}
	}
}

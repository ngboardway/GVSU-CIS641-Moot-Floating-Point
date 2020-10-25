import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NavBarPanel extends JPanel {
	JButton start;
	JButton highScore;

	ButtonListener listener;

	NameTBD actions;

	public NavBarPanel(NameTBD tbd) {
		drawButtons();
		actions = tbd;
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
		g2d.setColor(Color.green);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

	private void drawButtons() {
		listener = new ButtonListener();

		start = new JButton("Start Game");
		start.addActionListener(listener);

		highScore = new JButton("View High Scores");
		highScore.addActionListener(listener);

		add(start);
		add(highScore);
	}

	private void toggleButtonStatus(boolean isShowingScores) {
		if (isShowingScores) {
			highScore.setText("Back");
			start.setVisible(false);
		} else {
			highScore.setText("View High Scores");
			start.setVisible(true);
		}
	}

	/**
	 *
	 */
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == start) {
				actions.startGame();
			}
			if (event.getSource() == highScore) {
				boolean isShowingScores = actions.toggleHighScores();
				toggleButtonStatus(isShowingScores);
			}
		}
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class PacMemePanel extends JPanel implements NameTBD {

	NavBarPanel navBarPanel;
	ScoreBoard scoreBoard;

	// global var for moving the character.
	int packMemeSpeedX;
	int packMemeSpeedY;

	GridBagConstraints c = new GridBagConstraints();

	/**
	 * Constructor class.
	 */
	public PacMemePanel() {
		packMemeSpeedX = 0;
		packMemeSpeedY = 0;

		showTitleScreen();
		setLayout(new GridBagLayout());
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
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, 900, 900);
	}

	/**
	 * Method that builds the title screen and holds the user there until they
	 * select an option.
	 */
	public void showTitleScreen() {
		navBarPanel = new NavBarPanel(this);
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;

		add(navBarPanel, c);
	}

	/**
	 * Method to move the user from the current screen to the game and starts the
	 * game.
	 */
	public void startGame() {
		addKeyListener(new Keyboard());
	}

	/**
	 * Method to move the user from the current screen to the high scores screen.
	 * The high scores will be imported from a text document.
	 */
	public boolean toggleHighScores() {
		boolean isShowingScores = true;
		if (this.scoreBoard == null) {
			scoreBoard = new ScoreBoard();
			c.gridx = 0;
			c.gridy = 1;
			c.anchor = GridBagConstraints.CENTER;
			add(scoreBoard, c);
		} else if (!this.scoreBoard.isVisible()) {
			this.scoreBoard.setVisible(true);
		} else {
			this.scoreBoard.setVisible(false);
			isShowingScores = false;
		}

		revalidate();
		return isShowingScores;
	}

	/**
	 *
	 */
	class Keyboard extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			int keyPress = e.getKeyCode();
			if (keyPress == KeyEvent.VK_LEFT) {
				packMemeSpeedX = -1;
			} else if (keyPress == KeyEvent.VK_RIGHT) {
				packMemeSpeedX = 1;
			} else if (keyPress == KeyEvent.VK_UP) {
				packMemeSpeedY = 1;
			} else if (keyPress == KeyEvent.VK_DOWN) {
				packMemeSpeedY = -1;
			}
		}
	}

}

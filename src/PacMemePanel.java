import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PacMemePanel extends JPanel {
    JButton start;
    JButton highScore;

    ButtonListener listener;

    //global var for moving the charicter.
    int packMemeSpeedX;
    int packMemeSpeedY;

    /**
     * Constructor class.
     */
    public PacMemePanel() {
        packMemeSpeedX = 0;
        packMemeSpeedY = 0;

        showTitleScreen();
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
    public void startDrawing(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 800, 800);

    }

    /**
     * Method that builds the title screen and holds the user there until
     * they select an option.
     */
    public void showTitleScreen(){

        listener = new ButtonListener();
        start = new JButton("Start Game");
        start.addActionListener(listener);

        highScore = new JButton("View High Scores");
        highScore.addActionListener(listener);

        add(start);
        add(highScore);
    }

    /**
     * Method to move the user from the current screen to the game and starts the game.
     */
    public void startGame(){
        addKeyListener(new Keyboard());
    }

    /**
     * Method to move the user from the current screen to the high scores screen.
     * The high scores will be imported from a text document.
     */
    public void showHighScores(){

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

    /**
     *
     */
     class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == start) {
                startGame();
            }
            if (event.getSource() == highScore) {
                showHighScores();
            }
        }
    }

}

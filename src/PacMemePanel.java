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

    /**
     *
     */
    public PacMemePanel() {
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

        //showTitleScreen(g2d);

    }

    /**
     *
     *
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
     *
     */
    public void startGame(){
        addKeyListener(new Keyboard());
    }

    /**
     *
     */
    public void showHighScores(){

    }

    class Keyboard extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int keyPress = e.getKeyCode();
            if (keyPress == KeyEvent.VK_LEFT) {

            } else if (keyPress == KeyEvent.VK_RIGHT) {

            } else if (keyPress == KeyEvent.VK_UP) {

            } else if (keyPress == KeyEvent.VK_DOWN) {

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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PacMemePanel extends JPanel {
    JButton start;
    JButton highScore;

    private Image ii;

    Boolean gameStart;

    ButtonListener listener;

    Image link;

    int testNumber = 0;

    //global var for moving the charicter.
    int packMemeSpeedX;
    int packMemeSpeedY;
    int packMemeLoactionX;
    int packMemeLocationY;

    /**
     * Constructor class.
     */
    public PacMemePanel() {
        packMemeSpeedX = 0;
        packMemeSpeedY = 0;

        gameStart = false;

        packMemeLoactionX = 5;
        packMemeLocationY = 5;

        bufferImages();

        showTitleScreen();
    }
    private void bufferImages(){
        link = new ImageIcon("images/link.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println(++testNumber);
        doDrawing(g);
    }

    /**
     *
     * @param g
     */
    public void doDrawing(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 800, 800);

        if(gameStart){
            moveMememan();
            drawMememan(g2d);
        }else{

        }
        //g2d.drawImage(ii, 5, 5, this);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    private void drawMememan(Graphics2D g2d){
        g2d.drawImage(link, 0, 0, this);
    }
    private void moveMememan(){
        packMemeLoactionX = packMemeLoactionX + packMemeSpeedX;
        packMemeLocationY = packMemeLocationY + packMemeSpeedY;
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
        removeAll();
        revalidate();
        repaint();
        gameStart = true;
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
        public void keyReleased(KeyEvent e) {

            int keyPress = e.getKeyCode();
            if (keyPress == Event.LEFT || keyPress == Event.RIGHT
                    || keyPress == Event.UP || keyPress == Event.DOWN){
                packMemeSpeedX = 0;
                packMemeSpeedY = 0;
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

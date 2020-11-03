import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;



public class PacMemeBoard extends JPanel implements ActionListener {


    private Dimension dimension;

    private Image ii;

    private boolean inGame = false;
    private boolean dead = false;

    private int score;

    private Timer timer;

    private MemeMan memeMan;

    /**
     * Constructor class.
     */
    public PacMemeBoard () {
        memeMan = new MemeMan();
        initVariables();
        initBoard();
    }

    /**
     * Sets the variables we will be using in the game.
     */
    private void initVariables() {

        score = 0;

        dimension = new Dimension(500, 500);

        timer = new Timer(40, this);
        timer.start();
    }

    /**
     * Sets up the board.
     */
    private void initBoard() {
        addKeyListener(new Keyboard());
        setFocusable(true);
        setBackground(Color.white);
    }

    //not sure what addNotify is
    @Override
    public void addNotify() {
        super.addNotify();

        initGame();
    }

    private void initGame() {
        //not sure what to do here yet.
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    /**
     * Draws everything on the screen over and over and over
     * and over and over and over and over. Over again and again.
     * @param g
     */
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        //drawMaze(g2d); -> once we figure out how to draw the maze this is the caller
        drawScore(g2d);
        //doAnim(); -> this will update the PacMeme sprite once we have that set up

        if (inGame) {
            playGame(g2d);
        } else {
            showMainMenu(g2d);
        }

        g2d.drawImage(ii, 5, 5, this);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    /**
     * Basicly the game loop for the Meme-Man and Meme-Ghosts
     * @param g2d
     */
    private void playGame(Graphics2D g2d) {

        if (dead) {

        } else {
            memeMan.moveMemeMan();
            drawMemeMan(g2d);
            //move ghosts, draw ghosts, check the maze for death.
        }

    }

    /**
     * Draws Meme-Man on the Graphics 2D board
     * @param g2d
     */
    private void drawMemeMan(Graphics2D g2d) {

        g2d.drawImage(memeMan.getMemeMan(), memeMan.getMemeMan_X(), memeMan.getMemeMan_Y(), this);

    }

    /**
     * Draws the score on the Graphics 2D board, we can also draw the remaining Meme-Ghosts
     * in this method
     * @param g2d
     */
    private void drawScore(Graphics2D g2d) {

        g2d.setColor(Color.black);
        g2d.drawString("Score:      " + score, 20, 20);

    }

    private void showMainMenu(Graphics2D g2d){
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        String s = "Press space bar to start.";
        Font small = new Font("Helvetica", Font.BOLD, 14);

        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString(s, 160,230);
    }


    class Keyboard extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    memeMan.setMemeManSpeed(-3, 0);
                } else if (key == KeyEvent.VK_RIGHT) {
                    memeMan.setMemeManSpeed(3, 0);
                } else if (key == KeyEvent.VK_UP) {
                    memeMan.setMemeManSpeed(0, -3);
                } else if (key == KeyEvent.VK_DOWN) {
                    memeMan.setMemeManSpeed(0, 3);
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    inGame = false;
                } else if (key == KeyEvent.VK_PAUSE) {
                    if (timer.isRunning()) {
                        timer.stop();
                    } else {
                        timer.start();
                    }
                }
            } else {
                if (key == KeyEvent.VK_SPACE) {
                    inGame = true;
                    //initGame();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

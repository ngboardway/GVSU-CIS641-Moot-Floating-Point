import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 * PacMemeBoard. This class controls what is shown on the JPanel.
 * <p>
 * * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * * @version Fall 2020
 */
public class PacMemeBoard extends JPanel implements ActionListener {

    /**
     * Dimension for the board
     */
    private Dimension dimension;

    /**
     * Boolean for if we are in the game
     */
    private boolean inGame = false;

    /**
     * Boolean for if we are dead
     */
    private boolean inGameOver = false;

    /**
     * Boolean for if we are viewing the high score board
     */
    private boolean viewingLeaderboard = false;

    /**
     * Timer for setting the refresh rate for the paintComponent
     */
    private Timer timer;



    /**
     *
     */
    private int powerUpIncrement;

    private final int powerUpTime = 1500;

    /**
     * Creates instance of PacMemeGame
     */
    private PacMemeGame pacMemeGame;

    /**
     * Constructor method to set the variables and board.
     */
    public PacMemeBoard() {
        initVariables();
        initBoard();
    }

    /**
     * Sets the variables we will be using in the game.
     */
    private void initVariables() {
        pacMemeGame = new PacMemeGame();
        dimension = new Dimension(766, 820);

        //I want to lower the delay, change his movement from 3px down to apx.
        //but the collision detection breaks when I do - nick
        timer = new Timer(10, this);
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

    /**
     * Overriding method to call our own drawing method. Called each
     * increment of the global timer.
     *
     * @param g what is on the JPanel
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    /**
     * Draws everything on the screen dependent on if we are in the game,
     * viewing the leaderboard, or at the main menu.
     *
     * @param g what is on the JPanel
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        if (inGame) {
            playGame(g2d);
        } else if (inGameOver) {
            showGameOver(g2d);
            timer.stop();
        } else if (viewingLeaderboard) {
            showLeaderboard(g2d);
        } else {
            showMainMenu(g2d);

        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    /**
     * Draws everything on the board when we are in the game.
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void drawBoard(Graphics2D g2d) {
        drawDots(g2d);
        drawWalls(g2d);
        drawMemeMan(g2d);
        drawGhosts(g2d);
        drawFruit(g2d);
        drawPowerUps(g2d);
        drawScore(g2d);
    }

    /**
     * The game loop for moving Meme-Man and the ghosts
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void playGame(Graphics2D g2d) {

        if (pacMemeGame.getMemeMan().getLifeCount() <= 0) {

            inGameOver = true;
            inGame = false;

            if (pacMemeGame.shouldSaveScores()) {
                pacMemeGame.saveHighScores();
            }

        } else {


            if (pacMemeGame.getMemeMan().getDead()) {

                pacMemeGame.getMemeMan().decLife();

            } else {
                // Move ghost
                pacMemeGame.collisionDetections();
                pacMemeGame.getMemeMan().moveActor();


                if (pacMemeGame.getMemeMan().getPowerUpActive()) {
                    powerUpIncrement++;
                    System.out.println(powerUpIncrement);

                    // If we are in a power up
                    if (powerUpIncrement >= powerUpTime) {
                        pacMemeGame.getMemeMan().setPowerUpActive(false);
                        powerUpIncrement = 0;
                    }
                }

                // draw pieces on updated coordinates
                drawBoard(g2d);

                // if the game is over and they scored in the top ten,
                // set the flag to show the input for their initials.
                if (isGameWon()) {
                    inGame = false;
                    inGameOver = true;
                    if (pacMemeGame.shouldSaveScores()) {
                        pacMemeGame.saveHighScores();
                    }
                }
            }
        }
    }

    /**
     * Determines if the game is over or not. If all of the collectables have
     * been consumed then the game is over.
     *
     * @return if the game is over or not
     */
    private boolean isGameWon() {
        for (Dot dot : pacMemeGame.getDots()) {
            if (dot.isVisible()) {
                return false;
            }
        }

        for (Fruit fruit : pacMemeGame.getFruit()) {
            if (fruit.isVisible()) {
                return false;
            }
        }

        for (PowerUp powerUp : pacMemeGame.getPowerUps()) {
            if (powerUp.isVisible()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Draws Meme-Man on the Graphics 2D board
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void drawMemeMan(Graphics2D g2d) {
        MemeMan memeMan = pacMemeGame.getMemeMan();
        g2d.drawImage(memeMan.getImage(), memeMan.getX(), memeMan.getY(), this);
    }

    /**
     * Draws the ghosts on the Graphics 2D board
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void drawGhosts(Graphics2D g2d) {
        for (Ghost ghost : pacMemeGame.getGhosts()) {
            if (ghost.getVisibility()) {
                g2d.drawImage(ghost.getImage(), ghost.getX(), ghost.getY(), this);
            }
        }
    }

    /**
     * Draws the dots on the Graphics 2D board
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void drawDots(Graphics2D g2d) {
        for (Dot dot : pacMemeGame.getDots()) {
            if (dot.isVisible()) {
                g2d.drawImage(dot.getImage(), dot.getX(), dot.getY(), this);
            }
        }
    }

    /**
     * Draws the fruit on the Graphics 2D board
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void drawFruit(Graphics2D g2d) {
        for (Fruit fruit : pacMemeGame.getFruit()) {
            if (fruit.isVisible()) {
                g2d.drawImage(fruit.getImage(), fruit.getX(), fruit.getY(), this);
            }
        }
    }

    /**
     * Draws the power-ups on the Graphics 2D board
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void drawPowerUps(Graphics2D g2d) {
        for (PowerUp powerUp : pacMemeGame.getPowerUps()) {
            if (powerUp.isVisible()) {
                g2d.drawImage(powerUp.getImage(), powerUp.getX(), powerUp.getY(), this);
            }
        }
    }

    /**
     * Draws the walls on the Graphics 2D board
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void drawWalls(Graphics2D g2d) {
        for (Wall wall : pacMemeGame.getWalls()) {
            g2d.drawImage(wall.getImage(), wall.getX(), wall.getY(), this);
        }
    }

    /**
     * Draws the score on the Graphics 2D board
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void drawScore(Graphics2D g2d) {
        Font small = new Font("Helvetica", Font.BOLD, 14);
        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString("Score:      " + pacMemeGame.getScore(), 10, 770);

        g2d.drawString("Lives:      " + pacMemeGame.getMemeMan().getLifeCount(), 640, 770);


    }

    /**
     * Draws the main menu on the Graphics 2D board
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void showMainMenu(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        String s = "Press space bar to start.";
        String l = "Press 'L' to toggle leaderboard.";
        Font small = new Font("Helvetica", Font.BOLD, 14);

        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString(s, 160, 230);

        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString(l, 160, 260);
    }

    private void showGameOver(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        String s = "GAME OVER!";
        String l = "Score: " + pacMemeGame.getScore();
        Font small = new Font("Helvetica", Font.BOLD, 14);

        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString(s, 160, 230);

        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString(l, 160, 260);
    }

    /**
     * Draws the leaderboard on the Graphics 2D board
     *
     * @param g2d 2d graphics for what is on the JPanel
     */
    private void showLeaderboard(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        Font small = new Font("Helvetica", Font.BOLD, 14);
        Font title = new Font("Helvetica", Font.BOLD, 20);

        g2d.setColor(Color.black);
        g2d.setFont(title);
        g2d.drawString("Leaderboard", 160, 200);

        ArrayList<ScoreEntry> scores = pacMemeGame.readInScores();
        int yOffset = 20;
        g2d.setFont(small);

        if (scores.size() == 0) {
            g2d.drawString("There are no scores yet", 160, 230);
        } else {
            for (ScoreEntry score : scores) {
                g2d.drawString(score.toString(), 160, 230 + yOffset);
                yOffset += 20;
            }
        }
    }

    /**
     * Keyboard adapter class to help process what is typed on the keyboard.
     */
    class Keyboard extends KeyAdapter {

        /**
         * Override keyPressed method so we can grab what key has been pressed.
         *
         * @param e the KeyEvent for what key has been pressed on the keyboard.
         */
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    pacMemeGame.getMemeMan().setSpeed(-1, 0);
                    pacMemeGame.getMemeMan().setValidMove(true);
                } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    pacMemeGame.getMemeMan().setSpeed(1, 0);
                    pacMemeGame.getMemeMan().setValidMove(true);
                } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                    pacMemeGame.getMemeMan().setSpeed(0, -1);
                    pacMemeGame.getMemeMan().setValidMove(true);
                } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    pacMemeGame.getMemeMan().setSpeed(0, 1);
                    pacMemeGame.getMemeMan().setValidMove(true);
                }else if (key == KeyEvent.VK_SPACE) {
                    if (timer.isRunning()) {
                        timer.stop();
                    } else {
                        timer.start();
                    }
                }
            } else if(inGameOver) {
                if (key == KeyEvent.VK_SPACE) {
                    inGameOver = false;
                    timer.start();
                    pacMemeGame = new PacMemeGame();

                }
            } else {
                if (!viewingLeaderboard) {
                    if (key == KeyEvent.VK_SPACE) {
                        pacMemeGame.setUserName(JOptionPane.showInputDialog("Name: "));
                        inGame = true;
                    }
                }
                if (key == KeyEvent.VK_L) {
                    viewingLeaderboard = !viewingLeaderboard;
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

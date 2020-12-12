import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 * PacMemeBoard. This class controls what is shown on the JPanel.
 *
 * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * @version Fall 2020
 */
public class PacMemeBoard extends JPanel implements ActionListener {

    /**
     * Dimension for the board.
     */
    private Dimension dimension;

    /**
     * Boolean for if we are in the game.
     */
    private boolean inGame = false;

    /**
     * Boolean for if we are dead.
     */
    private boolean inGameOver = false;

    /**
     * Boolean for if we are viewing the high score board.
     */
    private boolean inLeaderboard = false;

    /**
     * Boolean for if we are viewing the controls.
     */
    private boolean inControl = false;

    /**
     * Timer for setting the refresh rate for the paintComponent.
     */
    private Timer timer;

    /**
     * Creates instance of PacMemeGame.
     */
    private PacMemeGame pacMemeGame;

    /**
     * Font for all of the small text used.
     */
    Font small = new Font("Helvetica", Font.BOLD, 25);

    /**
     * Font for all of the large text used.
     */
    Font large = new Font ("Helvetica", Font.BOLD, 80);

    /**
     * Font for all of the medium text used.
     */
    Font medium = new Font ("Helvetica", Font.BOLD, 50);

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
     * @param g what is on the JPanel.
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
     * @param g what is on the JPanel.
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (inGame) {
            playGame(g2d);
        } else if (inGameOver) {
            showGameOver(g2d);
            timer.stop();
        } else if (inLeaderboard) {
            showLeaderboard(g2d);
        } else if(inControl) {
            showControl(g2d);
        }else {
            showMainMenu(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    /**
     * Draws everything on the board when we are in the game.
     *
     * @param g2d 2d graphics for what is on the JPanel.
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
     * The game loop for moving Meme-Man and the ghosts.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void playGame(Graphics2D g2d) {

        // If life count is 0
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
                pacMemeGame.collisionDetections();
                pacMemeGame.getMemeMan().moveActor();
                // This is where we would make the call the move the ghost.

                // If we are in a power-up
                if (pacMemeGame.getMemeMan().getPowerUpActive()) {
                    pacMemeGame.getMemeMan().incPowerUpIncrement();
                    System.out.println(pacMemeGame.getMemeMan().getPowerUpIncrement());

                    // Turn off power-up if we ar over 1500 (15 seconds)
                    int powerUpTime = 1500;
                    if (pacMemeGame.getMemeMan().getPowerUpIncrement() >= powerUpTime) {
                        pacMemeGame.getMemeMan().setPowerUpActive(false);
                        pacMemeGame.getMemeMan().setPowerUpIncrement(0);
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
     * @return if the game is over or not.
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
     * Draws Meme-Man on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void drawMemeMan(Graphics2D g2d) {
        MemeMan memeMan = pacMemeGame.getMemeMan();
        g2d.drawImage(memeMan.getImage(), memeMan.getX(), memeMan.getY(), this);
    }

    /**
     * Draws the ghosts on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void drawGhosts(Graphics2D g2d) {
        for (Ghost ghost : pacMemeGame.getGhosts()) {
            if (ghost.getVisibility()) {
                g2d.drawImage(ghost.getImage(), ghost.getX(), ghost.getY(), this);
            }
        }
    }

    /**
     * Draws the dots on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void drawDots(Graphics2D g2d) {
        for (Dot dot : pacMemeGame.getDots()) {
            if (dot.isVisible()) {
                g2d.drawImage(dot.getImage(), dot.getX(), dot.getY(), this);
            }
        }
    }

    /**
     * Draws the fruit on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void drawFruit(Graphics2D g2d) {
        for (Fruit fruit : pacMemeGame.getFruit()) {
            if (fruit.isVisible()) {
                g2d.drawImage(fruit.getImage(), fruit.getX(), fruit.getY(), this);
            }
        }
    }

    /**
     * Draws the power-ups on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void drawPowerUps(Graphics2D g2d) {
        for (PowerUp powerUp : pacMemeGame.getPowerUps()) {
            if (powerUp.isVisible()) {
                g2d.drawImage(powerUp.getImage(), powerUp.getX(), powerUp.getY(), this);
            }
        }
    }

    /**
     * Draws the walls on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void drawWalls(Graphics2D g2d) {
        for (Wall wall : pacMemeGame.getWalls()) {
            g2d.drawImage(wall.getImage(), wall.getX(), wall.getY(), this);
        }
    }

    /**
     * Draws the score and life count on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void drawScore(Graphics2D g2d) {
        Font small = new Font("Helvetica", Font.BOLD, 14);
        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString("Score:      " + pacMemeGame.getScore(), 10, 770);
        g2d.drawString("Lives:      " + pacMemeGame.getMemeMan().getLifeCount(), 640, 770);
    }

    /**
     * Draws the main menu on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void showMainMenu(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        String w = "Welcome to:";
        String m = "Pac Meme!!";
        String s = "Press space bar to start.";
        String l = "Press 'L' to toggle leaderboard.";
        String c = "Press 'C' to toggle controls";

        g2d.drawImage(new ImageIcon("images/funny1.jpg").getImage(), 500, 500, this);
        g2d.drawImage(new ImageIcon("images/link.png").getImage(), 100, 600, this);
        g2d.drawImage(new ImageIcon("images/Ghost1.png").getImage(), 200, 600, this);
        g2d.drawImage(new ImageIcon("images/Ghost2.png").getImage(), 250, 600, this);
        g2d.drawImage(new ImageIcon("images/Ghost3.png").getImage(), 300, 600, this);
        g2d.drawImage(new ImageIcon("images/Ghost4.png").getImage(), 350, 600, this);

        FontMetrics metricsMedium = g2d.getFontMetrics(medium);
        FontMetrics metricsLarge = g2d.getFontMetrics(large);

        g2d.setColor(Color.black);
        g2d.setFont(medium);
        g2d.drawString(w, (dimension.width / 2) - (metricsMedium.stringWidth(w) / 2), 100);

        g2d.setFont(large);
        g2d.drawString(m, (dimension.width / 2) - (metricsLarge.stringWidth(m) / 2), 250);

        g2d.setFont(small);
        g2d.drawString(s, 165, 400);
        g2d.drawString(l, 165, 450);
        g2d.drawString(c, 165, 500);
    }

    /**
     * Draws the game over screen on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void showGameOver(Graphics2D g2d) {
        FontMetrics metricsLarge = g2d.getFontMetrics(large);
        FontMetrics metricsSmall = g2d.getFontMetrics(small);

        String s = "GAME OVER";
        String l = pacMemeGame.getUserName() + "'s score: " + pacMemeGame.getScore();

        g2d.setColor(Color.black);
        g2d.setFont(large);
        g2d.drawString(s, (dimension.width / 2) - (metricsLarge.stringWidth(s) / 2), 300);

        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString(l, (dimension.width / 2) - (metricsSmall.stringWidth(l) / 2), 400);
    }

    /**
     * Draws the control screen on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void showControl(Graphics2D g2d) {
        FontMetrics metricsLarge = g2d.getFontMetrics(large);
        FontMetrics metricsMedium = g2d.getFontMetrics(medium);

        String c = "Game Controls";
        String l = "\u2190 or A : Left";
        String u = "\u2191 or W : Up";
        String r = "\u2192 or D : Right";
        String d = "\u2193 or S : Down";

        g2d.setColor(Color.black);
        g2d.setFont(large);
        g2d.drawString(c, (dimension.width / 2) - (metricsLarge.stringWidth(c) / 2), 130);

        g2d.setFont(medium);
        g2d.drawString(l, (dimension.width / 2) - (metricsMedium.stringWidth(l) / 2), 300);
        g2d.drawString(u, (dimension.width / 2) - (metricsMedium.stringWidth(u) / 2), 400);
        g2d.drawString(r, (dimension.width / 2) - (metricsMedium.stringWidth(r) / 2), 500);
        g2d.drawString(d, (dimension.width / 2) - (metricsMedium.stringWidth(d) / 2), 600);
    }

    /**
     * Draws the leaderboard on the Graphics 2D board.
     *
     * @param g2d 2d graphics for what is on the JPanel.
     */
    private void showLeaderboard(Graphics2D g2d) {
        FontMetrics metricsLarge = g2d.getFontMetrics(large);
        FontMetrics metricsSmall = g2d.getFontMetrics(small);

        g2d.drawImage(new ImageIcon("images/funny2.jpg").getImage(), 20, 500, this);

        g2d.setColor(Color.black);
        g2d.setFont(large);
        g2d.drawString("Leaderboard", (dimension.width / 2) - (metricsLarge.stringWidth("Leaderboard") / 2), 130);

        ArrayList<ScoreEntry> scores = pacMemeGame.readInScores();
        int yOffset = 40;
        int y = 230;
        g2d.setFont(small);

        if (scores.size() == 0) {
            g2d.drawString("There are no scores yet", (dimension.width / 2) - (metricsSmall.stringWidth("There are no scores yet") / 2), y);
        } else {
            for (ScoreEntry score : scores) {
                g2d.drawString(score.toString(), (dimension.width / 2) - (metricsSmall.stringWidth(score.toString()) / 2), y);
                y += yOffset;
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
                if (!inLeaderboard && !inControl) {
                    if (key == KeyEvent.VK_SPACE) {

                        // Create box
                        Box box = Box.createHorizontalBox();
                        JLabel label = new JLabel("Enter your name: ");
                        box.add(label);
                        JTextField textField = new JTextField(16);
                        box.add(textField);
                        final ImageIcon icon = new ImageIcon("images/link.png");

                        int test = JOptionPane.showConfirmDialog(null, box, "Player Name",  JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
                        if (test == JOptionPane.OK_OPTION && textField.getText().length() != 0) {
                            pacMemeGame.setUserName(textField.getText());
                            inGame = true;
                        }
                    }
                }
                if (key == KeyEvent.VK_L && !inControl) {
                    inLeaderboard = !inLeaderboard;
                }
                if  (key == KeyEvent.VK_C && !inLeaderboard) {
                    inControl = !inControl;
                }
            }
        }
    }

    /**
     * Repaints JPanel every time actionPerformed is called.
     *
     * @param e the event action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

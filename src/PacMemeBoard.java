import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

public class PacMemeBoard extends JPanel implements ActionListener {

    private Dimension dimension;

    private Image ii;

    private boolean inGame = false;
    private boolean dead = false;

    private Timer timer;

    private PacMemeGame pacMemeGame;

    /**
     * Constructor class.
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    /**
     * Draws everything on the screen over and over and over
     * and over and over and over and over. Over again and again.
     *
     * @param g
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        if (inGame) {
//            doAnim(); -> this will update the PacMeme sprite once we have that set up
            playGame(g2d);
        } else {
            showMainMenu(g2d);
        }

        g2d.drawImage(ii, 5, 5, this);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

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
     * Basically the game loop for the Meme-Man and Meme-Ghosts
     *
     * @param g2d
     */
    private void playGame(Graphics2D g2d) {
        if (dead) {
            // ded
        } else {
            pacMemeGame.getMemeMan().moveMemeMan();
            drawBoard(g2d);
            pacMemeGame.collisionDetections();

            //move ghosts, draw ghosts, check the maze for death.
        }
    }

    /**
     * Draws Meme-Man on the Graphics 2D board
     *
     * @param g2d
     */
    private void drawMemeMan(Graphics2D g2d) {
        MemeMan memeMan = pacMemeGame.getMemeMan();
        g2d.drawImage(memeMan.getMemeMan(), memeMan.getMemeMan_X(), memeMan.getMemeMan_Y(), this);
    }

    private void drawGhosts(Graphics2D g2d) {
        for (Ghost ghost : pacMemeGame.getGhosts()) {
            if (ghost.getVisibility()) {
                g2d.drawImage(ghost.getGhost(), ghost.getGhostLocation_X(), ghost.getGhostLocation_Y(), this);
            }
        }
    }

    private void drawDots(Graphics2D g2d) {
        for (Dot dot : pacMemeGame.getDots()) {
            if (dot.isVisible()) {
                g2d.drawImage(dot.getImage(), dot.getX(), dot.getY(), this);
            }
        }
    }

    private void drawFruit(Graphics2D g2d) {
        for (Fruit fruit : pacMemeGame.getFruit()) {
            g2d.drawImage(fruit.getImage(), fruit.getX(), fruit.getY(), this);
        }
    }

    private void drawPowerUps(Graphics2D g2d) {
        for (PowerUp powerUp : pacMemeGame.getPowerUps()) {
            g2d.drawImage(powerUp.getImage(), powerUp.getX(), powerUp.getY(), this);
        }
    }

    private void drawWalls(Graphics2D g2d) {
        for (Wall wall : pacMemeGame.getWalls()) {
            g2d.drawImage(wall.getWall(), wall.getWallLocation_X(), wall.getWallLocation_Y(), this);
        }
    }

    /**
     * Draws the score on the Graphics 2D board
     * in this method
     *
     * @param g2d
     */
    private void drawScore(Graphics2D g2d) {
        Font small = new Font("Helvetica", Font.BOLD, 14);
        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString("Score:      " + pacMemeGame.getScore(), 10, 770);
    }

    private void showMainMenu(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        String s = "Press space bar to start.";
        Font small = new Font("Helvetica", Font.BOLD, 14);

        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString(s, 160, 230);
    }


    class Keyboard extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    pacMemeGame.getMemeMan().setMemeManSpeed(-3, 0);
                } else if (key == KeyEvent.VK_RIGHT) {
                    pacMemeGame.getMemeMan().setMemeManSpeed(3, 0);
                } else if (key == KeyEvent.VK_UP) {
                    pacMemeGame.getMemeMan().setMemeManSpeed(0, -3);
                } else if (key == KeyEvent.VK_DOWN) {
                    pacMemeGame.getMemeMan().setMemeManSpeed(0, 3);
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

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
    private boolean savingScores = false;
    private boolean viewingLeaderboard = false;

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
            playGame(g2d);
        } else if (savingScores) { 
        	// Only true if player beats game (all collectable objects isVisible = false)
        	// UI for saving score (enter initials and write score to CSV) --> showSavingScores()
        } else if (viewingLeaderboard) {
        	showLeaderboard(g2d);
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
            pacMemeGame.collisionDetections();
            pacMemeGame.getMemeMan().moveMemeMan();
            drawBoard(g2d);
            
            if (isGameOver()) {
        		inGame = false;
            	if (pacMemeGame.shouldSaveScores()) {
            		savingScores = true;
            	}
            }
        }
    }

    private boolean isGameOver() {
    	for (Dot dot : pacMemeGame.getDots()) {
    		if (dot.isVisible()) {
    			return false;
    		}
    	}
    	for (Ghost ghost : pacMemeGame.getGhosts()) {
    		if (ghost.getVisibility()) {
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
            if (fruit.isVisible()) {
            	g2d.drawImage(fruit.getImage(), fruit.getX(), fruit.getY(), this);
            }
        }
    }

    private void drawPowerUps(Graphics2D g2d) {
        for (PowerUp powerUp : pacMemeGame.getPowerUps()) {
            if (powerUp.isVisible()) {
                g2d.drawImage(powerUp.getImage(), powerUp.getX(), powerUp.getY(), this);
            }
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
        String l = "Press 'L' to toggle leaderboard.";
        Font small = new Font("Helvetica", Font.BOLD, 14);

        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString(s, 160, 230);
        
        g2d.setColor(Color.black);
        g2d.setFont(small);
        g2d.drawString(l, 160, 260);
    }
    
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
    
    private void showSavingScores(Graphics2D g2d) {
    	
    	// collect player name as user inputs; pass to saveHighScores() [see PacMemeGame class]
    	// once player score has been written to CSV; display leaderboard
    	
    	savingScores = false;
    	viewingLeaderboard = true;
    	
    }

    class Keyboard extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    pacMemeGame.getMemeMan().setMemeManSpeed(-3, 0);
                    pacMemeGame.getMemeMan().setValidMove(true);
                } else if (key == KeyEvent.VK_RIGHT) {
                    pacMemeGame.getMemeMan().setMemeManSpeed(3, 0);
                    pacMemeGame.getMemeMan().setValidMove(true);
                } else if (key == KeyEvent.VK_UP) {
                    pacMemeGame.getMemeMan().setMemeManSpeed(0, -3);
                    pacMemeGame.getMemeMan().setValidMove(true);
                } else if (key == KeyEvent.VK_DOWN) {
                    pacMemeGame.getMemeMan().setMemeManSpeed(0, 3);
                    pacMemeGame.getMemeMan().setValidMove(true);
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
            	if (!viewingLeaderboard && !savingScores) {
                	if (key == KeyEvent.VK_SPACE) {
                        inGame = true;
                        //initGame();
                    }
            	}
                if (key== KeyEvent.VK_L) {
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

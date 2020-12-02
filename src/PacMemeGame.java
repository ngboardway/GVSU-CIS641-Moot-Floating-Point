import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * PacMemeGame. This class controls the logic of the game.
 * <p>
 * * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * * @version Fall 2020
 */
public class PacMemeGame {

    /**
     * 2D array for where the pieces will be placed on the map
     */
    private int[][] gameBoard;

    /**
     * Instance of MemeMan for the game
     */
    private MemeMan memeMan;

    /**
     * The Score that the player currently has
     */
    private int score;

    /**
     * ArrayList of Dot objects that will be on the board
     */
    private ArrayList<Dot> dots = new ArrayList<Dot>();

    /**
     * ArrayList of Wall objects that will be on the board
     */
    private ArrayList<Wall> walls = new ArrayList<Wall>();

    /**
     * ArrayList of Fruit objects that will be on the board
     */
    private ArrayList<Fruit> fruits = new ArrayList<Fruit>();

    /**
     * ArrayList of PowerUp objects that will be on the board
     */
    private ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();

    /**
     * ArrayList of Ghost objects that will be on the board
     */
    private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();

    /**
     * Constructor method to set the variables and board.
     */
    public PacMemeGame() {
        initVariables();
        createBoard();
    }

    /**
     * Sets all of the variables we will be using during the game.
     */
    public void initVariables() {
        score = 0;

        // populating game board
        gameBoard = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 4, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 4, 0},
                {0, 1, 0, 1, 0, 5, 1, 0, 1, 5, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 0, 3, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 5, 0, 3, 3, 3, 0, 5, 0, 0, 1, 0},
                {0, 1, 0, 1, 1, 0, 0, 3, 0, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 5, 1, 1, 0, 1, 0, 1, 1, 5, 0, 1, 0},
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
                {0, 4, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    }

    /**
     * Sets the location of each object that will be on the board
     */
    private void createBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int column = 0; column < gameBoard[row].length; column++) {

                int position = gameBoard[row][column];

                if (position == 0) {
                    walls.add(new Wall(column * 50, row * 50));
                } else if (position == 1) {
                    dots.add(new Dot(column * 50, row * 50));
                } else if (position == 2) {
                    memeMan = new MemeMan(column * 50 + 5, row * 50 + 5);
                } else if (position == 3) {
                    ghosts.add(new Ghost(column * 50, row * 50));
                } else if (position == 4) {
                    powerUps.add(new PowerUp(column * 50, row * 50));
                } else if (position == 5) {
                    fruits.add(new Fruit(column * 50, row * 50));
                }
            }
        }
    }

    /**
     * Does all of the collision detection for the game. Determines if Meme-Man should
     * stop moving due to being in front of a wall. If dots, power-ups, fruit, or ghost
     * have been captured, removes them and increments score if so.
     */
    public void collisionDetections() {
        Rectangle r1 = memeMan.getBounds();

        //checks the walls
        for (Wall wall : walls) {
            Rectangle r2 = wall.getBounds();
            if (memeMan.getDirection().equals("left")) {
                double memeX = r1.getMinX();
                double wallX = r2.getMaxX();

                if (wall.getX() < memeMan.getX()) {
                    boolean topCornerCrossed = (wall.getY() + 50 > memeMan.getY() &&
                            memeMan.getY() >= wall.getY());

                    boolean bottomCornerCrossed = (wall.getY() + 50 > memeMan.getY() + 40 &&
                            memeMan.getY() + 40 >= wall.getY());

                    if (topCornerCrossed || bottomCornerCrossed) {
                        if ((memeX - 3.0) <= wallX) {
                            memeMan.setValidMove(false);
                        }
                    }
                }
            } else if (memeMan.getDirection().equals("right")) {
                double topRightMemeCorner = r1.getMaxX();
                double wallX = r2.getMinX();

                if (wall.getX() > memeMan.getX()) {
                    boolean topCornerCrossed = (wall.getY() + 50 > memeMan.getY() &&
                            memeMan.getY() >= wall.getY());

                    boolean bottomCornerCrossed = (wall.getY() + 50 > memeMan.getY() + 40 &&
                            memeMan.getY() + 40 >= wall.getY());

                    if (topCornerCrossed || bottomCornerCrossed) {
                        if ((topRightMemeCorner + 3.0) >= wallX) {
                            memeMan.setValidMove(false);
                        }
                    }
                }
            } else if (memeMan.getDirection().equals("up")) {
                double memeY = r1.getMinY();
                double wallY = r2.getMaxY();

                if (wall.getY() < memeMan.getY()) {
                    boolean leftCornerCrossed = (wall.getX() + 50 > memeMan.getX() &&
                            memeMan.getX() >= wall.getX());

                    boolean rightCornerCrossed = (wall.getX() + 50 > memeMan.getX() + 40 &&
                            memeMan.getX() + 40 >= wall.getX());

                    if (leftCornerCrossed || rightCornerCrossed) {
                        if ((memeY - 3.0) <= wallY) {
                            memeMan.setValidMove(false);
                        }
                    }
                }
            } else {
                double memeY = r1.getMaxY();
                double wallY = r2.getMinY();

                if (wall.getY() > memeMan.getY()) {
                    boolean leftCornerCrossed = (wall.getX() + 50 > memeMan.getX() &&
                            memeMan.getX() >= wall.getX());

                    boolean rightCornerCrossed = (wall.getX() + 50 > memeMan.getX() + 40 &&
                            memeMan.getX() + 40 >= wall.getX());

                    if (leftCornerCrossed || rightCornerCrossed) {
                        if ((memeY + 3.0) >= wallY) {
                            memeMan.setValidMove(false);
                        }
                    }
                }
            }
        }


        // checks the dots
        for (Dot dot : dots) {
            if (dot.isVisible()) {
                Rectangle r2 = dot.getBounds();
                if (r1.intersects(r2)) {
                    dot.setVisibility(false);
                    score += dot.getPointValue();
                }
            }
        }

        // checks the PowerUp
        for (PowerUp powerUp : powerUps) {
            if (powerUp.isVisible()) {
                Rectangle r2 = powerUp.getBounds();
                if (r1.intersects(r2)) {
                    powerUp.setVisibility(false);
                    score += powerUp.getPointValue();
                    // Boolean for power up mode here and activate it
                }
            }
        }

        // checks the ghost
        for (Ghost ghost : ghosts) {
            // ghost are visible and power up is active
            if (ghost.getVisibility()) {
                Rectangle r2 = ghost.getBounds();
                if (r1.intersects(r2)) {
                    ghost.setVisibility(false);
                    score += ghost.getPointValue();
                }
            } // else kill Meme-Men if they touch

        }

        // checks the fruit
        for (Fruit fruit : fruits) {
            if (fruit.isVisible()) {
                Rectangle r2 = fruit.getBounds();
                if (r1.intersects(r2)) {
                    fruit.setVisibility(false);
                    score += fruit.getPointValue();
                }
            }
        }
    }


    /**
     * Getter method for getting the memeMan object.
     *
     * @return memeMan the Meme-Man object.
     */
    public MemeMan getMemeMan() {
        return memeMan;
    }

    /**
     * Getter method for getting the the players score.
     *
     * @return score The score of the game.
     */
    public int getScore() {
        return score;
    }

    /**
     * Getter method for getting the ArrayList of Dot objects.
     *
     * @return dots The dot objects.
     */
    public ArrayList<Dot> getDots() {
        return dots;
    }

    /**
     * Getter method for getting the ArrayList of PowerUp objects.
     *
     * @return powerUps The power-up objects.
     */
    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    }

    /**
     * Getter method for getting the ArrayList of Fruit objects.
     *
     * @return fruits The fruit objects.
     */
    public ArrayList<Fruit> getFruit() {
        return fruits;
    }

    /**
     * Getter method for getting the ArrayList of Wall objects.
     *
     * @return walls The wall objects.
     */
    public ArrayList<Wall> getWalls() {
        return walls;
    }

    /**
     * Getter method for getting the ArrayList of Dot objects.
     *
     * @return dots The dots.
     */
    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    /**
     * Setter for setting the players score.
     *
     * @param score the players score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Determines if the current player's score should be saved in
     * the high score board. If the current score is higher than the
     * smallest score in the score board then it needs to be saved.
     *
     * @return if the current score should be saved
     */
    public boolean shouldSaveScores() {
        List<ScoreEntry> highScores = readInScores();
        return score > highScores.get(highScores.size() - 1).getScore();
    }

    /**
     * Saves the current game's score to the file of high scores.
     *
     * @param playerName the current players name
     */
    public void saveHighScores(String playerName) {
        ArrayList<ScoreEntry> existingScores = readInScores();
        existingScores.add(new ScoreEntry(score, playerName));
        existingScores.sort(new ScoreEntryComparator());

        // only keep up to the top ten (fewer if there are not yet ten)
        int index = existingScores.size() > 10 ? 10 : existingScores.size();
        List<ScoreEntry> updatedScores = existingScores.subList(0, index);
        writeScores(updatedScores);
    }

    /**
     * Writes all of the high scores to the file.
     *
     * @param scores a list of the high scores
     */
    private void writeScores(List<ScoreEntry> scores) {
        try {
            File scoreFile = GetScoreFile();
            // if the score file already exists, recreate it since that's easier
            // than trying to insert a new line somewhere in the middle of the file.
            if (scoreFile.exists()) {
                scoreFile.delete();
            }
            scoreFile.createNewFile();

            FileWriter outFile = new FileWriter(scoreFile);
            for (ScoreEntry entry : scores) {
                outFile.write(entry.getPlayer() + "," + entry.getScore() + "\n");
            }

            outFile.close();
        } catch (IOException e) {

        }
    }

    /**
     * Reads in the scores saved in the csv, creates a collection of java objects representing
     *  these scores and sorts them.
     *
     * @return a sorted array list of all of the high scores.
     */
    public ArrayList<ScoreEntry> readInScores() {
        try {
            ArrayList<ScoreEntry> allScores = new ArrayList<ScoreEntry>();
            Scanner scanner = new Scanner(GetScoreFile());
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                allScores.add(processEntry(data));
            }
            allScores.sort(new ScoreEntryComparator());
            scanner.close();

            return allScores;
        } catch (FileNotFoundException e) {
            return new ArrayList<ScoreEntry>();
        }
    }

    /**
     * Parses a given line from the csv and returns a java representation of
     * that player and their score.
     *
     * @param data
     * @return
     */
    private ScoreEntry processEntry(String data) {
        String[] scoreData = data.split(",");
        String scoreString = scoreData[1];
        int score = Integer.parseInt(scoreString);
        return new ScoreEntry(score, scoreData[0]);
    }

    /**
     * Gets the file that holds all of the high scores
     *
     * @return a file of the high scores
     */
    private File GetScoreFile() {
        return new File("scores.csv");
    }

    /**
     *
     */
    class ScoreEntryComparator implements Comparator<ScoreEntry> {
        @Override
        public int compare(ScoreEntry o1, ScoreEntry o2) {
            return o2.getScore() - o1.getScore();
        }
    }
}

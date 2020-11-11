import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PacMemeGame {

    private int[][] gameBoard;
    private MemeMan memeMan;

    private int score;

    private ArrayList<Dot> dots = new ArrayList<Dot>();
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Fruit> fruit = new ArrayList<Fruit>();
    private ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
    private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();

    public PacMemeGame() {
        initVariables();
        createBoard();
    }

    public void initVariables() {
        score = 0;

        // populating game board
        gameBoard = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 1, 0, 3, 3, 3, 0, 1, 0, 0, 1, 0},
                {0, 1, 0, 1, 1, 0, 0, 3, 0, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    }

    private void createBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int column = 0; column < gameBoard[row].length; column++) {

                int position = gameBoard[row][column];

                if (position == 0) {
                    walls.add(new Wall(column * 50, row * 50));
                } else if (position == 1) {
                    dots.add(new Dot(column * 50, row * 50));
                } else if (position == 2) {
                    memeMan = new MemeMan(column * 50, row * 50);
                } else if (position == 3) {
                    ghosts.add(new Ghost(column * 50, row * 50));
                }
            }
        }
    }

    public MemeMan getMemeMan() {
        return memeMan;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Dot> getDots() {
        return dots;
    }

    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    }

    public ArrayList<Fruit> getFruit() {
        return fruit;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    /*
        Is the score for the current game higher than the lowest score in the
        collection of high scores?
     */
    public boolean shouldSaveScores() {
        List<ScoreEntry> highScores = readInScores();
        return score > highScores.get(highScores.size() - 1).score;
    }

    public void saveHighScores(String playerName) {
        ArrayList<ScoreEntry> existingScores = readInScores();
        existingScores.add(new ScoreEntry(score, playerName));
        existingScores.sort(new ScoreEntryComparator());

        int index = existingScores.size() > 10 ? 10 : existingScores.size();
        List<ScoreEntry> updatedScores = existingScores.subList(0, index); // only keep the top ten
        writeScores(updatedScores);
    }

    private void writeScores(List<ScoreEntry> scores) {
        try {
            File scoreFile = GetScoreFile();
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

    /*
     * Will be used to read in the list of high scores both
     * to display them and add a new high score
     */
    private ArrayList<ScoreEntry> readInScores() {
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

    private ScoreEntry processEntry(String data) {
        String[] scoreData = data.split(",");
        String scoreString = scoreData[1];
        int score = Integer.parseInt(scoreString);
        return new ScoreEntry(score, scoreData[0]);
    }

    private File GetScoreFile() {
        return new File("scores.csv");
    }

    class ScoreEntry {
        private int score;
        private String player;

        ScoreEntry(int score, String player) {
            this.score = score;
            this.player = player;
        }

        public int getScore() {
            return score;
        }

        public String getPlayer() {
            return player;
        }
    }

    class ScoreEntryComparator implements Comparator<ScoreEntry> {
        @Override
        public int compare(ScoreEntry o1, ScoreEntry o2) {
            return o2.score - o1.score;
        }
    }

    public void collisionDetections() {

        Rectangle r1 = memeMan.getBounds();

        //checks the walls
        for (Wall wall: walls) {
            Rectangle r2 = wall.getBounds();
            if(r1.intersects(r2)) {
                //memeMan.setValidMove(false);
                //need to figure something out to get it to stop and start
            }
        }

        //checks the dots
        for (Dot dot: dots){
            if (dot.isVisible()) {
                Rectangle r2 = dot.getBounds();
                if (r1.intersects(r2)) {
                    dot.setVisibility(false);
                    //increment score here?
                    score += dot.getPointValue();
                }
            }
        }

        //checks the ghost
        for (Ghost ghost: ghosts){
            if (ghost.getVisibility()) {
                Rectangle r2 = ghost.getBounds();
                if (r1.intersects(r2)) {
                    ghost.setVisibility(false);
                    //increment score here?
                    //need to also set a point value to ghost
                    score += 50;
                }
            }
        }


    }


}

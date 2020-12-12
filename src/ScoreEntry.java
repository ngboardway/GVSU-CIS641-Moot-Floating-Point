/**
 * ScoreEntry. Controls the ScoreEntry object.
 *
 * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * @version Fall 2020
 */
public class ScoreEntry {

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
    
    @Override
    public String toString() {
    	return player + " | " + score;
    }
}

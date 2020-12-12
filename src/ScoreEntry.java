/**
 * ScoreEntry. Controls the ScoreEntry object.
 *
 * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * @version Fall 2020
 */
public class ScoreEntry {
    /**
     * The score of the player.
     */
    private final int score;

    /**
     * The players name.
     */
    private final String player;

    /**
     * Constructor for setting the score and players name.
     *
     * @param score Integer of the players score.
     * @param player String of the players name.
     */
    ScoreEntry(int score, String player) {
        this.score = score;
        this.player = player;
    }

    /**
     * Getter for getting the players score.
     *
     * @return score The score of the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Getter for getting the players name.
     *
     * @return player The players name.
     */
    public String getPlayer() {
        return player;
    }

    /**
     * Overriding toString to return the players name and score in one string.
     *
     * @return The players name and score in one string.
     */
    @Override
    public String toString() {
    	return player + " | " + score;
    }
}

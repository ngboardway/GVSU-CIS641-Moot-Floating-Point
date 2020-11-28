
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

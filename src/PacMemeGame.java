import java.awt.Graphics2D;
import java.util.ArrayList;

public class PacMemeGame {
	
    private int[][] gameBoard;
    private MemeMan memeMan;
    
    private int score;
    
	private ArrayList<Dot> dots = new ArrayList<Dot>();
    private ArrayList<Wall> walls = new ArrayList<Wall>();
        
	public PacMemeGame() {
		initVariables();
		createBoard();		
	}
	
	public void initVariables() {
		
        score = 0;
		
		// populating game board    
		gameBoard = new int[][]{
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,1,1,1,1,1,0,0,0,1,1,1,1,1,0},
		{0,1,0,1,0,1,1,0,1,1,0,1,0,1,0},
		{0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
		{0,1,0,1,1,0,1,0,1,0,1,1,0,1,0},
		{0,1,0,0,1,1,1,1,1,1,1,0,0,1,0},
		{0,1,1,1,1,0,0,1,0,0,1,1,1,1,0},
		{0,1,0,0,1,0,1,1,1,0,1,0,0,1,0},
		{0,1,0,1,1,0,0,0,0,0,1,1,0,1,0},
		{0,1,1,1,0,0,0,1,0,0,0,1,1,1,0},
		{0,1,0,1,0,1,1,1,1,1,0,1,0,1,0},
		{0,1,0,1,1,1,0,1,0,1,1,1,0,1,0},
		{0,1,0,0,1,0,0,1,0,0,1,0,0,1,0},
		{0,1,1,1,1,1,1,2,1,1,1,1,1,1,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
				
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
    
    
    // setscore add here


	public ArrayList<Dot> getDots() {
		return dots;
	}


	public ArrayList<Wall> getWalls() {
		return walls;
	}
	
}

import javax.swing.*;
import java.awt.*;

/**
 * Ghost. Controls the ghost object.
 *
 * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * @version Fall 2020
 */
public class Ghost extends Actor {

    /**
     * The point value of the ghost.
     */
    private final int pointValue;
    
    /**
     * Determines random direction of ghost movement.
     */
    private int randomDirection;
    
    /**
     * Starting x coordinate for ghost.
     */
    private int startingX;
    
    /**
     * Starting y coordinate for ghost.
     */
    private int startingY;

	/**
     * Constructor to set the ghosts starting location, point value, and image icon that will be used.
     *
     * @param x x-axis location.
     * @param y y-axis location.
     */
    protected Ghost(int x, int y) {
        super(x, y);
        setImage(this.getRandomImage());
        pointValue = 50;
    }
    
    /**
     * Creates a random number between representing a cardinal direction and assigns to randomDirection.
     */
    public void setRandomDirection() {
    	randomDirection = (int) ((Math.random() * 4) + 1);
    }
    
    /**
     * Getter for randomDirection value of the ghost object.
     *
     * @return randomDirection value of the ghost.
     */
    public int getRandomDirection() {
    	return randomDirection;
    }
    
    /**
	 *  Getter for starting position on x-axis.
	 * @return startingX The starting x position.
     */
    public int getStartingX() {
		return startingX;
	}

    /**
     * Setter for starting position on x-axis.
     * @param startingX The starting x position.
     */
	public void setStartingX(int startingX) {
		this.startingX = startingX;
	}

	/**
	 *  Getter for starting position on y-axis.
	 * @return startingY The starting y position.
	 */
	public int getStartingY() {
		return startingY;
	}

    /**
     * Setter for starting position on y-axis.
     * @param startingY The starting y position.
     */
	public void setStartingY(int startingY) {
		this.startingY = startingY;
	}

    /**
     * Creates a random number and returns one of the ghost images associated with that number.
     *
     * @return ImageIcon of the ghost associated with the random number that was generated.
     */
    protected Image getRandomImage() {
        int num = (int) ((Math.random() * (9 - 1)) + 1);
        return new ImageIcon("images/Ghost" + num + ".png").getImage();
    }

    /**
     * Getter to get the point value of the ghost object.
     *
     * @return pointValue The point value of the ghost.
     */
    public int getPointValue() {
    	return pointValue;
    }
    
}

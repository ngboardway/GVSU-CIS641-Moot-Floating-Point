import javax.swing.*;
import java.awt.*;

/**
 * Ghost. Controls the ghost object.
 *
 *  * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 *  * @version Fall 2020
 */
public class Ghost extends Actor{

    /** The point value of the ghost */
    private final int pointValue;

    /**
     * Sets the ghosts starting location, point value, and image icon that will be used.
     *
     * @param x x-axis location
     * @param y y-axis location
     */
    protected Ghost(int x, int y) {
        super(x, y);
        setImage(this.getRandomImage());
        pointValue = 50;
    }
    protected Image getRandomImage() {
        int num = getRandomNumber(1, 9);
        return new ImageIcon("images/Ghost" + num + ".png").getImage();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
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

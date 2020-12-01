import javax.swing.*;
import java.awt.*;

public class Ghost extends Actor{

    Image ghost;

    /** The point value of the ghost */
    private final int pointValue;

    /**
     * Sets the ghost location, point value, and image icon that will be used.
     *
     * @param x x-axis location
     * @param y y-axis location
     */
    protected Ghost(int x, int y) {
        super(x, y,  new ImageIcon("images/ghost.jpg").getImage());
        pointValue = 50;
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

import javax.swing.*;
import java.awt.*;

/**
 * Dot. Controls the dot object.
 *
 * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * @version Fall 2020
 */
public class Dot extends Collectable {

    /**
     * Constructor to set the dot's location, point value, and image icon that will be used.
     *
     * @param x x-axis location.
     * @param y y-axis location.
     */
    public Dot(int x, int y) {
        super(x, y, 10, new ImageIcon("images/dot.png").getImage());
    }

    /**
     * Getter for getting a rectangle object of the dot. Overriding and reducing because the image
     * size is 50px but the dot is smaller. Removing the white from being counted in the collision detection.
     *
     * @return a rectangle object of the dot.
     */
    public Rectangle getBounds() {
        return new Rectangle(getX() + 20, getY() + 20, image.getWidth(null) - 40, image.getHeight(null) - 40);
    }
}

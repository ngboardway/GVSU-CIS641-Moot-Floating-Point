import javax.swing.*;
import java.awt.*;

/**
 * Dot. Controls the dot object.
 *
 *  * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 *  * @version Fall 2020
 */
public class Dot extends Collectable {

    /**
     * Sets the dot's location, point value, and image icon that will be used.
     *
     * @param x x-axis location
     * @param y y-axis location
     */
    public Dot(int x, int y) {
        super(x, y, 10,  new ImageIcon("images/dot.png").getImage());
    }

    /**
     * Getter for getting a rectangle object of the dot. Overriding and reducing by 20 because the image
     * size is 50px but the dot is only 10px. Removing the white from being counted in the collision  detection.
     *
     * @return a rectangle object of the dot.
     */
    public Rectangle getBounds() {
        return new Rectangle(super.getX() + 20, super.getY() + 20, image.getWidth(null)-20, image.getHeight(null)-20);
    }
}

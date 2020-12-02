import javax.swing.*;
import java.awt.*;

/**
 * PowerUp. Controls the power-up object.
 * <p>
 * * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * * @version Fall 2020
 */
public class PowerUp extends Collectable {

    /**
     * Sets the power-ups location, point value, and image icon that will be used.
     *
     * @param x x-axis location
     * @param y y-axis location
     */
    public PowerUp(int x, int y) {
        super(x, y, 25, new ImageIcon("images/powerup.png").getImage());
    }

    /**
     * Getter for getting a rectangle object of the power-up. Overriding and reducing by 5px because the image
     * size is 50px but the power-up is only 40px. Removing the white from being counted in the collision detection.
     *
     * @return a rectangle object of the power-up.
     */
    public Rectangle getBounds() {
        return new Rectangle(getX() + 5, getY() + 5, image.getWidth(null) - 5, image.getHeight(null) - 5);
    }
}

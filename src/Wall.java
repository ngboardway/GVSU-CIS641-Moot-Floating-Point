import javax.swing.*;
import java.awt.*;

/**
 * Wall. Controls the wall object.
 *
 * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * @version Fall 2020
 */
public class Wall {

    /**
     * Image icon of the wall.
     */
    Image image;

    /**
     * Location of the wall on the x-axis.
     */
    private final int x;

    /**
     * Location of the wall on the x-axis.
     */
    private final int y;

    /**
     * Constructor for setting the walls x location, y location, and the image.
     *
     * @param x x-axis location.
     * @param y y-axis location.
     */
    protected Wall(int x, int y) {
        image = new ImageIcon("images/wall.png").getImage();
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for getting the image of the wall.
     *
     * @return image the Image of the object.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Getter for getting the x-axis location for the wall.
     *
     * @return x x-axis location.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for getting the y-axis location for the wall.
     *
     * @return y y-axis location.
     */
    public int getY() {
        return y;
    }

    /**
     * Getter for getting a rectangle object of the wall.
     *
     * @return a rectangle object of the wall.
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}

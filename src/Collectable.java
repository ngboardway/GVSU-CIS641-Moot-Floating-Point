import java.awt.*;

/**
 * Collectable. Class that will be inherited by Dot, PowerUp, and Fruit and
 * contains all common methods/functions they will be using.
 *
 *  * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 *  * @version Fall 2020
 */
public abstract class Collectable {

    /** Location of the collectable on the x-axis */
    private final int x;

    /** Location of the collectable on the y-axis */
    private final int y;

    /** Point value of the given collectable */
    private final int pointValue;

    /** Boolean if the collectable is visible on the board */
    private boolean isVisible;

    /** Image icon of the collectable */
    final Image image;

    /**
     * Default constructor for setting the actors x location, y location,
     * and the image.
     * @param x x-axis location of the actor.
     * @param y y-axis location of the actor.
     * @param pointValue the point value of the collectable.
     * @param image image of the actor.
     */
    public Collectable(int x, int y, int pointValue, Image image) {
        this.x = x;
        this.y = y;
        this.pointValue = pointValue;
        this.image = image;
        isVisible = true;
    }

    /**
     * Getter for getting the x-axis location for the collectable.
     *
     * @return x x-axis location.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for getting the y-axis location for the collectable.
     *
     * @return y y-axis location.
     */
    public int getY() {
        return y;
    }

    /**
     * Getter for getting the point value for the collectable.
     *
     * @return pointValue the point value.
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * Getter for getting the visibility of the collectable.
     *
     * @return isVisible if the object is visible .
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Getter for getting the image of the collectable.
     *
     * @return image the Image of the object.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Getter for getting a rectangle object of the collectable.
     *
     * @return a rectangle object of the collectable.
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }

    /**
     * Setter for setting the visibility on the collectable.
     *
     * @param visibility If the collectable is visible.
     */
    public void setVisibility(boolean visibility) {
        isVisible = visibility;
    }
}

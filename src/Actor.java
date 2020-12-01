import javax.swing.*;
import java.awt.*;

/**
 * Actor. Class that will be inherited by Ghost and MemeMan, it
 * contains all common methods/functions they will be using.
 *
 *  * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 *  * @version Fall 2020
 */
public abstract class  Actor {

    Image image;

    /** Location of the actor on the x-axis */
    private int x;

    /** Location of the actor on the y-axis */
    private int y;

    /** Integer to represent the speed on the x-axis the actor is moving */

    private int speedX;

    /** Integer to represent the speed on the y-axis the actor is moving */
    private int speedY;

    /** Boolean if the actor is visible on the board */
    private boolean isVisible;

    /**
     * Default constructor for setting the actors x location, y location,
     * and the image.
     * @param x x-axis location of the actor.
     * @param y y-axis location of the actor.
     * @param image image of the actor.
     */
    protected Actor(int x, int y, Image image){
        this.image = image;
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    /**
     * Getter for getting the image of the actor.
     *
     * @return image the Image of the actor.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Getter for getting the x-axis location for the actor.
     *
     * @return x x-axis location.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for getting the y-axis location for the actor.
     *
     * @return y y-axis location.
     */
    public int getY() {
        return y;
    }

    /**
     * Getter for getting a rectangle object of the actor.
     *
     * @return a rectangle object of the actor.
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }

    /**
     * Getter for getting teh visibility on the actor.
     *
     * @return isVisible If the actor is visible.
     */
    public boolean getVisibility() {
        return isVisible;
    }

    /**
     * Setter for setting the visibility on the actor.
     *
     * @param visibility If the actor is visible.
     */
    public void setVisibility(boolean visibility) {
        isVisible = visibility;
    }


}

import javax.swing.*;
import java.awt.*;

/**
 * Actor. Class that will be inherited by Ghost and MemeMan, it
 * contains all common methods/functions they will be using.
 * <p>
 * * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * * @version Fall 2020
 */
public abstract class Actor {

    /**
     * Location of the actor on the x-axis
     */
    private int x;

    /**
     * Location of the actor on the y-axis
     */
    private int y;

    /**
     * Integer to represent the speed on the x-axis the actor is moving
     */

    private int speedX;

    /**
     * Integer to represent the speed on the y-axis the actor is moving
     */
    private int speedY;

    /**
     * Boolean if the actor is visible on the board
     */
    private boolean isVisible;

    /**
     * Boolean if the actor is making a valid move on the board
     */
    private boolean isValidMove;

    /**
     * Image icon of the actor
     */
    Image image;

    /**
     * Default constructor for setting the actors x location, y location,
     * and the image.
     *
     * @param x     x-axis location of the actor.
     * @param y     y-axis location of the actor.
     * @param image image of the actor.
     */
    protected Actor(int x, int y, Image image) {
        this.image = image;
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    /**
     * Function for moving the actors x-axis and y-axis location
     * by speedX and speedY.
     */
    public void moveActor() {
        if (isValidMove) {
            x += speedX;
            y += speedY;
        }
    }

    /**
     * Getter for returning the direction of the actor.
     *
     * @return the direction the actor is moving.
     */
    public String getDirection() {
        if (speedX == 3)
            return "right";
        else if (speedX == -3)
            return "left";
        else if (speedY == 3)
            return "down";
        else
            return "up";
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

    /**
     * Setter for setting the speed of the actor.
     *
     * @param speedX The new x-axis speed for the actor.
     * @param speedY The new y-axis speed for the actor.
     */
    public void setSpeed(int speedX, int speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    /**
     * Setter for setting if the move is valid for the actor.
     *
     * @param isValidMove If the move is valid.
     */
    public void setValidMove(boolean isValidMove) {
        this.isValidMove = isValidMove;
    }
}

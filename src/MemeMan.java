import javax.swing.*;
import java.awt.*;

/**
 * MemeMan. Controls the meme-man object.
 *
 * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * @version Fall 2020
 */
public class MemeMan extends Actor {

    /**
     * If Meme-Mans power up mode is active.
     */
    private boolean isPowerUpActive;

    /**
     * Number of lives Meme-Man has.
     */
    private int lifeCount;

    /**
     * If Meme-Man is dead.
     */
    private boolean isDead;

    /**
     * Increment used to count how long the power up has been running.
     */
    private int powerUpIncrement;

    /**
     * Constructor to set Meme-Man's starting location, and image icon that will be used.
     *
     * @param x x-axis location
     * @param y y-axis location
     */
    protected MemeMan(int x, int y) {
        super(x, y, new ImageIcon("images/link.png").getImage());
        isPowerUpActive = false;
        isDead = false;
        lifeCount = 3;
        powerUpIncrement = 0;
    }

    /**
     * Removes one of Meme-Mans lives, resets his location to the starting location, and
     * toggles him to be alive.
     */
    public void decLife(){
        lifeCount--;
        setLocation(355, 655);
        isDead = false;
    }

    /**
     * Increments the powerUpIncrement by one.
     */
    public void incPowerUpIncrement(){
        powerUpIncrement++;
    }

    /**
     * Getter to get if Meme-Man is in power up mode.
     * @return isPowerUpActive If Meme-Man is in power up mode.
     */
    public boolean getPowerUpActive() {
        return isPowerUpActive;
    }

    /**
     * Getter to get if Meme-Man is dead.
     * @return isDead If Meme-Man is currently dead.
     */
    public boolean getDead() {
        return isDead;
    }

    /**
     * Getter to get the number of lives Meme-Man has left.
     *
     * @return lifeCount Number of lives Meme-Man has left.
     */
    public int getLifeCount() {
        return lifeCount;
    }

    /**
     * Getter to get the image of Meme-Man. If he is in power up mode it sends
     * that one, if not, it sends normal mode.
     *
     * @return Meme-Mans current image.
     */
    public Image getImage() {
        if (isPowerUpActive) {
            return new ImageIcon("images/link2.png").getImage();
        }
        return super.getImage();
    }

    /**
     * Getter to get the power-up increment number.
     *
     * @return powerUpIncrement The power-up increment number.
     */
    public int getPowerUpIncrement(){
        return powerUpIncrement;
    }

    /**
     * Setter to set if Meme-Man is in power up mode.
     *
     * @param isPowerUpActive if Meme-Man is in power up mode.
     */
    public void setPowerUpActive(boolean isPowerUpActive) {
        this.isPowerUpActive = isPowerUpActive;
    }

    /**
     * Setter to set if Meme-Man is dead.
     *
     * @param isDead if Meme-Man is dead.
     */
    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    /**
     * Setter to set the power-up increment time.
     *
     * @param powerUpIncrement the power-up increment time.
     */
    public void setPowerUpIncrement(int powerUpIncrement) {
        this.powerUpIncrement = powerUpIncrement;
    }
}

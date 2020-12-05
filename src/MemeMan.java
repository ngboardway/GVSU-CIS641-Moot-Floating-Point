import javax.swing.*;
import java.awt.*;

/**
 * MemeMan. Controls the meme-man object.
 * <p>
 * * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * * @version Fall 2020
 */
public class MemeMan extends Actor {

    private boolean isPowerUpActive;

    private int lifeCount;

    private boolean isDead;

    /**
     * Sets Meme-Man's starting location, and image icon that will be used.
     *
     * @param x x-axis location
     * @param y y-axis location
     */
    protected MemeMan(int x, int y) {
        super(x, y, new ImageIcon("images/link.png").getImage());
        isPowerUpActive = false;
        isDead = false;
        lifeCount = 3;
    }

    /**
     *
     * @return
     */
    public boolean getPowerUpActive() {
        return isPowerUpActive;
    }

    public void setPowerUpActive(boolean isPowerUpActive) {
        this.isPowerUpActive = isPowerUpActive;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }
    public boolean getDead() {
        return isDead;
    }
    public int getLifeCount() {
        return lifeCount;
    }

    public void decLife(){
        lifeCount--;
        setLocation(355, 655);
        isDead = false;
    }
}

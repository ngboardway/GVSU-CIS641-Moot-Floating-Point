import javax.swing.*;
import java.awt.*;

/**
 * MemeMan. Controls the meme-man object.
 * <p>
 * * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * * @version Fall 2020
 */
public class MemeMan extends Actor {

    /**
     * Sets Meme-Man's starting location, and image icon that will be used.
     *
     * @param x x-axis location
     * @param y y-axis location
     */
    protected MemeMan(int x, int y) {
        super(x, y, new ImageIcon("images/link.png").getImage());
    }
}

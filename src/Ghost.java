import javax.swing.*;
import java.awt.*;

public class Ghost extends Actor {

    Image ghost;

    private int ghostLocation_X, ghostLocation_Y;

    protected Ghost() {
        bufferImages();
        initVariables();
    }

    private void initVariables() {
        ghostLocation_X = 100;
        ghostLocation_Y = 100;
    }

    public void bufferImages () {
        ghost = new ImageIcon("images/ghost.jpg").getImage();
        // Where we would want to load all of the sprite images
    }

    public Image getGhost() {
        return ghost;
    }
    public int getGhostLocation_X() {
        return ghostLocation_X;
    }
    public int getGhostLocation_Y() {
        return ghostLocation_Y;
    }
}

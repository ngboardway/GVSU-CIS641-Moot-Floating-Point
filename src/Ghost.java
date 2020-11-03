import javax.swing.*;
import java.awt.*;

public class Ghost extends Actor {

    Image ghost;

    protected Ghost() {
        bufferImages();
    }

    public void bufferImages () {
        ghost = new ImageIcon("images/ghost.png").getImage();
        // Where we would want to load all of the sprite images
    }

    public Image getGhostIcon() {

        return ghost;
    }
}

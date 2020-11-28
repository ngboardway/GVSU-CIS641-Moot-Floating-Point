import javax.swing.*;
import java.awt.*;

public class Ghost extends Actor {

    Image ghost;

    private int ghostLocation_X, ghostLocation_Y;

    private boolean isVisible;
    
    protected Ghost(int x, int y) {
        bufferImages();
        ghostLocation_X = x;
        ghostLocation_Y = y;
        isVisible = true;
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
    public int getGhostScore() {
    	return 50;
    }
    public void setVisibility(boolean isVisible){
        this.isVisible = isVisible;
    }
    public boolean getVisibility() {
        return isVisible;
    }

    public Rectangle getBounds() {
        return new Rectangle(ghostLocation_X, ghostLocation_Y, ghost.getWidth(null), ghost.getHeight(null));
    }
}

import javax.swing.*;
import java.awt.*;

public class Wall {

    Image wall;

    private int wallLocation_X, wallLocation_Y;

    protected Wall(int x, int y) {    	
    	bufferImages();
    	wallLocation_X = x;
    	wallLocation_Y = y;
    }

    public void bufferImages () {
        wall = new ImageIcon("images/wall.png").getImage();
        // Where we would want to load all of the sprite images
    }

    public Image getWall() {
        return wall;
    }
    public int getWallLocation_X() {
        return wallLocation_X;
    }
    public int getWallLocation_Y() {
        return wallLocation_Y;
    }
	
}

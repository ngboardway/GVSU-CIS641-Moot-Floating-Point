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
    public Rectangle getBounds() {
        return new Rectangle(wallLocation_X, wallLocation_Y, wall.getWidth(null), wall.getHeight(null));
    }
	
}

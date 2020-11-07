import javax.swing.*;
import java.awt.*;

public class MemeMan {

    private Image memeMan;

    private int memeManLocation_X, memeManLocation_Y;
    private int memeManSpeed_X, memeManSpeed_Y;


    protected MemeMan(int x, int y) {
        bufferImages();
        memeManLocation_X = x;
        memeManLocation_Y = y;
    }

    private void bufferImages () {
        memeMan = new ImageIcon("images/link.png").getImage();
        // Where we would want to load all of the sprite images
    }

    //code for selecting the correct meme man sprite for memeMan icon
    private void updateMemeMan(){

    }

    public void moveMemeMan() {
        memeManLocation_X += memeManSpeed_X;
        memeManLocation_Y += memeManSpeed_Y;
    }

    public void setMemeManSpeed(int X, int Y) {
        memeManSpeed_X = X;
        memeManSpeed_Y = Y;
    }

    public Image getMemeMan() {
        return memeMan;
    }
    public int getMemeMan_X() {
        return memeManLocation_X;
    }
    public int getMemeMan_Y() {
        return memeManLocation_Y;
    }

}

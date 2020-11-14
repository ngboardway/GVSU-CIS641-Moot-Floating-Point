import javax.swing.*;
import java.awt.*;

public class Dot extends Collectable {
    public Dot(int x, int y) {
        super(x, y, 10,  new ImageIcon("images/dot.png").getImage());
    }

    //Overriding and reducing by 20 because the image size is 50px but the dot is only 10px.
    //removing the white are from being counted in the detection.
    public Rectangle getBounds() {
        return new Rectangle(super.getX() + 20, super.getY() + 20, image.getWidth(null)-20, image.getHeight(null)-20);
    }
}

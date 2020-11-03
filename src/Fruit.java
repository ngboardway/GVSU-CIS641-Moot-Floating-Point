import javax.swing.*;
import java.awt.*;

public class Fruit extends Collectable{
    public Fruit(int x, int y) {
        super(x, y, 100, new ImageIcon("images/fruit.png").getImage());
    }
}

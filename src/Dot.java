import javax.swing.*;
import java.awt.*;

public class Dot extends Collectable {
    public Dot(int x, int y) {
        super(x, y, 10,  new ImageIcon("images/dot.png").getImage());
    }
}

import javax.swing.*;

public class Ghost extends Actor {

    protected Ghost() {

    }

    public ImageIcon ghostIcon() {
        ImageIcon ghost = new ImageIcon(getClass().getResource("images/***.png"));
        return ghost;
    }
}

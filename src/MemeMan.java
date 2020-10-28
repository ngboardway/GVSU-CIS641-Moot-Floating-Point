import javax.swing.*;

public class MemeMan extends Actor {

    protected MemeMan() {

    }

    public ImageIcon memeManIcon() {
        ImageIcon link = new ImageIcon(getClass().getResource("images/link.png"));
        return link;
    }

}

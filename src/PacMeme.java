import javax.swing.*;
import java.awt.*;

public class PacMeme extends JFrame {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new PacMeme().setVisible(true);
                var ex = new PacMeme();
                ex.setVisible(true);
            }
        });
    }
    public PacMeme(){
        super("Pac-Meme");
        add(new PacMemePanel());
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

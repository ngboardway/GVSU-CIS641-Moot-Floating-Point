import javax.swing.*;
import java.awt.*;

public class PacMeme extends JFrame {

    public PacMeme() {

        initUI();
    }

    private void initUI() {

        add(new PacMemeBoard());

        setTitle("Pac-Meme");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(766, 820);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new PacMeme();
            ex.setVisible(true);
        });
    }

}

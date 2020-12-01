import javax.swing.*;
import java.awt.*;

/**
 * PacMeme initializer for the Pac-Meme game
 *
 * @author Jon Griesen, Natalie Boardway, Nate Stern, Nick Reitz
 * @version Fall 2020
 */
public class PacMeme extends JFrame {

    /**
     * Constructor that calls initUI to set up the user interface.
     */
    public PacMeme() {
        initUI();
    }

    /**
     * Method for creating and adding PacMemeBoard to the JFrame.
     */
    private void initUI() {
        add(new PacMemeBoard());
        setTitle("Pac-Meme");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(766, 820);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * Main method creating an instance of PacMeme
     *
     * @param args main args.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PacMeme ex = new PacMeme();
            ex.setVisible(true);
        });
    }

}

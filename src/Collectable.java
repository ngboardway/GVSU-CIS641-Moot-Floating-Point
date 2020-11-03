import java.awt.*;

public abstract class Collectable {
    int x;
    private int y;
    private int pointValue;
    private boolean isVisible;
    private Image image;

    public Collectable(int x, int y, int pointValue, Image image) {
        this.x = x;
        this.y = y;
        this.pointValue = pointValue;
        this.image = image;
    }

    public void setVisibility(boolean visibility) {
        isVisible = visibility;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
}

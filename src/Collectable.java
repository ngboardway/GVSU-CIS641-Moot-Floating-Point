import java.awt.*;

public abstract class Collectable {
    private int x;
    private int y;
    private final int pointValue;
    private boolean isVisible;
    Image image;

    public Collectable(int x, int y, int pointValue, Image image) {
        this.x = x;
        this.y = y;
        this.pointValue = pointValue;
        this.image = image;
        isVisible = true;
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

    public int getPointValue() {
        return pointValue;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}

public class Collectable {
  private int xLocation;
  private int yLocation;
  private int pointValue;
  private boolean isVisible;

  public Collectable() {
  }

  public Collectable(int xLocation, int yLocation, int pointValue) {
    this.xLocation = xLocation;
    this.yLocation = yLocation;
    this.pointValue = pointValue;
  }

  public void setVisibility(boolean isVisible) {
    this.isVisible = isVisible;
  }
}

public class Collectable {
  private int xLocation;
  private int yLocation;
  private int pointValue;
  private boolean isVisible;

  public int getXLocation() {
    return xLocation;
  }

  public void setXLocation(int xLoc) {
    xLocation = xLoc;
  }

  public int getYLocation() {
    return yLocation;
  }

  public void setYLocation(int yLoc) {
    yLocation = yLoc;
  }

  public int getPointValue() {
    return pointValue;
  }

  public boolean getVisibility() {
    return isVisible;
  }

  public void setVisibility(boolean isVisible) {
    this.isVisible = isVisible;
  }
}

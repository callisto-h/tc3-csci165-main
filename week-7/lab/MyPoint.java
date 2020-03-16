public class MyPoint {

    private int x;
    private int y;

    // constructor with no args
    public MyPoint() {

    }

    // constructor with args for X and Y
    public MyPoint(int x, int y) {
        setXY(x, y);
    }

    public MyPoint(MyPoint another) {
        // null check
        if (another == null)
            return;

        setXY(another.getX(), another.getY());
    }

    // getter for X
    public int getX() {
        return x;
    }

    // setter for X
    public void setX(int x) {
        this.x = x;
    }

    // getter for Y
    public int getY() {
        return y;
    }

    // setter for Y
    public void setY(int y) {
        this.y = y;
    }

    // gets both X and Y as a 2 element array, [X, Y]
    public int[] getXY() {
        return new int[] { x, y };
    }

    // sets both the X and Y
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // formats X Y as "(X,Y)"
    @Override
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }

    // calculates distance from this point to supplied X, Y
    public double distance(int x, int y) {
        return Math.sqrt((this.y - y) * (this.y - y) + (this.x - x) * (this.x - x));
    }

    // calculates distance from this point to supplied point
    public double distance(MyPoint another) {
        return distance(another.x, another.y);
    }

    // calculates distance from this point to 0,0
    public double distance() {
        return distance(0, 0);
    }

    // determines MyPoint equality
    @Override
    public boolean equals(Object other) {

        // same object check
        if (this == other)
            return true;

        // null check + different class check
        if (other == null || this.getClass() != other.getClass())
            return false;

        MyPoint that = (MyPoint) other;

        return that.x == this.x && that.y == this.y;
    }
}

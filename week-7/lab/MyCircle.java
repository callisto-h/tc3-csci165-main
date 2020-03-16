public class MyCircle {

    private MyPoint center = new MyPoint(0, 0);
    private int radius = 1;

    // no arg constructor
    public MyCircle() {
    }

    // full arg constructor using ints
    public MyCircle(int x, int y, int radius) {
        setCenterXY(x, y);
        setRadius(radius);
    }

    // constructor using MyPoint
    public MyCircle(MyPoint center, int radius) {
        setCenter(center); // privacy is protected inside of this method
        setRadius(radius);
    }

    // getter for radius
    public int getRadius() {
        return radius;
    }

    // setter for radius
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // getter for center
    public MyPoint getCenter() {
        return new MyPoint(center); // privacy
    }

    // setter for center using MyPoint
    public void setCenter(MyPoint center) {
        this.center = new MyPoint(center); // privacy
    }

    // getter for center X
    public int getCenterX() {
        return center.getX();
    }

    // setter for center Y
    public void setCenterX(int x) {
        center.setX(x);
    }

    // getter for center Y
    public int getCenterY() {
        return center.getY();
    }

    // setter for center Y
    public void setCenterY(int y) {
        center.setY(y);
    }

    // gets XY in 2 entry long array, [x, y]
    public int[] getCenterXY() {
        return center.getXY();
    }

    // sets centerpoints of circle
    public void setCenterXY(int x, int y) {
        center.setXY(x, y);
    }

    @Override
    public String toString() {
        return String.format("MyCircle[radius=%d,center=%s]", radius, center);
    }

    // calculates area of circle
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public boolean equals(Object other) {

        // reference check
        if (this == other)
            return true;

        // null check + different class check
        if (other == null || this.getClass() != other.getClass())
            return false;

        MyCircle that = (MyCircle) other;

        return that.radius == this.radius && that.getCenter().equals(this.getCenter());
    }

    // calculates circumference of circle
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // calculates distance from center of this circle and supplied circle center
    public double distance(MyCircle another) {
        return center.distance(another.getCenter());
    }

}

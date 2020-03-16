public class Cylinder extends MyCircle {

    private double height = 1.0;

    // no arg constructor
    public Cylinder() {
        super();
    }

    // constructor with height arg, calls default super
    public Cylinder(double height) {
        super();
        this.height = height;
    }

    // constructor with height & radius args, calls super with radius
    public Cylinder(int radius, double height) {
        super();

        setRadius(radius);
        setHeight(height);
    }

    // constructor that accepts a point center, radius, and height
    public Cylinder(MyPoint center, int radius, double height) {
        super(center, radius);
        setHeight(height);
    }

    // setter for height
    public void setHeight(double height) {
        this.height = height;
    }

    // getter for height
    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object other) {

        // reference check
        if (this == other)
            return true;

        // null check + different class check
        if (other == null || this.getClass() != other.getClass())
            return false;

        Cylinder that = (Cylinder) other;

        // compare heights and pass the other object to super for code reuse
        return that.height == this.height && super.equals(other);
    }

    @Override
    public String toString() {
        return String.format("Cylinder[height=%f,radius=%d,center=%s", height, getRadius(), getCenter());
    }

    // calculates volume of cylinder
    public double getVolume() {
        return getArea() * height;
    }
}

public class Circle{

    private Point center;
    private int radius;

    public Circle(){}

    public Circle(Point center, int radius) {
        this.center = new Point(center);
        this.radius = radius;
    }

    public Circle(Circle copy){
        this(copy.center, copy.radius);
    }

    public Point getCenter() {
        return new Point(center);
    }

    public void setCenter(Point center) {
        this.center = new Point(center);
    }

    public void setCenter(int x, int y){
        center = new Point(x, y);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getArea(){
        double area = 0.0;
        return area;
    }

    public double getCircumference(){
        double c = 0.0;
        return c;
    }

    public double distance(Circle other){
        double distance = 0.0;
        return distance;
    }

    @Override
    public String toString() {
        return "Circle [center => " + center + ", radius => " + radius + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((center == null) ? 0 : center.hashCode());
        result = prime * result + radius;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)    return true;
        if (obj == null)    return false;
        if (getClass() != obj.getClass()) return false;

        Circle other = (Circle) obj;
        if (center == null) {
            if (other.center != null)
                return false;
        } else if (!center.equals(other.center))
            return false;
        if (radius != other.radius)
            return false;
        return true;
    }
}

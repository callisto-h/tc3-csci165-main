public class Cylinder extends Circle{

    private double height;

    public Cylinder(){}

    public Cylinder(Circle base, double height){
        super(base);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBase(Circle base){
        setCenter(base.getCenter());
        setRadius(base.getRadius());
    }

    public Circle getBase(){
        return new Circle(this.getCenter(), this.getRadius());
    }

    @Override
    public String toString() {
        return "Cylinder [Base => " + super.toString() +
                ", height => " + height + "]";
    }



}

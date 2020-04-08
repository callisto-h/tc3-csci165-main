public class PointDriver{
    public static void main(String[] args){

        Point[] points = new Point[10];
        for(int i = 1; i <= 10; ++i)
            points[i - 1] = new Point(i, i);

        for(Point p : points)
            System.out.println(p.toString());

        Circle[] circles = new Circle[10];
        for(int i = 0; i < 5; ++i)
            circles[i] = new Circle(points[i], i*i);

        for(int i = 5; i < 10; ++i)
            circles[i] = new Cylinder(circles[i - 1], 5);

        for(Circle c : circles)
            System.out.println(c.toString());

        if(itemsEqual(circles)) System.out.println("items are equal");
        else System.out.println("items are not equal");
    }

    public static boolean itemsEqual(Circle[] circles){
        for (int i = 0; i < circles.length - 1; i++)
            if (!circles[i].equals(circles[i+1]))
                return false;
        return true;
    }
}

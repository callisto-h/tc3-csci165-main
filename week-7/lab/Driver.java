public class Driver {

    public static void main(String[] args) {

        // array of 10 points
        MyPoint[] points = new MyPoint[10];
        for (int i = 0; i < points.length; i++) {

            // adding points
            points[i] = new MyPoint(i + 1, i + 1);

            // toString on each
            System.out.println(points[i]);
        }

        System.out.println();

        MyPoint test1 = new MyPoint(0, 13);
        MyPoint test2 = new MyPoint(0, 13);

        System.out.println("test1 : " + test1);
        System.out.println("test2 : " + test2);
        System.out.println("test1 equals test2 : " + test1.equals(test2));
        System.out.println("distance between test1 and test2 : " + test1.distance(test2));
        System.out.println("distance between test1 and 0, 8 : " + test1.distance(0, 8));
        System.out.println("distance between test1 and origin: " + test1.distance());

        System.out.println();

        MyCircle[] circles = new MyCircle[10];
        for (int i = 0; i < circles.length; i++) {

            // adding circles with points from before as centers
            circles[i] = new MyCircle(points[i], i + 1);

            // toString on each
            System.out.println(circles[i]);
        }

        System.out.println();

        MyCircle testCircle1 = new MyCircle(1, 1, 1);
        MyCircle testCircle2 = new MyCircle(3, 1, 2);

        MyCircle testCircle3 = new MyCircle(4, 6, 9);
        MyCircle testCircle4 = new MyCircle(4, 6, 9);

        System.out.println("testCircle1 : " + testCircle1);
        System.out.println("testCircle2 : " + testCircle2);
        System.out.println("testCircle3 : " + testCircle3);
        System.out.println("testCircle4 : " + testCircle4);
        System.out.println("testCircle1 equals testCircle2 :" + testCircle1.equals(testCircle2));
        System.out.println("testCircle3 equals testCircle4 :" + testCircle3.equals(testCircle4));
        System.out.println("distance between testCircle1 and testCircle2 : " + testCircle1.distance(testCircle2));
        System.out.println("area of testCircle1 : " + testCircle1.getArea());
        System.out.println("circumference of testCircle1 : " + testCircle1.getCircumference());

        System.out.println();

        Cylinder testCylinder1 = new Cylinder(new MyPoint(1, 1), 1, 1);
        Cylinder testCylinder2 = new Cylinder(3); // 3 high
        Cylinder testCylinder3 = new Cylinder(6, 12); // 6 radius, 12 high
        Cylinder testCylinder4 = new Cylinder(new MyPoint(6, 6), 6, 6);
        Cylinder testCylinder5 = new Cylinder(new MyPoint(6, 6), 6, 6);

        System.out.println("testCylinder1 :" + testCylinder1);
        System.out.println("testCylinder2 :" + testCylinder2);
        System.out.println("testCylinder3 :" + testCylinder3);
        System.out.println("testCylinder4 :" + testCylinder4);
        System.out.println("testCylinder5 :" + testCylinder5);
        System.out.println("testCylinder2 equals testCylinder3 :" + testCylinder2.equals(testCylinder3));
        System.out.println("testCylinder4 equals testCylinder5 :" + testCylinder4.equals(testCylinder5));
        System.out.println("Inherited Methods:");
        System.out.println("center of testCylinder1 :" + testCylinder1.getCenter());
        System.out.println("radius of testCylinder2 :" + testCylinder2.getRadius());
        System.out.println("area of testCylinder3: " + testCylinder3.getArea());

        System.out.println();

        // replacing 5 circles
        for (int i = 0; i < 10; i++) {
            if (i < 5)
                circles[i] = new Cylinder(new MyPoint(i + 1, i + 1), i + 1, i + 1);
            // can't do this because Cylinder methods are unavailable while polymorphized as
            // circles
            // circles[i].getHeight();
            System.out.println(circles[i]);
        }

        System.out.println();

        Object[] objects = new Object[9];
        for (int i = 0; i < 9; i++) {
            if (i < 3) {
                objects[i] = new MyPoint(i + 1, i + 1);
            } else if (i < 6) {
                objects[i] = new MyCircle(i + 1, i + 1, i + 1);
            } else
                objects[i] = new Cylinder(new MyPoint(i + 1, i + 1), i + 1, i + 1);
            // objects[i].getHeight(); // cannot do this because getHeight doesn't exist in
            // Object

            System.out.println(objects[i]);
        }

        objects[8] = new CountyResults2016(25.0, 25.0, 50.0, 50.0, 50.0, 0.0, 0.0, "NY", "Tompkins", 00000);

        // print all objects again, now with the CountyResults2016 in there
        for (int i = 0; i < 9; i++) {
            // I think java knows which toString to call based off of the override. toString exists in object, so it can get called -- but it uses the lowest level instance of it.
            System.out.println(objects[i]);
    }
}

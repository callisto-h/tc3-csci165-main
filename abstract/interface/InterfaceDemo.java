public class InterfaceDemo{

    public static void main(String[] args){

        // create an array of Drawable objects
        Drawable[] drawables = new Drawable[5];
        drawables[0] = new Square();
        drawables[1] = new Triangle();
        drawables[2] = new Rectangle();
        drawables[3] = new Square();
        drawables[4] = new Triangle();

        for(Drawable d : drawables)
            d.draw();
    }


}

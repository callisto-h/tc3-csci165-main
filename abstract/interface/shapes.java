class Square implements Drawable{
    public void draw(){
        System.out.println(
            "========\n" +
            "=      =\n" +
            "=      =\n" +
            "========"
        );
    }
}

class Triangle implements Drawable {
    public void draw() {
        System.out.println(
            "*\n" +
            "* *\n" +
            "* * *\n" +
            "* * * *\n" +
            "* * * * *");
    }
}

class Rectangle implements Drawable {
    public void draw() {
        System.out.println(
            "========\n" +
            "=      =\n" +
            "=      =\n" +
            "=      =\n" +
            "=      =\n" +
            "=      =\n" +
            "========");
    }
}

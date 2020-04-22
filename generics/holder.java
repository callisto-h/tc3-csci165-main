class Automobile {}

class Holder1 {
    private Automobile a;
    public Holder1(Automobile a) {
        this.a = a;
    }
    Automobile get() {
        return a;
    }

    public static void main(String[] args){
        Holder1 h = new Holder1(new Automobile());
        Automobile a = h.get();
    }
}

class Holder2 {
    private Object a;

    public Holder2(Object a) {
        this.a = a;
    }

    public void set(Object a) {
        this.a = a;
    }

    public Object get() {
        return a;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not an Automobile");
        String s = (String) h2.get();
        h2.set(1); // Autoboxes to Integer
        Integer x = (Integer) h2.get();
    }
}

class Holder3<T> {
    private T a;
    String text;

    public Holder3(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<>(new Automobile());
        Automobile a = h3.get();
        //Date s = h3.get();

        // using type inference
        Holder3<Date> h4 = new Holder3<Date>(new Date(1, 1, 2020));
        Date d = h4.get();
        //h4.set("Why can't I do this?");
    }
}

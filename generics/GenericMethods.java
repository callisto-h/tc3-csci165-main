public class GenericMethods {

    public <T> void foo(T x) {
        System.out.println(x.getClass().getName());
    }

    public static <T, U> void bar(T t, U u){
        System.out.println(t.getClass().getName() + "\t" + u.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.foo("");
        gm.foo(1);    // primitive types are autoboxed to associated class types
        gm.foo(1.0);
        gm.foo(1.0F);
        gm.foo('c');
        gm.foo(new Date(1, 1, 2020));
        gm.foo(gm);

        bar("", 1);
        bar(1.0, 1.0F);
        bar('c', new Date(1, 1, 2020));
    }
}

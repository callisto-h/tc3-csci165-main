public class A{
    private String name;
    public A(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    private void helper(){
        System.out.println("Do something helpful");
    }
    @Override
    public String toString(){
        return "Class A --> Name is: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        // idenitity check
        if (this == obj)                    return true;
        // null check
        if (obj == null)                    return false;
        // origin check
        if (getClass() != obj.getClass())   return false;

        A other = (A) obj;                  // down cast
        if (name == null) {                 // null checks
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


} // end of A

class B extends A{
    private double weight;
    public B(String name, double weight){
        super(name);            // pass name to superclass A
        this.weight = weight;   // weight stays with "this"
    }
     @Override
    public String toString(){
        // call the super class toString, concatenate to "this" toString
        return super.toString() + " Class B --> weight is: " + weight;
    }
} // end of B

class C extends B{
    private String color;
    public C(String name, double weight, String color){
        super(name, weight);    // pass name and weight to superclass B
        this.color = color;     // color stays with "this"
    }
    @Override
    public String toString(){
        return super.toString() + " Class C --> color is: " + color;
    }
} // end of C

class InheritanceDriver{
    public static void main(String[] args){
        
        C c = new C("warlock mini", 5, "Red");

        B b = new B("wizard mini", 3);
        A a = new A("halfling mini");

        System.out.println("Is C an instance of B? " +      (c instanceof B));
        System.out.println("Is C an instance of A? " +      (c instanceof A));
        System.out.println("Is C an instance of Object? " + (c instanceof Object));
;
        System.out.println("Was the B constructor called? " + (c.getClass() == b.getClass()));
        System.out.println("Was the A constructor called? " + (c.getClass() == a.getClass()));
    }
}

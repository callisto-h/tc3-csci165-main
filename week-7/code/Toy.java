public class Toy{
    
    private String name;

    public Toy(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class ToyDriver{

    public static void main(String[] args){

        Toy t = new Toy("Warlock Mini");
        System.out.println(t.toString());
    
    }
}

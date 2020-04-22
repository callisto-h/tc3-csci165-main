
public class GenericsDriver {

    public static void main(String[] args){
        /*
        GenericsSample<String>  sample1 = new GenericsSample<String>("Hi there. I'm generic!!");
        GenericsSample<Integer> sample2 = new GenericsSample<Integer>(42);
        GenericsSample<Date>    sample3 = new GenericsSample<Date>(new Date(1, 1, 2020));
        */

        GenericsSample[] samples = {
                                        new GenericsSample<String>("Hi there. I'm generic!!"),
                                        new GenericsSample<Integer>(42),
                                        new GenericsSample<Date>(new Date(1, 1, 2020))
                                    };

        for (GenericsSample gs : samples)
            System.out.println(gs.getData());
    }

}

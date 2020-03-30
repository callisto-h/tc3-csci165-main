public class Driver{

    public static void main(String[] args){
        Employee e = new Employee("P. Lee Bian", new Date("January", 1, 2004));
        HourlyEmployee hourlyE = new HourlyEmployee("P. Lee Bian", new Date("January", 1, 2004), 50.50, 160);

        // equality using getClass
        if(e.equals(hourlyE))
            System.out.println("The two are equal");
        else
            System.out.println("The two are not equal");

        if (hourlyE.equals(e))
            System.out.println("The two are equal");
        else
            System.out.println("The two are not equal");
    }
}

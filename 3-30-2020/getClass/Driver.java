public class Driver{
    public static void main(String[] args){
        Employee e = new Employee("P. Lee Bian",
                                  new Date("January", 1, 2004));
        HourlyEmployee hourlyE = new HourlyEmployee("P. Lee Bian",
                                                    new Date("January", 1, 2004),
                                                    50.50, 160);
        SalariedEmployee salaryE = new SalariedEmployee("Joe Letariat",
                                                        new Date("March", 8, 1917),
                                                        .99);
        ContractEmployee conE = new ContractEmployee("Kom Rade",
                                                    new Date("March", 30, 2020),
                                                    new Date("August", 7, 2020),
                                                    1.99,
                                                    40,
                                                    "Dat Rona");

        printEmployee(e);
        printEmployee(hourlyE);
        printEmployee(salaryE);
        printEmployee(conE);

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

    public static void printEmployee(Employee e){
        System.out.println("\nThe Employee is: " + e);
    }
}

public class DateDriver{

    public static void main(String[] args){
        
        Date d1 = new Date("January", 3, 2020); 
        Date d2 = new Date(1, 3, 2020);

        String month = Date.months[1];
        System.out.println("The second month is: " + month);

        int day = Date.getDay();

        System.out.println("\nd1 is: " + d1);
        System.out.println("d2 is: " + d2);

        d1.setMonth("March");
        d2.setMonth(3);

        System.out.println("\nd1 is: " + d1);
        System.out.println("d2 is: " + d2);


//        System.out.println(date);
        
        /*
        // set d to 1/2/2020
        d.setMonth(1);
        d.setDay(2);
        d.setYear(2020);

        // set d2 to 1/2/2020
        d2.setMonth(1);
        d2.setDay(2);
        d2.setYear(2020);

        // test using ==
        System.out.print("Using == ");
        if(d == d2) System.out.println(d + " does equal " + d2);
        else System.out.println(d + " does not equal " + d2);

        // test using equals method
         System.out.print("Using .equals ");
        if(d.equals(d2)) System.out.println(d + " does equal " + d2);
        else System.out.println(d + " does not equal " + d2);
        */
    }
}

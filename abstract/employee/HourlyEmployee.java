
public class HourlyEmployee extends Employee {

    private double wageRate;
    private double hours; //for the month

    public HourlyEmployee( ){
        super( );
        wageRate = 0;
        hours = 0;
    }

    public HourlyEmployee(String theName, Date theDate, double theWageRate, double theHours){
         super(theName, theDate);
         setHours(theHours);
         setRate(theWageRate);
    }

    public HourlyEmployee(HourlyEmployee originalObject){
         super(originalObject);
         wageRate = originalObject.wageRate;
         hours = originalObject.hours;
    }

    public double getRate( ){
        return wageRate;
    }

    public double getHours( ){
        return hours;
    }

    public double getPay( ){
        return wageRate*hours;
    }

    public void setHours(double hoursWorked){
         if (hoursWorked >= 0)
             hours = hoursWorked;
     }

    public void setRate(double newWageRate){
         if (newWageRate >= 0)
             wageRate = newWageRate;
    }

    public String toString( ){
        return (super.toString() +
                "\n$" + wageRate + " per hour for " + hours + " hours");
    }


}

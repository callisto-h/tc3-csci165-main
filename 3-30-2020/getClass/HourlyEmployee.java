public class HourlyEmployee extends Employee{
    private double wageRate;
    private double hours; //for the month

    public HourlyEmployee( ){
        super( );
        wageRate = 0;
        hours = 0;
    }

    public HourlyEmployee(String theName, Date theDate, double theWageRate, double theHours){
        super(theName, theDate);
        wageRate    = theWageRate;
        hours       = theHours;
    }

    public HourlyEmployee(HourlyEmployee originalObject){
         super(originalObject);
         wageRate   = originalObject.wageRate;
         hours      = originalObject.hours;
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
        return  super.toString() +
                "\n$" + wageRate +
                " per hour for " + hours + " hours";
    }

    public boolean equals(Object otherObject){
        if(this == otherObject)    return true;
        if(otherObject == null)    return false;
        if(getClass() != otherObject.getClass())return false;

        HourlyEmployee otherHourlyEmployee = (HourlyEmployee)otherObject;

        return (super.equals(otherHourlyEmployee)           &&
               (wageRate == otherHourlyEmployee.wageRate)   &&
               (hours == otherHourlyEmployee.hours));
    }
}

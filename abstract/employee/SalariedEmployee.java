
public class SalariedEmployee extends Employee{
    private double salary; //annual

    public SalariedEmployee( ){
        super( );
        salary = 0;
    }

    public SalariedEmployee(String theName, Date theDate, double theSalary){
         super(theName, theDate);
         setSalary(theSalary);
    }

    public SalariedEmployee(SalariedEmployee originalObject ){
         super(originalObject);
         salary = originalObject.salary;
    }

    public double getSalary( ){
        return salary;
    }

    public double getPay( ){
        return salary/12;
    }


    public void setSalary(double newSalary){
         if (newSalary >= 0)
             salary = newSalary;
    }

    public String toString( ){
        return (super.toString() +
                "\n$" + salary + " per year");
    }


}

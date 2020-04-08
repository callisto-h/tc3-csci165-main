public abstract class Employee{

    private String name;
    private Date hireDate;

    public abstract double getPay( );

    public Employee( ){
         name = "No name";
         hireDate = new Date("Jan", 1, 1000);
    }

    public Employee(String theName, Date theDate){
        if (theName != null && theDate != null){
            name = theName;
            hireDate = new Date(theDate);
        }
    }

    public Employee(Employee originalObject){
        if (originalObject == null)
            return;
        name = originalObject.name;
        hireDate = new Date(originalObject.hireDate);
    }

    public String getName( ){
        return name;
    }

    public Date getHireDate( ){
        return new Date(hireDate);
    }

    public void setName(String newName){
        name = newName;
    }

    public void setHireDate(Date newDate){
        if(newDate != null)
            hireDate = new Date(newDate);
    }

    public boolean samePay(Employee other) {
        return (other != null) && (this.getPay() == other.getPay());
    }

    public String toString( ){
        return (name + " " + hireDate.toString( ));
    }

    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
	    if (otherObject == null) return false;
	    if (getClass( ) != otherObject.getClass( )) return false;

        Employee otherEmployee = (Employee)otherObject;
        return  name.equals(otherEmployee.name) &&
                hireDate.equals(otherEmployee.hireDate);
    }
}

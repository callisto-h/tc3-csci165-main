public class Employee
{
    private String name;
    private Date hireDate;

    public Employee( ){
         name       = "No name";
         hireDate   = new Date("January", 1, 1000);
    }

    public Employee(String theName, Date theDate){
        name        = theName;
        hireDate    = new Date(theDate);
    }

    public Employee(Employee originalObject){
         name       = originalObject.name;
         hireDate   = new Date(originalObject.hireDate);
    }

    public String getName( ){
        return name;
    }

    public Date getHireDate( ){
        return new Date(hireDate);
    }

    public void setName(String newName){
        if(newName != null)
            name = newName;
    }

    public void setHireDate(Date newDate){
        if (newDate != null)
            hireDate = new Date(newDate);
    }

    public String toString( ){
        return (name + " " + hireDate.toString( ));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Employee other = (Employee) obj;
        if (hireDate == null) {
            if (other.hireDate != null)
                return false;
        } else if (!hireDate.equals(other.hireDate))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}

public class Employee extends Person{

    private Date    hireDate;
    private int     id;
    private String  department;

    public Employee(Person p, Date hired, int id, String dept){
        super(p);
        setHireDate(hired);
        setId(id);
        setDepartment(dept);
    }
    
    public Date getHireDate() {
        return new Date(hireDate);
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = new Date(hireDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString(){
        return  super.toString() +
                "\nHired: " + hireDate  +
                "\nID: "    + id        +
                "\nDept: "  + department;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)                    return true;
        if (obj == null)                    return false;
        if (getClass() != obj.getClass())   return false;
        if(!super.equals(obj))              return false;

        Employee other = (Employee) obj;
        if(super.equals(obj))
        if (department == null) {
            if (other.department != null)
                return false;
        } else if (!department.equals(other.department))
            return false;
        if (hireDate == null) {
            if (other.hireDate != null)
                return false;
        } else if (!hireDate.equals(other.hireDate))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

}
public class ContractEmployee extends HourlyEmployee{

    private Date contractEnd;
    private String projectName;

    public ContractEmployee(){}

    public ContractEmployee(String name, Date start, Date end, double wage, double hours, String project){
        super(name, start, wage, hours);
        this.projectName = project;
        setEndDate(end);
    }

    public void setEndDate(Date end){
        if(getHireDate().compareTo(end) < 0)
            this.contractEnd = new Date(end);
    }

    public String toString(){
        return  super.toString()    +
                "\nProject: " + projectName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contractEnd == null) ? 0 : contractEnd.hashCode());
        result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)        return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;

        ContractEmployee other = (ContractEmployee) obj;

        if (contractEnd == null) {
            if (other.contractEnd != null)
                return false;
        } else if (!contractEnd.equals(other.contractEnd))
            return false;
        if (projectName == null) {
            if (other.projectName != null)
                return false;
        } else if (!projectName.equals(other.projectName))
            return false;
        return true;
    }
}

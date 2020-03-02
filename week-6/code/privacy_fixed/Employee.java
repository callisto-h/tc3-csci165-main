
public class Employee{

    private String  firstName;
    private String  lastName;
    private String  ssn;
    private String  title;
    private double  salary;
    private Date    hireDate;
    private Date    dateTerminated;
    
    public Employee() {}
    
	public Employee(String firstName, String lastName, String ssn, String title, 
					double salary, Date hireDate, Date dateTerminated) {
		super();
		this.firstName 		= firstName;
		this.lastName 		= lastName;
		this.ssn 			= ssn;
		this.title 			= title;
		this.salary 		= salary;
		this.setHireDate(hireDate);
		this.setDateTerminated(dateTerminated);
	}
	
	public Employee(String firstName, String lastName, Date hireDate) {
		super();
		this.firstName 	= firstName;
		this.lastName 	= lastName;
		this.setHireDate(hireDate);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Date getHireDate() {
		// return a clone of the private data
		return new Date(hireDate);
	}
	public void setHireDate(Date hireDate) {
		// create a local cloned instance to set
		this.hireDate = new Date(hireDate);
		
	}
	
	public Date getDateTerminated() {
		return dateTerminated != null ? new Date(dateTerminated) : null;
	}
	
	public void setDateTerminated(Date dateTerminated) {
		this.dateTerminated = this.hireDate.compareTo(dateTerminated) == -1 ? new Date(dateTerminated) : hireDate;
	}
	
	public boolean equals(Employee otherEmployee) {
		return 	this.firstName.equals(otherEmployee.firstName)	&&
				this.lastName.equals(otherEmployee.lastName)	&&
				this.ssn.equals(otherEmployee.ssn)				&&
				this.title.equals(otherEmployee.title) 			&&
				this.salary == otherEmployee.salary				&&
				this.hireDate.equals(otherEmployee.hireDate);
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + ", title=" + title
				+ ", salary=" + salary + ", hireDate=" + hireDate + ", dateTerminated=" + dateTerminated + "]";
	}
       
}
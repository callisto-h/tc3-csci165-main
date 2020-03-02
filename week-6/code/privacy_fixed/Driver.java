
public class Driver {

	public static void main(String[] args) {
		// create an instance using an overloaded constructor
		// these overloaded constructors have dependencies
		Date hired = new Date(1, 4, 2020);
		Employee emp1 = new Employee("Frank", "Stein", hired);
		
		Employee emp2 = new Employee("Mary", "Shelly", new Date(1, 4, 2020));
		
		System.out.println(emp1);
		System.out.println(emp2);

	}

}

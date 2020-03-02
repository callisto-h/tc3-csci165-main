
public class Person {

	private Date		birthDate;
	private Address 	addy;
	private String 		firstName;
	private String 		lastName;

	public Person(){} //no argument constructor

	public Person(String fName, String lName){
		firstName = fName;
		lastName 	= lName;
	}

	public Person(String fName, String lName, Date dob, Address addy){
		this(fName, lName);
		//potentially unsafe operation
		this.birthDate 	= dob;
		this.addy		= addy;
	}

	public void setAddress(Address a){
		this.addy = a;
	}

	public Address getAddress(){
		return this.addy;
	}

	public Date getBirthDate(){
		return this.birthDate;
	}

	public String getName(){
		return this.firstName + " " + this.lastName;
	}

	public boolean equals(Person p){
		return 	this.firstName.equals(p.firstName) 	&&
						this.lastName.equals(p.lastName) 		&&
						this.addy.equals(p.addy) 						&&
						this.birthDate.equals(p.birthDate);
	}

	public String toString(){
		return firstName + " " + lastName + "\n" + birthDate + "\n" + addy;
	}
}

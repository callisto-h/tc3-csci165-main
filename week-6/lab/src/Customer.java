import java.util.Objects;

public class Customer {

	private String firstName;
	private String lastName;
	private String email = "none on file";
	private Address address = new Address();

	// no-arg constructor
	public Customer() {

	}
	
	// partial-arg constructor
	public Customer(String firstName, String lastName) {
		// do not require domain validation
		setName(firstName, lastName);
	}

	// full arg constructor
	public Customer(String firstName, String lastName, String email, Address address) {
		this(firstName, lastName);
		
		// requires domain validation
		setEmail(email);
		this.address = new Address(address); // privacy
	}


	// copy constructor
	public Customer(Customer toClone) {
		// catches nullpointer exception
		if (toClone == null) {
			return;
		}

		this.firstName = toClone.firstName;
		this.lastName = toClone.lastName;
		this.email = toClone.email;
		this.address = new Address(toClone.address); // privacy
	}

	// gets name
	public String getName() {
		return firstName + " " + lastName;
	}

	// sets name
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// gets email
	public String getEmail() {
		return email;
	}

	// sets email
	public void setEmail(String email) {

		// thought about using a regex from the web for this, but it felt like
		// cheating. Can handle email domains with multiple '.' in it because
		// we only evaluate the *last* index of '.' and check to see
		// if the TLD is 2 or 3 chars long (plus the '.')

		// track number of times '@' appears in email
		int occurances = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@')
				occurances++;
		}
		if (occurances == 1) {

			// validating that the top level domain is 2 or 3
			// characters long by testing difference between
			// location of '.' and length of string
			int topLevelDomainLength = email.length() - email.lastIndexOf('.');

			if (topLevelDomainLength == 3 || topLevelDomainLength == 4) {

				// checking to see if the '@' comes before any '.'
				if (email.indexOf('.') > email.indexOf('@'))
					this.email = email;
			}
		} else
			this.email = "no email on file";
	}

	// tests equality between two Customer objects
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null || otherObject.getClass() != this.getClass())
			return false;

		Customer otherCustomer = (Customer) otherObject;

		return Objects.equals(this.firstName, otherCustomer.firstName)
				&& Objects.equals(this.lastName, otherCustomer.lastName)
				&& Objects.equals(this.email, otherCustomer.email)
				&& Objects.equals(this.address, otherCustomer.address);

	}

	@Override
	public String toString() {
		// handles nullpointer if address is null
		String addressString = address == null ? null : address.toString();

		return String.format("Name: %s\nEmail: %s\nAddress: %s\n", getName(), getEmail(), addressString);
	}

}

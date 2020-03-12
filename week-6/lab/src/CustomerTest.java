import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCustomerCustomer() {
		Address address = new Address();
		Customer customer1 = new Customer("Callisto", "Hess", "hesscallisto@gmail.com", address);
		Customer customer2 = new Customer(customer1);
		
		assertTrue(customer1 != customer2);
		assertTrue(customer1.equals(customer2));
		
		Customer customer3 = new Customer();
		Customer customer4 = new Customer(customer3);
		
		assertTrue(customer3 != customer4);
		assertTrue(customer3.equals(customer4));
	}

	@Test
	void testGetName() {
		Address address = new Address();
		Customer customer1 = new Customer("Callisto", "Hess", "hesscallisto@gmail.com", address);
		Customer customer2 = new Customer("Jon", "Man", "jonman@mail.co", address);
		
		assertTrue(customer1.getName().equals("Callisto Hess"));
		assertTrue(customer2.getName().equals("Jon Man"));
	}

	@Test
	void testSetEmail() {
		Address address = new Address();
		Customer customer1 = new Customer("Callisto", "Hess", "brokenemail", address);
		assertTrue(customer1.getEmail().equals("no email on file"));
		
		// cannot have '.' before @
		customer1.setEmail("broken.still@mail.com");
		assertTrue(customer1.getEmail().equals("no email on file"));
		
		// cannot have two '@'
		customer1.setEmail("brokenstill@@mail.com");
		assertTrue(customer1.getEmail().equals("no email on file"));
		
		// TLD too long
		customer1.setEmail("broken.still@mail.com4w3ghwr");
		assertTrue(customer1.getEmail().equals("no email on file"));
		
		// works
		customer1.setEmail("working@mail.co");
		assertTrue(customer1.getEmail().equals("working@mail.co"));
	}

	@Test
	void testEqualsObject() {
		
		// all null fields
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		assertTrue(customer1.equals(customer2));
		
		
		Address address = new Address();
		Customer customer3 = new Customer("Callisto", "Hess", "hesscallisto@gmail.com", address);
		Customer customer4 = new Customer("Callisto", "Hess", "hesscallisto@gmail.com", address);
		assertTrue(customer3.equals(customer4));
		
		customer3.setName("Not", "Callisto");
		assertFalse(customer3.equals(customer4));
		
		
		
	}

	@Test
	void testToString() {
		Address address = new Address("#40 Hudson Heights", "14850");
    	Customer customer = new Customer("Callisto", "Hess", "hesscallisto@gmail.com", address);
    	String expected = "Name: Callisto Hess\n" + 
    			"Email: hesscallisto@gmail.com\n" + 
    			"Address: #40 Hudson Heights, Ithaca, NY, 14850\n";
    	assertEquals(customer.toString(), expected);
    	
    	customer = new Customer();
    	expected = "Name: null null\n" + 
    			"Email: none on file\n" + 
    			"Address: null, null, null, null\n";
    	assertEquals(customer.toString(), expected);
	}

}

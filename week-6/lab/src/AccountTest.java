import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void testAccountAccount() {
		Account account1 = new Account();
		Account account2 = new Account(account1);
		assertTrue(account1 != account2);
		assertTrue(account1.equals(account2));
		
		Account account3 = new Account("ID", new Customer(), 145.50, 200.0, new Date());
		Account account4 = new Account(account3);
		assertTrue(account3 != account4);
		assertTrue(account3.equals(account4));
	}

	@Test
	void testSetBalance() {
		Account account1 = new Account();
		account1.setBalance(100.0);
		assertEquals(account1.getBalance(), 100.0);
		
		// no negative numbers
		account1.setBalance(-100.0);
		assertFalse(account1.getBalance() == -100.0);
	}

	@Test
	void testSetCreditLimit() {
		Account account1 = new Account();
		account1.setBalance(100.0);
		account1.setCreditLimit(100.0);
		assertEquals(account1.getCreditLimit(), 100.0);
		
		// cannot have credit be more than 2x balance
		account1.setBalance(0);
		account1.setCreditLimit(100.0);
		assertEquals(account1.getCreditLimit(), 0.0);
		
		// sets credit to 2x balance
		account1.setBalance(100.0);
		account1.setCreditLimit(500.0);
		assertEquals(account1.getCreditLimit(), 200.0);
	}

	@Test
	void testCalculateDiscountLevel() {
		// .02 increase per year
		Date date1 = new Date(1, 1, 2018);
		Account account1 = new Account("ID", new Customer(), 0.0, 0.0, date1);
		assertEquals(account1.calculateDiscountLevel(), 0.04);
		
		// has not been a year
		Date date2 = new Date(1, 1, 2020);
		Account account2 = new Account("ID", new Customer(), 0.0, 0.0, date2);
		assertEquals(account2.calculateDiscountLevel(), 0.0);
		
		// maxxes out at 100%
		Date date3 = new Date();
		Account account3 = new Account("ID", new Customer(), 0.0, 0.0, date3);
		assertEquals(account3.calculateDiscountLevel(), 1.0);
		
	}

	@Test
	void testEqualsObject() {
		Account account1 = new Account();
		Account account2 = new Account();
		assertTrue(account1.equals(account2));
		
		account1.setBalance(100.0);
		account2.setBalance(100.0);
		assertTrue(account1.equals(account2));
		
		// all together now, we can see that all of the cascading calls to .equals()
		// work as intended. needed to know for certain.
		Address address = new Address("Street", "14850");
		Customer customer = new Customer("Cal", "Hess", "mail@mail.co", address);
		Date date = new Date(1, 1, 2018);
		Account account3 = new Account("ID", customer, 155.0, 500.0, date);
		Account account4 = new Account("ID", customer, 155.0, 500.0, date);
		assertTrue(account3.equals(account4));
		
		account3.getCustomer().setEmail("broken");
		assertFalse(account3.equals(account4));
		
	}

	@Test
	void testToString() {
    	Address address = new Address("#40 Hudson Heights", "14850");
    	Customer customer = new Customer("Callisto", "Hess", "hesscallisto@gmail.com", address);
    	Date date = new Date(1, 2, 1998);
    	Account account = new Account("ID", customer, 155.0, 600.0, date);
    	
		String expected = "Account ID: ID\n" + 
				"Name: Callisto Hess\n" + 
				"Email: hesscallisto@gmail.com\n" + 
				"Address: #40 Hudson Heights, Ithaca, NY, 14850\n" + 
				"Balance: 155.00\n" + 
				"Credit Limit: 310.00\n" + 
				"Discount Level: 0.44\n" + 
				"Date Created: 1/2/1998\n";
		
		assertEquals(account.toString(), expected);
		
		
	}

	@Test
	void testCompareTo() {
		Customer customer = new Customer();
		Date date = new Date();
		Account account1 = new Account("A1", customer, 0.0, 0.0, date);
		Account account2 = new Account("A1A", customer, 0.0, 0.0, date);
		assertEquals(account1.compareTo(account2), -1);
		
		Account account3 = new Account("BB", customer, 0.0, 0.0, date);
		Account account4 = new Account("BAC32", customer, 0.0, 0.0, date);
		assertEquals(account3.compareTo(account4), 1);
		
		Account account5 = new Account("67FG", customer, 0.0, 0.0, date);
		Account account6 = new Account("67FG", customer, 0.0, 0.0, date);
		assertEquals(account5.compareTo(account6), 0);
	}

}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AddressTest {

	@Test
	void testAddressAddress() {
		Address address1 = new Address();
		Address address2 = new Address(address1);
		// different reference, same content
		assertTrue(address1 != address2);
		assertTrue(address1.equals(address2));
		
		Address address3 = new Address("Hudson Heights", "14850");
		Address address4 = new Address(address3);
		// different reference, same content
		assertTrue(address3 != address4);
		assertTrue(address3.equals(address4));
	}

	@Test
	void testSetZip() {
		Address address1 = new Address();
		address1.setZip("14850");
		assertEquals(address1.getCity(), "Ithaca");
		assertEquals(address1.getState(), "NY");
		
		// handles non existing zip
		Address address2 = new Address();
		address2.setZip("broken");
		assertTrue(address2.getCity() == null);
		assertTrue(address2.getState() == null);
	}

	@Test
	void testEqualsObject() {
		// both have null fields
		Address address1 = new Address();
		Address address2 = new Address();
		assertTrue(address1.equals(address2));
		
		// partial null but still same
		address1.setZip("14850");
		address2.setZip("14850");
		assertTrue(address1.equals(address2));
		
		// different street
		address1.setStreet("street");
		address2.setStreet("lane");
		assertFalse(address1.equals(address2));
	}

	@Test
	void testToString() {
		Address address1 = new Address();
		String expected1 = "null, null, null, null";
		assertEquals(address1.toString(), expected1);
		
		Address address2 = new Address("Hudson Heights", "14850");
		String expected2 = "Hudson Heights, Ithaca, NY, 14850";
		assertEquals(address2.toString(), expected2);
	}

}

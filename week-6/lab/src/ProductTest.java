import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProductTest {
	
	@Test
	void testSetSku() {
		Product product1 = new Product();
		
		// will accept String
		product1.setSku("001ABCDEFG");
		assertEquals(product1.getSku(), "001ABCDEFG");
		
		// won't accept as it is not 10 chars long
		product1.setSku("001A");
		assertEquals(product1.getSku(), "001ABCDEFG");
		
		// won't accept as does not start with acceptable substring
		product1.setSku("1010000000");
		assertEquals(product1.getSku(), "001ABCDEFG");
	}

	@Test
	void testSetPrice() {
		Product product1 = new Product();
		
		// cannot be negative
		product1.setPrice(-5.0);
		assertFalse(product1.getPrice() == -5.0);
		
		// accepts
		product1.setPrice(5.0);
		assertEquals(product1.getPrice(), 5.0);
	}

	@Test
	void testEqualsObject() {
		// new empties
		Product product1 = new Product();
		Product product2 = new Product();
		assertTrue(product1.equals(product2));
		
		// new full args
		Product product3 = new Product("Oranges", "They are oranges", 1.0, "001ABCDEFG");
		Product product4 = new Product("Oranges", "They are oranges", 1.0, "001ABCDEFG");
		assertTrue(product3.equals(product4));
		
		// changing a value
		product3.setName("Apples");
		assertFalse(product3.equals(product4));
		
	}

	@Test
	void testToString() {
		Product product = new Product();
		String expected = "SKU: null\n" + 
				"Name: null                          $(0.0)    Description: null                          \n";
		
		assertEquals(expected, product.toString());
		
		product = new Product("Item name", "Item description", 55.0, "001ABCDEFG");
		expected = "SKU: 001ABCDEFG\n" + 
				"Name: Item name                     $(55.0)   Description: Item description              \n";
		
		assertEquals(expected, product.toString());
	}

}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class InvoiceTest {


	@Test
	void testGetAmount() {
		Invoice invoice = new Invoice();
		double due = invoice.getAmount();
		assertEquals(due, 0.0);
		
		// have to call add in order to populate invoice
		invoice.addProduct(new Product(null, null, 10.0, null));
		due = invoice.getAmount();
		assertEquals(due, 10.0);		
		
		invoice.addProduct(new Product(null, null, 15.0, null));
		due = invoice.getAmount();
		assertEquals(due, 25.0);	
		
	}

	@Test
	void testGetAmountDue() {

		Invoice invoice = new Invoice();
		double due = invoice.getAmountDue();
		assertEquals(due, 0.0);
		
		Date date = new Date(1, 1, 2019);
		Account account = new Account(null, null, 0.0, 0.0, date);
		invoice = new Invoice(null, account, null);
		
		due = invoice.getAmountDue();
		assertEquals(due, 0.0);
		
		// have to call add in order to populate invoice
		invoice.addProduct(new Product(null, null, 15.0, null));
		due = invoice.getAmountDue();
		assertEquals(due, 14.7);
		
	}

	@Test
	void testAddProduct() {
		Invoice invoice = new Invoice();
		invoice.addProduct(null);
		double due = invoice.getAmount();
		assertEquals(due, 0.0);
		
		invoice.addProduct(new Product(null, null, 15.0, null));
		due = invoice.getAmount();
		assertEquals(due, 15.0);
		
	}

	@Test
	void testToString() {
		Invoice invoice = new Invoice();
		String expected = "================== INVOICE ==================\n" + 
				"Invoice: null\n" + 
				"Account ID: null\n" + 
				"Name: null null\n" + 
				"Email: none on file\n" + 
				"Address: null, null, null, null\n" + 
				"Balance: 0.00\n" + 
				"Credit Limit: 0.00\n" + 
				"Discount Level: 1.00\n" + 
				"Date Created: 1/1/1000\n" + 
				"Order Date: 1/1/1000\n" + 
				"PRODUCTS:\n" + 
				"\n" + 
				"Subtotal: $0.00\n" + 
				"Total: $0.00\n";
		
		assertEquals(invoice.toString(), expected);
		
		Address address = new Address("#40 Hudson Heights", "14850");
    	Customer customer = new Customer("Callisto", "Hess", "hesscallisto@gmail.com", address);
    	Date date = new Date(1, 2, 1998);
    	Account account = new Account("ID", customer, 1500.0, 600.0, date);
    	Date today = new Date(3, 5, 2020);
    	Invoice invoice2 = new Invoice("000001", account, today);
    	for (int i = 0; i < 15; i++) {
    		invoice2.addProduct(new Product("Item " + 1, "This is an item", 10.0, null));
    	}

		
		expected = "================== INVOICE ==================\n" + 
				"Invoice: 000001\n" + 
				"Account ID: ID\n" + 
				"Name: Callisto Hess\n" + 
				"Email: hesscallisto@gmail.com\n" + 
				"Address: #40 Hudson Heights, Ithaca, NY, 14850\n" + 
				"Balance: 1500.00\n" + 
				"Credit Limit: 600.00\n" + 
				"Discount Level: 0.44\n" + 
				"Date Created: 1/2/1998\n" + 
				"Order Date: 3/5/2020\n" + 
				"PRODUCTS:\n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"SKU: null\n" + 
				"Name: Item 1                        $(10.0)   Description: This is an item               \n" + 
				"\n" + 
				"Subtotal: $150.00\n" + 
				"Total: $84.00\n";
		
		assertEquals(invoice2.toString(), expected);
		
	}

	@Test
	void testCompareTo() {
		Date noDiscount = new Date(1, 1, 2020);
		Account account = new Account(null, null, 0.0, 0.0, noDiscount);
		Invoice invoice = new Invoice(null, account, null);
		Invoice invoice2 = new Invoice(null, account, null);
		
		assertEquals(invoice.compareTo(invoice2), 0);
		
		invoice.addProduct(new Product(null, null, 10.0, null));
		invoice2.addProduct(new Product(null, null, 10.0, null));
		
		assertEquals(invoice.compareTo(invoice2), 0);
		
		invoice.addProduct(new Product(null, null, 20.0, null));
		invoice2.addProduct(new Product(null, null, 10.0, null));
		
		System.out.println(invoice);
		System.out.println(invoice2);
		
		assertEquals(invoice.compareTo(invoice2), 1);
		
		invoice.addProduct(new Product(null, null, 10.0, null));
		invoice2.addProduct(new Product(null, null, 1000.0, null));
		
		assertEquals(invoice.compareTo(invoice2), -1);
		
		
	}

}

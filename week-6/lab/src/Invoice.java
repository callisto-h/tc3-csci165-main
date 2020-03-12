import java.util.ArrayList;

public class Invoice {

	private String invoiceNumber;
	private Account account = new Account();
	private Date orderDate = new Date();
	private ArrayList<Product> products = new ArrayList<Product>();

	// no arg constructor
	public Invoice() {
	}

	// full arg constructor
	public Invoice(String invoiceNumber, Account account, Date orderDate) {
		this.invoiceNumber = invoiceNumber;
		this.account = new Account(account); // privacy
		this.orderDate = new Date(orderDate); // privacy
	}

	// gets order date of invoice
	public Date getOrderDate() {
		return orderDate;
	}

	// sets order date of invoice
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	// gets account of invoice
	public Account getAccount() {
		return account;
	}

	/*
	 * gets subtotal due on invoice
	 * iterates through products array list and adds prices
	 * 
	 */
	public double getAmount() {
		double total = 0.0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}

	/*
	 * gets total due on invoice
	 * multiplies the subtotal by the discount 
	 * to be applied to purchases made by the
	 * given account
	 */
	public double getAmountDue() {
		double total = getAmount();
		
		// gets discount level associated with the account
		double discount = account.calculateDiscountLevel();
		return total - (total *= discount);
		
	}
	
	/*
	 * adds product to the product arraylist
	 * does not add null products
	 */
	public void addProduct(Product product) {
		
		// filters out null products
		if (product == null) {
			return;
		}
		products.add(product);
	}

	@Override
	public String toString() {
		String returnString = "";
		
		returnString += "================== INVOICE ==================\n";
		returnString += "Invoice: " + invoiceNumber + "\n";
		returnString += account;
		returnString += "Order Date: " + orderDate + "\n";
		returnString += "PRODUCTS:\n";
		
		// appends products to invoice
		for (Product product : products) {
			returnString += "\n" + product;
		}
		returnString += String.format("\nSubtotal: $%.2f\n", getAmount());
		returnString += String.format("Total: $%.2f\n", getAmountDue());

		return returnString;
	}

	/*
	 * compares two invoice objects
	 * comparison is based on the total amount due on a given invoice
	 * 
	 * returns 1 if this > that, 0 if this = that, -1 if this < that
	 */
	public int compareTo(Invoice otherInvoice) {
		
		// handles null pointers
		if (otherInvoice == null) {
			// if that is null, this is bigger
			return 1;
		}
		
		double thisAmountDue = this.getAmountDue();
		double thatAmountDue = otherInvoice.getAmountDue();
		
		// equality
		if (thisAmountDue == thatAmountDue) {
			return 0;
		}
		
		return (thisAmountDue > thatAmountDue ? 1 : -1);
	}
}

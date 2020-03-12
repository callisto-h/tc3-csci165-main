import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Account {

	private String accountID;
	private Customer customer = new Customer();
	private double balance = 0.0;
	private double creditLimit = 0.0;
	private Date dateCreated = new Date();


	// I don't think we should have a class level discount
	// variable since we need to recalculate it *each* time
	// that we charge something on the account, just in case
	// a year has rolled over, increasing it.

	// private double discountLevel = 0.0;

	
	// no arg constructor
	public Account() {
	}

	// partial arg constructor
	public Account(String accountID, Customer customer) {
		this.accountID = accountID;
		this.customer = new Customer(customer); // privacy
	}

	// full arg constructor
	public Account(String accountID, Customer customer, double balance, double creditLimit, Date dateCreated) {
		this(accountID, customer);
		this.dateCreated = new Date(dateCreated); // privacy

		// requires domain validation
		setBalance(balance);
		setCreditLimit(creditLimit);


	}

	// clone constructor, handles null values
	public Account(Account toClone) {

		// prevents null pointer exception when
		// copying new object
		if (toClone == null) {
			return;
		}

		this.accountID = toClone.accountID;
		this.customer = new Customer(toClone.customer); // privacy
		this.balance = toClone.balance;
		this.creditLimit = toClone.creditLimit;
		this.dateCreated = new Date(toClone.dateCreated); // privacy
	}

	// gets the balance of the account
	public double getBalance() {
		return balance;
	}

	/*
	 * sets the balance of the account
	 * the balance cannot be negative, and enforces the invariant
	 * that creditLimit cannot be more than 2x balance
	 */
	public void setBalance(double balance) {
		// cannot have a negative balance
		if (balance >= 0.0)
			this.balance = balance;
		// adjust credit limit if needed 
		if(getCreditLimit() > 2 * balance) {
			setCreditLimit(2 * balance);
		}
	}

	// gets the credit limit
	public double getCreditLimit() {
		return creditLimit;
	}
	
	
	/*
	 * sets the credit limit for the account.
	 * credit limit cannot be negative or exceed
	 * 2x the balance. if credit limit set as less than 0, it 
	 * is set to 0 instead. if credit limit set as more than 2x
	 * balance, it is set at 2x balance.
	 */
	public void setCreditLimit(double creditLimit) {
		// only accepts positive credit limits
		if (creditLimit >= 0.0) {
			// credit limit cannot be over 200% balance
			if (creditLimit > 2 * getBalance())
				// if it is, set it to 200% balance
				this.creditLimit = 2 * getBalance();
			else
				this.creditLimit = creditLimit;
		}
		else
			this.creditLimit = 0.0;
	}
	
	
	/*
	 * 
	 */
	public double calculateDiscountLevel() {
		// handles null pointer
		if (dateCreated == null) {
			return 0.0; // if it hasn't been created, your discount is 0%
		}

		// over-engineered for EXACT precision
		// converts the Date that we defined into a LocalDate object
		LocalDate date = LocalDate.of(dateCreated.getYear(), dateCreated.getMonth(), dateCreated.getDay());
		LocalDate now = LocalDate.now();

		// finds difference between NOW and when the date was created in years
		int diff = Period.between(date, now).getYears();

		double discount = diff * .02;

		// forces discount range to between 0-1
		return forceRangeDouble(discount, 0.0, 1.0);
	}

	// gets the customer
	public Customer getCustomer() {
		return customer;
	}

	
	@Override
	public boolean equals(Object otherObject) {
		// handles null pointers
		if (otherObject == null || otherObject.getClass() != this.getClass())
			return false;

		// explicitly cast otherObject as an Account
		Account otherAccount = (Account) otherObject;

		return Objects.equals(this.accountID, otherAccount.accountID)
				&& Objects.equals(this.customer, otherAccount.customer)
				&& Objects.equals(this.dateCreated, otherAccount.dateCreated) && this.balance == otherAccount.balance
				&& this.creditLimit == otherAccount.creditLimit;
	}

	@Override
	public String toString() {
		// handles nullpointers
		String customerString = customer == null ? null : customer.toString();
		String dateCreatedString = dateCreated == null ? null : dateCreated.toString();

		String returnString = String.format("Account ID: %s\n", accountID);
		returnString += customerString;
		returnString += String.format("Balance: %.2f\nCredit Limit: %.2f\nDiscount Level: %.2f\nDate Created: %s\n", 
											balance, creditLimit, calculateDiscountLevel(), dateCreatedString);
		
		return returnString;
	}

	/*
	 * compares two account objects by the accountID alphanumerically
	 * 
	 * if this accountID comes before that accountID, returns -1
	 * if this accountID comes after that account ID, returns 1
	 * if this accountID is equal to that accountID, returns 0
	 */
	public int compareTo(Account otherAccount) {
		
		// handles logic if either value is null
		if(otherAccount.accountID == null && this.accountID == null) {
			return 0;
		}
		else if (otherAccount.accountID != null && this.accountID == null) {
			return -1;
		}
		else if (otherAccount.accountID == null && this.accountID != null)
			return 1;
		
		// compares accountID strings
		int result = this.accountID.compareTo(otherAccount.accountID);
		
		// restricts range to -1, 1
		return forceRangeInt(result, -1, 1);
	}

	// courtesy of Stephan, forces a value between a min and max
	private double forceRangeDouble(double value, double min, double max) {
		return Math.min(Math.max(value, min), max);
	}
	
	private int forceRangeInt(int value, int min, int max) {
		return Math.min(Math.max(value, min), max);
	}
}

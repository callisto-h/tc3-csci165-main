/**
 * Account.java
 *
 * This Account class represents bank accounts that stores money for an owner.
 *
 * Author: (put your name here)
 */
class Account
{
// Instance variables
	private double balance;	// invariant: balance >= 0 (should never be negative)
	private String owner;

//Constructor
	public Account(String name)
	{
		balance = 0;
		owner = name;
	}

// Instance methods
	/** Deposits 'amount' into the account
	 */
	public void deposit(double amount)
	{
		balance = balance + amount;
	}

	/** Withdraws 'amount' from the account.	
	 */
	public void withdraw(double amount)
	{
		balance = balance - amount;
	}

	/* Returns the balance of the Account
	 */
	public double getBalance()
	{
		return balance;
	}

	/* Returns the owner of the Account
	 */
	public String getOwner()
	{
		return owner;
	}
}
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Driver {
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("I want to see demonstrations of Callisto's wonderful equals & toString methods! [1]");
    	System.out.println("I want to see proof of that the perfect arraylists of Customers/Products/Accounts actually work! [2]");
    	System.out.println("I want to see that nifty sorted arraylist of invoices! [3]");
    	System.out.print("\n<please enter [1-3]>: ");
    	int answer = sc.nextInt();
    	sc.skip("\n");
    	
    	
    	if (answer == 1) {
	    	// creating a fully instanced invoice object and printing it
	    	
	    	Address address = new Address("#40 Hudson Heights", "14850");
	    	Customer customer = new Customer("Callisto", "Hess", "hesscallisto@gmail.com", address);
	    	Date date = new Date(1, 2, 1998);
	    	Account account = new Account("ID", customer, 1500.0, 600.0, date);
	    	Date today = new Date(3, 5, 2020);
	    	Invoice invoice = new Invoice("000001", account, today);
	
	    	for (int i = 0; i < 15; i++) {
	    		invoice.addProduct(new Product("Item " + 1, "This is an item", 10.0, null));
	    	}
	    	
	    	// printing invoice which calls toString, which calls all other toStrings
	    	System.out.println(invoice);
	    	
	    	
	    	
	    	// demonstrating equals calls, should all work
	    	
	    	Address address2 = new Address(address);
	    	Customer customer2 = new Customer(customer);
	    	Date date2 = new Date(date);
	    	Account account2 = new Account(account);
	    	
	    	String booleans = "";
	    	booleans += String.format("Addresses equal: %b\n", address.equals(address2));
	    	booleans += String.format("Customers equal: %b\n", customer.equals(customer2));
	    	booleans += String.format("Dates equal: %b\n", date.equals(date2));
	    	booleans += String.format("Accounts equal: %b\n", account.equals(account2));
	    	
	    	System.out.println("==============================TESTING CLONE EQUALITY:");
	    	System.out.println(booleans); // should all be true
	    	
	    	booleans = "";
	    	booleans += String.format("Addresses equal: %b\n", new Address().equals(new Address()));
	    	booleans += String.format("Customers equal: %b\n", new Customer().equals(new Customer()));
	    	booleans += String.format("Dates equal: %b\n", new Date().equals(new Date()));
	    	booleans += String.format("Accounts equal: %b\n", new Account().equals(new Account()));
	    	
	    	System.out.println("==============================TESTING NULL EQUALITY:");
	    	System.out.println(booleans); // should all be true
	    	
    	}
    	
    	// creating 1000 customers
    	
		ArrayList<Customer> customers = new ArrayList<Customer>();
    	
    	try {
    		File file = new File("customers.txt");
    		FileReader fr = new FileReader(file);
    		BufferedReader br = new BufferedReader(fr);
    		
    		// iterate 1000 times
    		for(int i = 0; i < 1000; i++) {
    			String line = br.readLine();
    			String[] splitLine = line.split("\t");
    			
    			String firstName = splitLine[0];
    			String lastName = splitLine[1];
    			String email = splitLine[2];
    			String fullAddress = String.join(" ", splitLine[3], splitLine[4], splitLine[5]);
    			String zip = splitLine[6];
    			
    			customers.add(new Customer(firstName, lastName, email, new Address(fullAddress, zip)));
    			
    			
    		}
	    	fr.close();
	    	br.close();
	    	
    	}
    	catch (IOException ioe) {
    		System.out.println("IOE");
    	}
    	
    	
    	// creating 1000 products
    	ArrayList<Product> products = new ArrayList<Product>();
    	
    	try {
    		File file = new File("products.txt");
    		FileReader fr = new FileReader(file);
    		BufferedReader br = new BufferedReader(fr);
    		
    		// iterate 1000 times
    		for(int i = 0; i < 1000; i++) {
    			String line = br.readLine();
    			String[] splitLine = line.split("\t");
    			
    			String itemName = splitLine[0];
    			String itemDescription = splitLine[1];
    			double price = Double.parseDouble(splitLine[2]);
    			String sku = splitLine[3];

    			products.add(new Product(itemName, itemDescription, price, sku));
    			
    		}
	    	fr.close();
	    	br.close();
	    	
	    	
    	}
    	catch (IOException ioe) {
    		System.out.println("IOE");
    	}
    	
    	// creating 1000 products
    	ArrayList<Account> accounts = new ArrayList<Account>();
    	
		// iterate 1000 times
		for(int i = 0; i < 1000; i++) {
			
			// just going to use the 1000 customers from before
			Customer customerForAccount = customers.get(i);
			
			int randomDay = new Random().nextInt(11) + 1; // creates random int [1-12];
			int randomMonth = new Random().nextInt(24) + 1; // weird how there are only 25 days in a month, huh?
			int randomYear = 2020 - new Random().nextInt(14) + 1; // year in the last 15 generated
			
			String name = customerForAccount.getName();
			
			name = name.toUpperCase().replaceAll("[ AEIOU]", ""); //removes vowels and spaces, converts to upper case
			
			int nameLength = name.length(); // length of name consonants
			
			// gets sum of characters present in string
			int sumOfChars = 0;
			for (int j = 0; j < nameLength; j++) {
				sumOfChars += (int)name.charAt(j);
			}
			int checkDigit = sumOfChars % nameLength;
			

			name += String.format("%02d%02d%d%d", randomDay, randomMonth, randomYear, checkDigit); // adds year, 0-padded, and checkdigit
			
			double balance = new Random().nextInt(100000) * new Random().nextDouble();
			double creditLimit = balance * .10;
			
			// instructions specify for us to initialize discount level based off of date created,
			// but I don't actually store the discount level as an instance variable.
			// my rationale for this being that every time we access the discount level, we should recalculate it
			// to check for whether another year has passed. 
			accounts.add(new Account(name, customerForAccount, balance, creditLimit, new Date(randomDay, randomMonth, randomYear)));
		}
    	
    	if (answer == 2) {
    		
    		// proof that generation works
	    	
	    	System.out.println("==============================CUSTOMERS LOADED: ");
	    	for (int i = 0; i < 3; i++) {
	    		System.out.println(customers.get(i));
	    	}
	    	
	    	// proof that generation works
	    	
	    	System.out.println("==============================PRODUCTS LOADED: ");
	    	for (int i = 0; i < 3; i++) {
	    		System.out.println(products.get(i));
	    	}
	    	
	    	// proof that generation works
	    	
	    	System.out.println("==============================ACCOUNTS LOADED: ");
	    	for (int i = 0; i < 3; i++) {
	    		System.out.println(accounts.get(i));
	    	}	
	    	
    	}
    	
    	if (answer == 3) {
    		
	    	// creating 1000 invoices
	    	
	    	ArrayList<Invoice> invoices= new ArrayList<Invoice>();
	    	
	    	for (int i = 0; i < 1000; i++) {
	    		int accountIndex = new Random().nextInt(999); // picks random account
	    		String invoiceNumber = String.format("%05d", i + 1); // creates invoice number
	    		
	    		Invoice currentInvoice = new Invoice(invoiceNumber, accounts.get(accountIndex), new Date(10, 3, 2020)); // adds invoice
	    		
	    		// adding between [1-20] products
	    		int numOfProducts = new Random().nextInt(19) + 1;
	    		for (int j = 0; j < numOfProducts; j++) {
	    			int indexOfProduct = new Random().nextInt(999); // gets random index
	    			currentInvoice.addProduct(products.get(indexOfProduct)); // adds random product
	    		}
	    		
	    		invoices.add(currentInvoice);
	    		
	    		
	    	}
	    	
	    	// selection sort on invoices, apparently this is SUPER expensive to do. 
	    	for (int i = 0; i < 999; i++) {
	    		
	    		// set to first "available" value. anything prior to i is considered sorted.
	    		Invoice currentMax = invoices.get(i);
	    		int indexOfMax = i;
	    		
	    		for(int j = i + 1; j < 1000; j++) {
	    			
	    			Invoice currentDue = invoices.get(j);
	    			
	    			if (currentMax.compareTo(currentDue) == -1) {
	    				currentMax = currentDue;
	    				indexOfMax = j;
	    			}
	 
	    		}
	    		
	    		invoices.remove(indexOfMax);
	    		invoices.add(i, currentMax);
	    	}
	    	
	    	// iterate through and show all
	    	for (int i = 0; i < 1000; i++) {
	    		System.out.println(invoices.get(i) + "\n\n");
	    		
	    		
	    		System.out.print("<press ENTER to continue>");
	    		sc.nextLine();
	    	}
	    	
    	}
    	sc.close();	
    }
}

import java.util.Objects;

public class Product {
	private String name;
	private String description;
	private double price;
	private String sku;

	// no-arg constructor
	public Product() {
	}
	
	// sku only constructor
	public Product(String sku) {
		setSku(sku);
	}

	// full arg constructor
	public Product(String name, String description, double price, String sku) {
		this(sku);
		this.name = name;
		this.description = description;
		this.price = price;
	}

	// gets name of product
	public String getName() {
		return name;
	}

	// sets name of product
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * sets sku of product
	 * sku must be both 10 characters in length and start with:
	 * 001, 002, 003, 004, or 110
	 */
	public void setSku(String sku) {
		// handles null pointers
		if (sku == null) {
			return;
		}
		
		// ensures length of 10
		if (sku.length() == 10) {
			
			// validates first three characters
			String[] acceptable = { "001", "002", "003", "004", "110" };
			String firstThree = sku.substring(0, 3);
			
			// loops through acceptable answers and if found, set sku
			for (int i = 0; i < acceptable.length; i++) {
				if (firstThree.equals(acceptable[i])) {
					this.sku = sku;
					return;
				}
			}
		}
	}

	// gets price of product
	public double getPrice() {
		return price;
	}

	/*
	 * sets price of product
	 * price must cannot be negative
	 */
	public void setPrice(double price) {
		
		// ensures positivity
		if (price >= 0)
			this.price = price;
	}
	
	// gets sku of product
	public String getSku() {
		return this.sku;
	}

	@Override
	public boolean equals(Object otherObject) {
		
		// handles null pointers
		if (otherObject == null || otherObject.getClass() != this.getClass())
			return false;
		
		// casts otherObject as a Product
		Product otherProduct = (Product) otherObject;

		return Objects.equals(this.name, otherProduct.name)
				&& Objects.equals(this.description, otherProduct.description) && this.price == otherProduct.price
				&& Objects.equals(this.sku, otherProduct.sku);
	}

	@Override
	public String toString() {
		
		return String.format("SKU: %s\nName: %-30s$%-8s Description: %-30s\n", getSku(), getName(), "(" + price + ")", description);
	}

}

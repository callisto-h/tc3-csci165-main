
public class Sale{

    private String name;
    private double price;

    public Sale( ){
        name = "No name yet";
        price = 0;
    }

    public Sale(String theName, double thePrice){
        setName(theName);
        setPrice(thePrice);
    }

    public Sale(Sale originalObject){
        if (originalObject != null){
            name = originalObject.name;
            price = originalObject.price;
        }
    }

    public double getPrice( ){
        return price;
    }

    public void setPrice(double newPrice){
        if (newPrice >= 0)
            price = newPrice;
    }

    public String getName( ){
        return name;
    }

    public void setName(String newName){
        if (newName != null && newName != "")
            name = newName;
    }

    public String toString( ){
        return  name + " Price and total cost = $" + bill() ;
    }

    public double bill( ){
        return price;
    }

    public int compareTo(Sale otherSale){
        if(this == otherSale)               return  0;
        if(this.bill() < otherSale.bill())  return -1;
        if(this.bill() > otherSale.bill())  return  1;
                                            return  0;
    }

    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass( ) != otherObject.getClass( )) return false;

        Sale otherSale = (Sale)otherObject;
        return  name.equals(otherSale.name)
                && price == otherSale.price;
    }

    public Sale clone( ){
	    return new Sale(this );
    }
}

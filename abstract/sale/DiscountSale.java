public class DiscountSale extends Sale{

    private double discount;

    public DiscountSale( ){
        super( );
        discount = 0;
    }

    public DiscountSale(String theName, double thePrice, double theDiscount){
        super(theName, thePrice);
        setDiscount(theDiscount);
    }

    public DiscountSale(DiscountSale originalObject){
        super(originalObject);
        discount = originalObject.discount;
    }

    public double bill( ){
        double fraction = discount/100;
        return (1 - fraction) * getPrice( );
    }

    public double getDiscount( ){
        return discount;
    }

    public void setDiscount(double newDiscount){
        if (newDiscount >= 0)
            discount = newDiscount;
    }

    public String toString( ){
        return  super.toString()
                + "\n\tDiscount = " + discount + "% "
                + "Total cost = $" + bill( );
    }

    public boolean equals(Object otherObject){
        if (this == otherObject)     return true;
	    if (otherObject == null)    return false;
	    if (getClass( ) != otherObject.getClass( )) return false;

        DiscountSale otherDiscountSale = (DiscountSale)otherObject;
        return  super.equals(otherDiscountSale)
                && discount == otherDiscountSale.discount;
    }

    public DiscountSale clone( ){
	    return new DiscountSale(this );
    }
}

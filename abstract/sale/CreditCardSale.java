public class CreditCardSale extends Sale{

    public double fee;

    public CreditCardSale(double fee) {
        this.fee = fee;
    }

    public CreditCardSale(String theName, double thePrice, double fee) {
        super(theName, thePrice);
        this.fee = fee;
    }

    public CreditCardSale(Sale originalObject, double fee) {
        super(originalObject);
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public double bill(){
        return getPrice() + getFee();
    }

    public String toString(){
        return  super.toString() +
                " Credit Card fee: $" + fee +
                " Total cost = $" + bill();
    }
}

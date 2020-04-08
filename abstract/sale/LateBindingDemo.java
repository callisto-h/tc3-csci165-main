public class LateBindingDemo{
    public static void main(String[] args){

        Sale[] sales = new Sale[3];
        sales[0] = new DiscountSale("Inner tube", 6.50, 7);
        sales[1] = new CreditCardSale("Inner tube", 6.50, .50);
        sales[2] = new DiscountSale("Bicycle", 1700, 10);


        Sale lowestSale = sales[0];
        for(Sale s : sales){
            System.out.println(s);
            if (s.compareTo(lowestSale) < 1)
              lowestSale = s;
        }

        System.out.println("Lowest sale is: " + lowestSale);

    }
}

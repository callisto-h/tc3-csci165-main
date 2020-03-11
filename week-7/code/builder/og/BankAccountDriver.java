public class BankAccountDriver{

    public static void main(String[] args){

        // illustration of the "telescoping anti-pattern"

        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount(12345L);
        BankAccount b3 = new BankAccount(12345L, "Frank");
        BankAccount b4 = new BankAccount(12345L, "Frank", "Transylvania");
        BankAccount b5 = new BankAccount(12345L, "Frank", "Transylvania", 100);
        BankAccount b6 = new BankAccount(12345L, "Frank", "Transylvania", 100, 2.5);
        BankAccount b7 = new BankAccount(12345L, "Frank", "Transylvania", 2.5, 1000, 1500);
        BankAccount b8 = new BankAccount(12345L, "Dryden", "Justin", 2.5, 1500, 1000);


        

        BankAccount[] accounts = {b1, b2, b3, b4, b5, b6, b7, b8};

        for(BankAccount account : accounts)
            System.out.println("\n" + account + "\n");
    }
}
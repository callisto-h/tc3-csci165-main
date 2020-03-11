public class BankDriver{

    public static void main(String[] args){

        BankAccount b1 = new BankAccount.BankAccountBuilder(12345L)
                    .withOwner("Frank")
                    .atBranch("Transylvania")
                    .openingBalance(100)
                    .withMinimumBalance(1500)
                    .atRate(2.5)
                    .build();

        BankAccount b2 = new BankAccount.BankAccountBuilder(98765L)
                    .withOwner("Shamash")
                    .atBranch("Nargaroth")
                    .openingBalance(1500)
                    .atRate(1.5)
                    .build();

        BankAccount[] accounts = {b1, b2};

        for(BankAccount account : accounts)
            System.out.println("\n" + account + "\n");
    }
}
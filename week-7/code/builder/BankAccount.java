
public class BankAccount {

    private long    accountNumber; 
    private String  owner;
    private String  branch;
    private double  balance;
    private double  interestRate;
    private double  minimumBalance;

    private BankAccount() {
        //Constructor is now private.
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minimumBalance;
    }

    public void setMinBalance(double balance) {
        this.minimumBalance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "AccountNumber: "        + accountNumber 
                + "\nOwner: "           + owner
                + "\nBranch: "          + branch
                + "\nBalance: "         + balance  
                + "\nMinimum Balance: " + minimumBalance   
                + "\nInterest Rate: "   + interestRate;
    }

    public boolean equals(BankAccount otherAccount){
        if(otherAccount == null)    return false;
        return  this.accountNumber  == otherAccount.accountNumber   &&
                this.balance        == otherAccount.balance         &&
                this.interestRate   == otherAccount.interestRate    &&
                this.branch.equals(otherAccount.branch)             &&
                this.owner.equals(otherAccount.owner);                 
    }

    public static class BankAccountBuilder {
        // builders will have the same fields as the enclosing class
        private long    accountNumber;
        private String  owner;
        private String  branch;
        private double  balance;
        private double  interestRate;
        private double  minimumBalance;

        public BankAccountBuilder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public BankAccountBuilder withOwner(String owner){
            this.owner = owner;
            return this;  //By returning the builder each time, we can create a fluent interface.
        }

        public BankAccountBuilder atBranch(String branch){
            this.branch = branch;
            return this;
        }

        public BankAccountBuilder openingBalance(double balance){
            this.balance = balance;
            return this;
        }

        public BankAccountBuilder withMinimumBalance(double balance){
            this.minimumBalance = balance;
            return this;
        }

        public BankAccountBuilder atRate(double interestRate){
            this.interestRate = interestRate;
            return this;
        }

        public BankAccount build(){
            //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
            BankAccount account     = new BankAccount();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
            //account.accountNumber   = this.accountNumber;
            account.setAccountNumber(this.accountNumber);
            //account.owner           = this.owner;
            account.setOwner(this.owner);
            //account.branch          = this.branch;
            account.setBranch(this.branch);
            //account.balance         = this.balance;
            account.setBalance(this.balance);
            //account.minimumBalance  = this.minimumBalance;
            account.setMinBalance(this.minimumBalance);
            //account.interestRate    = this.interestRate;
            account.setInterestRate(this.interestRate);
            
            return account;
        }
    } // end inner class
}
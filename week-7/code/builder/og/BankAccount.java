public class BankAccount {

    private long    accountNumber; 
    private String  owner;
    private String  branch;
    private double  balance;
    private double  interestRate;
    private double  minimumBalance;

    public BankAccount() {}

    public BankAccount(long accountNumber){
        this.accountNumber = accountNumber;
    }

    public BankAccount(long accountNumber, String owner){
        this(accountNumber);
        this.owner = owner;
    }

    public BankAccount(long accountNumber, String owner, String branch){
        this(accountNumber, owner);
        this.branch = branch;
    }

    public BankAccount(long accountNumber, String owner, String branch, double balance){
        this(accountNumber, owner, branch);
        this.balance = balance;
    }

    public BankAccount(long accountNumber, String owner, String branch, double balance, double rate){
        this(accountNumber, owner, branch, balance);
        this.interestRate = rate;
    }

    public BankAccount(long accountNumber, String owner, String branch, double balance, double rate, double minimumBalance){
        this(accountNumber, owner, branch, balance, rate);
        this.minimumBalance = minimumBalance;
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
        return branch;
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
                + "\nMinimum balance: " + minimumBalance   
                + "\nInterestRate: "    + interestRate;
    }

    public boolean equals(BankAccount otherAccount){
        if(otherAccount == null)    return false;
        return  this.accountNumber  == otherAccount.accountNumber   &&
                this.balance        == otherAccount.balance         &&
                this.interestRate   == otherAccount.interestRate    &&
                this.branch.equals(otherAccount.branch)             &&
                this.owner.equals(otherAccount.owner);                 
    }
}
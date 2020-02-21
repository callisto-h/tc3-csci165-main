class AccountDebug
{ 
    public static void main(String[] args) 
    { 
        Account a = null; 
        a.deposit(100); 
        a.withdraw(200);
        System.out.println(a.getOwner() + " has $" + a.getBalance()); 
    } 
} 
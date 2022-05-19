public class BankAccount {
    private static String accountNumber;
    private String accountName;
    private double balance;

    public BankAccount (String accountNumber,String accountName){
        this.accountNumber=accountNumber;
        this.accountName=accountName;
        this.balance =0;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountName(){
        return accountName;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance+= amount;

    }
    public boolean withDraw(double amount){
        if(amount < balance){
            balance-=amount;
            return true;
        }
        else {
            return false;
        }
    }
}

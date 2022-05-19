import java.util.*;

public class Bank {
   private ArrayList <BankAccount> list = new ArrayList<>();
private static String accountNumberIn;
   private int search(String accountNumberIn){

       for (int i = 0; i<list.size();i++){
           BankAccount tempAccount = list.get(i);
           String tempNumber = tempAccount.getAccountNumber();


           if (tempNumber.equals(accountNumberIn)) {
               return i;
           }
       }
       return -999;


   }
   public int getTotal(){
       return list.size();
   }

   public BankAccount getItem(String accountNumberIn){
       int index = search(accountNumberIn);
       if (index != -999){
           return list.get(index);
       }
       else {
           return null;
       }
   }

   public boolean addAccount (String nameIn, String accountNumberIn){
       if (search(accountNumberIn) == -999){
           list.add(new BankAccount(accountNumberIn , nameIn));
           return true;
       }
       else {
           return false;
       }
   }

   public boolean depositMoney( String accountNumberIn,double amount){
       BankAccount acc = getItem(accountNumberIn);
       if (acc != null){
           acc.deposit(amount);
       return true;
       }
       else{
           return false;
       }
   }

    public boolean withDrawMoney(String accountNumberIn,double amount){
        BankAccount acc = getItem(accountNumberIn);
        if (acc != null && acc.getBalance()>= amount){
            acc.withDraw(amount);
            return true;
        }
        else{
            return false;
        }
    }

        public boolean removeAccount(String accountNumberIn){
       int index = search(accountNumberIn);
       if (index != -999){
           list.remove(index);
           return true;
        }
       else{
           return false;
       }
    }

}

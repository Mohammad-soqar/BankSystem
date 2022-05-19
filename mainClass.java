
import java.util.*;


public class Main {

    public static void main(String[] args) {
        char choice;
        Bank myBank=new Bank();
        Scanner kb=new Scanner(System.in);
        do{
            System.out.println();
            System.out.println("1. Create new account");
            System.out.println("2. Remove an account");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Check account details");
            System.out.println("6. Quit");
            System.out.println();
            System.out.println("Enter choice [1-6]: ");
            String input=kb.next();
            choice=input.charAt(0);

            switch(choice){
                case '1': option1(myBank); break;
                case '2': option2(myBank); break;
                case '3': option3(myBank); break;
                case '4': option4(myBank); break;
                case '5': option5(myBank); break;
                case '6': break;
                default: System.out.println("Invalid value");
            }
        }while(choice!='6');
    }
    static void option1(Bank bankIn){

        Scanner kb=new Scanner(System.in);

        System.out.print("Enter account number: ");
        String number=kb.next();
        System.out.print("Enter account name: ");
        String name=kb.next();

        boolean success=bankIn.addAccount(number, name);

        if(success)
            System.out.print("Account added");
        else
            System.out.print("Account already exist");
    }
    static void option2(Bank bankIn){

        Scanner kb=new Scanner(System.in);
        System.out.print("Enter account number: ");
        String number=kb.next();

        boolean found =bankIn.removeAccount(number);

        if(found)
            System.out.print("Account removed");
        else
            System.out.print("No such account number");
    }
    static void option3(Bank bankIn){

        Scanner kb=new Scanner(System.in);
        System.out.print("Enter account number: ");
        String number=kb.next();
        System.out.print("Enter deposit amount: ");
        double amount=kb.nextDouble();

        boolean found=bankIn.depositMoney(number, amount);

        if(found)
            System.out.print("Money deposited");
        else
            System.out.print("No such account");
    }
    static void option4(Bank bankIn){

        Scanner kb=new Scanner(System.in);
        System.out.print("Enter account number: ");
        String number=kb.next();
        System.out.print("Enter withdraw amount: ");
        double amount=kb.nextDouble();

        boolean ok=bankIn.withDrawMoney(number, amount);

        if(ok)
            System.out.print("Withdrawal made");
        else
            System.out.print("No such account or insufficient funds");
    }
    static void option5(Bank bankIn){

        Scanner kb=new Scanner(System.in);
        System.out.print("Enter account number: ");
        String number=kb.next();

        BankAccount account =bankIn.getItem(number);

        if(account!=null){
            System.out.println("Account details: ");
            System.out.println("Account number: " + account.getAccountNumber());
            System.out.println("Account name: " + account.getAccountName());
            System.out.println("Balance: " + account.getBalance());
        }
        else
            System.out.print("No such account");
    }

}

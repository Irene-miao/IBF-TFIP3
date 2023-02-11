package bank;


public class Main {
    public static void main(String[] args) {
        
       /* Account jim = new Account("Jim");
        System.out.print(jim.getBalance());
        System.out.print(jim.getAccountNumber());
        jim.deposit(100);
        System.out.print(jim.getBalance());
        System.out.print(jim.getTransactions());
        jim.withdraw(50);
        System.out.print(jim.getBalance());
        System.out.print(jim.getTransactions());
        System.out.print(jim.getCreatingDate());
        System.out.print(jim.getClosingDate());*/
        FixedDepositAccount bob = new FixedDepositAccount("Bob", 100);
        System.out.println("\n"+bob.getBalance());
       /*bob.setInterest(4);
        System.out.println("\n"+bob.getBalance());
        bob.setInterest(5);
        System.out.println("\n"+bob.getBalance());*/
        bob.setDurationInMonths(7);
        System.out.println("\n"+ bob.getDurationInMonths());
        bob.setDurationInMonths(8);
        System.out.println("\n"+ bob.getDurationInMonths());

    }
}
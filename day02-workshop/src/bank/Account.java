package bank;

import java.util.ArrayList;
import java.util.Random;

public class Account {
    private String accountName;
    private float balance = 0;
    private ArrayList<Integer> transactions;
    Random number = new Random();
    private int accountNumber = number.nextInt(1000);
    private boolean isClosed = false;
    private int closingDate;
    private int closingDate;

    // Constructor
    public Account(String accountName, int accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<Integer>();
    }


    // Getter
    public float getBalance() {
        return balance;
    }

    // Method
    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Blance: " + this.balance);
        } else {
            System.out.print("Can't deposit negative sum");
        }
    }

    public void withdraw(int amount) {
        int withdrawal = -amount;

    }
    
    
}

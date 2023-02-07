package bank;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Account {
    // members
    private String accountName;
    private float balance;
    private ArrayList<String> transactions = new ArrayList<>();
    private String accountNumber;
    private boolean isClosed = false;
    private String creatingDate;
    private String closingDate;
    LocalDateTime now = LocalDateTime.now();
    LocalDate nowDate = LocalDate.now();
    DateTimeFormatter obj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    DateTimeFormatter objDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDateTime = now.format(obj);
    String formattedDate = nowDate.format(objDate);

    // Constructor
    
    public Account(String accountName) {
    Random random = new Random();
        this.accountName = accountName;
        this.accountNumber = "ABC" + random.nextInt(100000);
        this.balance = 0;
        this.creatingDate = formattedDate;
        this.closingDate = "";
    }


    public Account(String accountName, float balance) {
        this.accountName = accountName;
        this.balance = balance;
        this.creatingDate = formattedDate;
        this.closingDate = "";
    }


    // Getter
    public float getBalance() {
        return this.balance;
    }


    public String getAccountName() {
        return this.accountName;
    }


    public ArrayList<String> getTransactions() {
        return this.transactions;
    }


    public String getAccountNumber() {
        return this.accountNumber;
    }

    

    public boolean isClosed() {
        return this.isClosed;
    }


    public String getCreatingDate() {
        return this.creatingDate;
    }


    public String getClosingDate() {
        return this.closingDate;
    }

    

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }



    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }


    // Method
    public void deposit(float amount) throws IllegalArgumentException {
        if (amount > 0) {
            String transaction = "\ndeposit %s at %s\n".formatted(amount, formattedDateTime);
            this.transactions.add(transaction);
            this.balance += amount;
            //System.out.println(amount + " deposited. Balance: " + this.balance);
        } else {
           throw new IllegalArgumentException(); 
        }
    }

    public void withdraw(float amount) throws IllegalArgumentException {
        
        if (amount > 0) {
            String transaction = "\nwithdraw %s at %s\n".formatted(amount, formattedDateTime);
            this.transactions.add(transaction);
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException(); 
        }


    }
    
    
}

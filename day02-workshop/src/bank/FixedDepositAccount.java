package bank;

public class FixedDepositAccount extends Account {
    
    //members
    private float interest = 3;
    private int durationInMonths = 6;


    // constructor
    public FixedDepositAccount(String accountName, float balance) {
        super(accountName, balance);
        
    }

    public FixedDepositAccount(String accountName, float balance, float interest) {
        super(accountName, balance);
        this.interest = interest;
        
    }


    public FixedDepositAccount(String accountName, float balance, float interest, int durationInMonths) {
        super(accountName, balance);
        this.interest = interest;
        this.durationInMonths = durationInMonths;
    }


    
    // getter and setter
    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) throws IllegalArgumentException {
        int change = 0;
      
        try {
            while (change < 2) {
            this.interest = interest;
            change++;
            }
        } catch (IllegalArgumentException e) {
            System.out.print(e);;
        }
    
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) throws IllegalArgumentException {
        int change = 0;
      
        if (change < 2) {
            this.durationInMonths = durationInMonths;
            change++;
        } else {
            throw new IllegalArgumentException();
        }
        
    }


    // methods
    @Override
    public float getBalance() {
        
        return super.getBalance()+ interest;
    }

    @Override
    public void deposit(float amount) throws IllegalArgumentException {
    amount = 0;
        super.deposit(amount);
    }

    @Override
    public void withdraw(float amount) throws IllegalArgumentException {
        amount = 0;
        super.withdraw(amount);
    }

    
    
}

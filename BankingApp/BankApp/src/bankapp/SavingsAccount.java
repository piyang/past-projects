package bankapp;

import java.util.Date;

/**
 * A class that represents a savings account that accrues 0.01% interest daily
 * and does not have withdrawal or deposit fees
 * @author piperyang
 */
public class SavingsAccount extends BankAccount {
    
    /**
     * Constructs a new savings account
     * @param n the name of the account owner
     * @param b the initial balance
     */
    public SavingsAccount(String n, double b, Date d){
        super(n, b, d);
    }
    
    /**
     * Calculates the balance after accruing the daily interest
     */
    public void accrueInterest(){
        super.setBalance(Math.round((super.getBalance()* 1.0001) * 100) / 100D);
    }
    
    /**
     * Adds the appropriate amount of interest to the account based on the date
     * and resets the createdDate to the date the account was accessed on.
     * @param d today's date
     * @return the new balance
     */
    public double interest(Date d){
        int daysPassed;
        daysPassed = (int)((d.getTime() - super.getDateCreated().getTime()) / MILLISEC_PER_DAY);
        for(int i = 0; i < daysPassed; i++){
            accrueInterest();
        }
        super.setDateCreated(d);
        return super.getBalance();
    }
    
    
    private static final int MILLISEC_PER_DAY = 86400000;
    
}

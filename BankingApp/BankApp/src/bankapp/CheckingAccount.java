package bankapp;

import java.util.Date;

/**
 * A class that represents a checking account that has a transaction fee of
 * $0.10 per withdrawal while deposits are free
 * @author piperyang
 */
public class CheckingAccount extends BankAccount{
    
    /**
     * Constructs a new checking account
     * @param n the name of the account owner
     * @param b the initial balance
     */
    public CheckingAccount(String n, double b, Date d) {
        super(n,b,d);
    }
    
    
    /**
     * Subtracts a given amount from the balance
     * @param amt the amount of money to be withdrawn
     * @return the balance after the withdrawal
     */
    public double withdraw(double amt){
        super.setBalance(super.getBalance() - amt - 0.10);
        super.setBalance(Math.round(super.getBalance() * 100) / 100D);
        return super.getBalance();
    }
    
   
  
}

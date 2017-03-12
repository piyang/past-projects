package bankapp;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * A class that represents a bank account with two attributes: a name and
 * a balance.
 * @author piyang
 */
public class BankAccount implements Comparable<BankAccount>{

    
    /**
     * Constructs a BankAccount
     * @param n the name of the bank account owner
     * @param b the starting balance of the account
     */
    public BankAccount(String n, double b, Date d){
        name = n;
        balance=b;
        dateCreated = d;
    }
    
    /**
     * Returns the date the account was created 
     * @return date the account was created
     */
    public Date getDateCreated(){
        return dateCreated;
    }
    
    /**
     * Returns the name of the owner of the given bank account
     * @return the name of the account holder
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns the current balance of the account
     * @return the amount currently in the BankAccount
     */
    public double getBalance(){
        return balance;
    }
    
    /**
     * Sets the balance to the desired amount
     * @param amt the new balance
     */
    public void setBalance(double amt){
        balance = amt;
    }
    
    /**
     * Sets the dateCreated to a given date
     * @param d the new dateCreated
     */
    public void setDateCreated(Date d){
        dateCreated = d;
    }
    
    /**
     * Withdraws a given amount from the account
     * @param amt the amount to be withdrawn
     * @return the remaining balance
     */
    public double withdraw(double amt){
        balance -= amt;
        return balance;
    }
    
    /**
     * Deposits a given amount from the account
     * @param amt the amount to be deposited
     * @return the remaining balance
     */
    public double deposit(double amt) {
        balance += amt;
        return balance;
    }
    
    /**
     * Compares one bank account to another based on the balance in each
     * @param other the other BankAccount
     * @return a negative number if this BankAccount has a smaller balance
      than other, 0 if the balances are the same, a positive number otherwise
     */
    @Override
    public int compareTo(BankAccount other){
        if(balance < other.getBalance()) return -1;
        if(balance > other.getBalance()) return 1;
        return 0;
    }
    
     /**
     * Properly formats the toString so that it prints
     * the name and balance and type
     * @return the name and balance and type of the 
     * BankAccount formatted properly
     */
    @Override
    public String toString(){
        String type = "";
        if (this instanceof SavingsAccount) {
            type = "Savings";
        } else if (this instanceof CheckingAccount) {
            type = "Checking";
        } else {
            type = "None";
        }

        DecimalFormat df = new DecimalFormat("#.00");
        return "Account:"
                + "\nName: "
                + name
                + "\nBalance: $"
                + df.format(balance)
                + "\nType: "
                + type;
            
    }
    
    
    private String name;
    private double balance;
    private Date dateCreated;
    private static final int MILLISEC_PER_DAY = 86400000;
    
}

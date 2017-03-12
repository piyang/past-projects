package bankapp;

import java.util.Date;

/**
 * A class that uses the BankingSystem class to sort a list of BankAccounts
 * @author piyang
 */
public class BankApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BankAccount b1 = new SavingsAccount("Jane Doe", 5750.25, new Date(2016, 10, 10));
        BankAccount b2 = new SavingsAccount("Frank Smith", 3240.12, new Date(2016, 10, 11));
        BankAccount b3 = new CheckingAccount("Robert Rhodes", 1008.95, new Date(2016, 10, 12));
        BankAccount b4 = new CheckingAccount("Ann Anderson", 2620.00, new Date(2016, 10, 13));
        
        BankingSystem bank = new BankingSystem();
        bank.addAccount(b1);
        bank.addAccount(b2);
        bank.addAccount(b3);
        bank.addAccount(b4);
        
        BankDisplay bd = new BankDisplay();
    }
    
}

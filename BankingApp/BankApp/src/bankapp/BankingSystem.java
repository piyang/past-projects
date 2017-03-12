package bankapp;

import java.text.DecimalFormat;
import java.util.*;
import static java.util.Collections.sort;

/**
 * A class that represents a bank which stores a list of BankAccounts
 * and is able to manipulate that list. (in the assignment description this
 * class is called ListOfAccounts)
 * @author piyang
 */
public class BankingSystem {
    
    /**
     * Constructs a BankingSystem containing a list of accounts
     */
    public BankingSystem(){
        accounts = new ArrayList<BankAccount>();
    }
    
    /**
     * Adds an account to the list of accounts
     * @param b the account being added
     */
    public void addAccount(BankAccount b){
        accounts.add(b);
    }
    
    /**
     * Tells how many accounts are part of the BankingSystem
     * @return the number of accounts in the BankingSystem
     */
    public int numAccounts(){
        return accounts.size();
    }
    
    /**
     * Finds a given account based on the account owner's name
     * @param n the name of the account owner
     * @return the BankAccount belonging to n
     */
    public BankAccount findAcct(String n){
        for(int i = 0; i < numAccounts(); i++){
            if(accounts.get(i).getName().equalsIgnoreCase(n)){
                return accounts.get(i);
            }
        }
        return null;
    }
    
    /**
     * Returns the BankAccount at the given index
     * @param i the index of the desired account
     * @return the account at index i
     */
    public BankAccount getAccount(int i){
        return accounts.get(i);
    }
    
     /**
     * Creates a Comparator based on the balances of the BankAccounts
     * @param increasing a boolean that tells whether the comparison should be in
     * increasing or decreasing order
     * @return instance of an anonymous class that represents a comparator that
     * compares based on the balances of the BankAccounts
     */
    public static Comparator<BankAccount> createComparatorByBalance(
           final boolean increasing){
       Comparator<BankAccount> comp = new
           Comparator<BankAccount>()
           {
               int direction;
               public int compare(BankAccount b1, BankAccount b2)
               {
                   if(increasing) direction = 1; else direction = -1;
                   return direction * b1.compareTo(b2);
               }
           };
       return comp;
    }
    
    /**
     * Creates a Comparator based on the names of the BankAccounts
     * @param increasing a boolean that tells whether the comparison should be in
     * increasing or decreasing order
     * @return instance of an anonymous class that represents a comparator that
     * compares based on the names of the BankAccounts
     */
    public static Comparator<BankAccount> createComparatorByName(
           final boolean increasing){
       Comparator<BankAccount> comp = new
           Comparator<BankAccount>()
           {
               int direction;
               public int compare(BankAccount b1, BankAccount b2)
               {
                   if(increasing) direction = 1; else direction = -1;
                   return direction * b1.getName().compareTo(b2.getName());
               }
           };
       return comp;
    }
    
    /**
     * Sorts the list of BankAccounts by their balances
     * @param increasing if true, sort the accounts in ascending order. 
     * If false, sort in descending order.
     */
    public void sortByBalance(boolean increasing){
        sort(accounts, createComparatorByBalance(increasing));
    }
    
    /**
     * Sorts the list of BankAccounts by their balances
     * @param increasing if true, sort the accounts in ascending order. 
     * If false, sort in descending order.
     */
    public void sortByName(boolean increasing){
        sort(accounts, createComparatorByName(increasing));
    }
    
    /**
     * Returns the toStrings of each BankAccount in accounts
     * @return the toStrings of each BankAccount in the list
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < numAccounts(); i++) {
            result += "\n\n" + accounts.get(i).toString();
        }
        return result;
    }
    
    private ArrayList<BankAccount> accounts;
    
}

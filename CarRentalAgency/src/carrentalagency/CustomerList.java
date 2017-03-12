package carrentalagency;
import java.util.*;
/**
 * A class that represents a list of customers that have rented, or are renting
 * from the agency
 * @author piyang
 */
public class CustomerList {
    
    /**
     * Creates an empty list of customers
     */
    public CustomerList(){
        list = new ArrayList<Customer>();
    }
    
    
    /**
     * creates a new customer and adds it to the list and returns it or returns 
     * the returning customer
     * @param n the name of the customer
     * @param i the customer's id
     * @param a the customer's address
     * @return the newly created or returning customer
     */
    public Customer createCust(String n,String a){
        Customer c = findCustWithName(n);
        
        if(c == null){
           String i = String.valueOf(list.size()+ID_STARTING_NUM);
           list.add(new Customer(n,i,a));
           return list.get(list.size()-1);
        }
        else{
            return c;
        }     
    }
    
    /**
     * finds a customer given a customer's name
     * @param name the customer's name
     * @return the customer that matches the given id
     */
    public Customer findCustWithName(String name){
       for(int i =0; i < list.size(); i++){
           if(list.get(i).getName().equals(name)){
               return list.get(i);
           }
       }
       return null;
    }
    
    public Customer findCustWithID(String id){
        for(int i =0; i < list.size(); i++){
            if(list.get(i).getID().equals(id)){
                return list.get(i);
               }
            }
        return null;
    }
    
    public Customer get(int i){
        return list.get(i);
    }
    
    private ArrayList<Customer> list  = null;
    private static final int ID_STARTING_NUM = 1111;
    
}

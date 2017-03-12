package carrentalagency;

/**
 * A class that represents a customer who will rent a car
 * @author piyang
 */
public class Customer {
    
    /**
     * Creates a customer
     * @param n the customer's name in the format first last
     * @param i the customer's id number
     * @param a the customer's address in the regular format
     */
    public Customer(String n, String i, String a){
        name = n;
        id = i;
        address = a;
        
    }
    
    /**
     * Gets the name of the customer
     * @return the customer's name in the format first last
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the customer's id number
     * @return the customer's id number
     */
    public String getID(){
        return id;
    }
    
    /**
     * Gets the customer's address
     * @return the customer's address
     */
    public String getAddress(){
        return address;
    }
    
    /**
     * Gets the customer's credit card number
     * @return the customer's credit card number
     */
    public String getCreditCard(){
        return creditCard;
    }
    
    /**
     * Sets the value of the credit card
     * @param cc the credit card number
     */
    public void setCreditCard(String cc){
        creditCard = cc;
    }
    
    private final String name;
    private final String id;
    private final String address;
    private String creditCard  = null;
    
}

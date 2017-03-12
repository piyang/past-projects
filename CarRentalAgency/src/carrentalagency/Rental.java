package carrentalagency;
import java.util.*;
/**
 * A class that represents a rental agreement
 * @author piyang
 */
public class Rental {
    
    /**
     * Creates a new Rental
     * @param ca the car being rented
     * @param cu the customer renting the car
     */
    public Rental (Car ca, Customer cu ) {
        custID = cu.getID();
        carID = ca.getID();
        carPrice = ca.getPrice();
        hasPaid = false;
        
        
    }
    
    /**
     * Gets the id of the customer associated with the rental
     * @return the id of the customer
     */
    public String getCustID() {
       return custID; 
    }
    
    /**
     * gets the id of the car associated with the rental
     * @return the id of the car
     */
    public String getCarID() {
     return carID;   
    }
    
    /**
     * gets the date that the customer returned the car on
     * @return the date that the car was returned on
     */
    public Date getDateIn() {
        return dateIn;
    }
    
    /**
     * gets the date that the customer picks up the car on
     * @return the date the car is picked up
     */
    public Date getDateOut() {
        return dateOut;
    }
    
    /**
     * gets the amount that the customer owes for the rental
     * @return the amount the customer owes for the rental
     */
    public double getPayDue() {
        return payDue;
    }
    
    /**
     * tells whether the customer has paid or not
     * @return true if the customer has paid, false if they have not
     */
    public boolean getHasPaid() {
        return hasPaid;
    }
    
    /**
     * once the customer has paid, sets hasPaid to true
     */
    public void setHasPaid(){
        hasPaid = true;
    }
    
    /**
     * sets the dateIn as the date the customer returns the car on
     * @param d the date the customer returns the car
     */
    public void setDateIn(Date d){
        dateIn = d;
    }
    
    /**
     * sets the dateOut as the date the customer picks up the car on
     * @param d the date the customer picks up the car
     */
    public void setDateOut(Date d){
        dateOut = d;
    }
    
    /**
     * calculates the amount owed by the customer based on the number of days
     * they have rented the car for and the price of the car
     * @return the amount due by the customer
     */
    public double calcPayment(){
        double daysRented;
        daysRented = (int)((dateIn.getTime() - dateOut.getTime())/MILLISEC_PER_DAY);
        payDue = carPrice * daysRented;
        return carPrice * daysRented;
    }
    
    private String custID = null;
    private String carID = null;
    private double carPrice;
    private Date dateIn = null;
    private Date dateOut = null;
    private double payDue;
    private boolean hasPaid;
    private final int MILLISEC_PER_DAY = 86400000;
    
    
}

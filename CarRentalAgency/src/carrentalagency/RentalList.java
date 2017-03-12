package carrentalagency;
import java.util.*;
/**
 * A class that represents a list of Rental objects
 * @author piyang
 */
public class RentalList {
    
    /**
     * Creates an empty RentalList
     */
    public RentalList(){
        list = new ArrayList<Rental>();
        records = new ArrayList<Rental>();
    }
    
    /**
     * finds the rental corresponding to the given customer id
     * @param custID the id of the customer whose rental is being searched for
     * @param carID the id of the car being rented
     * @return the rental that is being searched for
     */
    public Rental findRental(String custID, String carID){
        for(int i = 0; i <list.size(); i++){
            Rental r = list.get(i);
            if(r.getCustID().equals(custID) && r.getCarID().equals(carID)){
                return list.get(i);
            }
            
        }
        return null;
    }
    
    /**
     * creates a new rental and adds it to the rental list
     * @param ca the car being rented
     * @param cu the customer that is renting the car
     */
    public void createRental(Car ca, Customer cu){
        list.add(new Rental(ca,cu));
    }
    
    /**
     * Sets the value of hasPaid for the rental associated with the given
     * customer id to true
     * @param custID the id of the customer who is paying
     * @param carID the id of the car the customer rented
     */
    public void pay(Rental r){
        r.setHasPaid();
        records.add(r);
        list.remove(list.indexOf(r)); 
    }
    
    public Rental get(int i){
        return list.get(i);
    }
    
    public Rental getRecord(int i){
        return records.get(i);
    }
     
    private ArrayList<Rental> list = null;
    private ArrayList<Rental> records = null;
}

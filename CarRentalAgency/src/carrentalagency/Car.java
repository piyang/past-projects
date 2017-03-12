package carrentalagency;

/**
 * A class that represents a Car.
 * @author piyang
 */
public class Car {
    
    /**
     * Constructs a Car object
     * @param n the name of the car, i.e. make and model
     * @param i the car's identification number represented as a string
     * @param p the price per day of renting a car
     */
    public Car(String n, String i, double p){
        name = n;
        id = i;
        price = p;
        available = true;
        
    }
    
    /**
     * Gets the name of the car
     * @return the car's name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the car's id number
     * @return the car's id number
     */
    public String getID(){
        return id;
    }
    
    /**
     * Gets the price of the car
     * @return the price (per day) of renting the car
     */
    public double getPrice(){
        return price;
    }
    
   /**
    * checks if the car is available to rent
    * @return true if it is available, false if not
    */
    public boolean checkAvail(){
       return available;
    }
    
    /**
     * Sets the availability of the car
     * @param b the availability of the car
     */
    public void setAvailable(boolean b){
        available = b;
    }
    
    public String toString(){
        return name + " ID: " + id + " Price: " + String.valueOf(price);
    }
    
    private final String name;
    private final String id;
    private final double price;
    private boolean available;
    
}

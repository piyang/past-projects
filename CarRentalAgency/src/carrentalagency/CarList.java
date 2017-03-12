package carrentalagency;
import java.util.*;
/**
 * This class represents a list of Car objects
 * @author piyang
 */
public class CarList {
    
    /**
     * Creates an empty CarList
     */
    public CarList(){
        list = new ArrayList<Car>();
    }
    
    /**
     * Adds a Car object to the CarList
     * @param c the car that will be added to the list
     */
    public void addCar(Car c){
        list.add(c);
    }
    
    /**
     * Goes through the CarList and searches for a car based on the given
     * car ID number
     * @param carID the identification number of the car being searched fo
     * @return the Car object that has the same id as the inputed id, null
     * if no such Car exists
     */
    public Car findCar(String carID){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getID().equals(carID)){
                return list.get(i);
            }
        }
        return null;
    }
    
    /**
     * Gets a list of available cars separated by line
     * @return a list of available cars
     */
    public String getCarList(){
        String s ="";
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).checkAvail()){
                s+= list.get(i).toString() + "\n";
            }
        }
        return s;
    }
    
   
    private ArrayList<Car> list = null;
    
}

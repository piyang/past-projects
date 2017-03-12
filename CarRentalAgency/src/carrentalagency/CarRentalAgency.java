package carrentalagency;
import java.util.*;
/**
 * A class that simulates a Car Rental Agency where a user can reserve,
 * pick-up, and drop-off a car.
 * @author piyang
 */
public class CarRentalAgency {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarList ourCars = new CarList();
        CustomerList ourCustomers = new CustomerList();
        RentalList ourRentals = new RentalList();
        Agent ourAgent = new Agent(ourCustomers, ourCars, ourRentals);
        
        /**
         * Initializing our carList
         */
        for (int i = 0; i < 20; i++) {
            ourCars.addCar(new Car("Honda V:" + i,"" + (i+ID_STARTING_NUM),100 + i*50));
        }
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Welcome, what can I help you with today?");
        String input = null;
        

        do {
            System.out.println("\nEnter 1 to reserve a car, "
                + "2 to pick-up a car, "
                + "3 to return a car, "
                + "or 4 to exit: ");
            input = s.nextLine();

            System.out.println("\n");

            switch(input) {
                case "1": ourAgent.reserveCar();
                break;

                case "2": ourAgent.pickUp();
                break;

                case "3": ourAgent.returnCar();
                break;
                
                case "4": System.out.println("Goodbye!");
                break;

                default: System.out.println("Invalid Input!\n");
            }
        } while(!input.equals("4")); 
    }
    
    private static final int ID_STARTING_NUM = 2345;
}

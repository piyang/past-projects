package carrentalagency;
import java.util.*;
/**
 * This is a class that represents the agent at a car rental agency,
 * that interacts with the customer
 * @author piyang
 */
public class Agent {
    
    /**
     * Creates a new agent
     * @param cu the list of customers
     * @param ca the list of cars
     * @param r the list of rentals
     */
    public Agent(CustomerList cu, CarList ca, RentalList r){
        custList = cu;
        carList = ca;
        rentalList = r;  
    }
    
    /**
     * reserves a car for the user
     */
    public void reserveCar(){
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name?");
        String n = s.nextLine().toLowerCase();
        System.out.println("What is your address?");
        String a = s.nextLine();
        Customer cu = custList.createCust(n, a);
        
        System.out.println(carList.getCarList());
        System.out.println("\n\nPlease enter the car ID of the car"
                + " you wish to rent.");
        Car ca = carList.findCar(s.nextLine());
        
        while(ca == null || !ca.checkAvail()){
            System.out.println("Your car ID was not found. Please try again.");
            ca = carList.findCar(s.nextLine());
        }
        ca.setAvailable(false);
        

        rentalList.createRental(ca, cu);
        
        System.out.println("\nYour customer ID is "+cu.getID()+
                " Please remember this number and your car's ID for when you "
                + "pick up your car.");
        System.out.println("\nThank you! Your car is reserved.");
        
    }
    
    /**
     * picks up the users car
     */
    public void pickUp(){
        Scanner s = new Scanner(System.in);
        Rental r = null;
        int year = -1; 
        int month = -1; 
        int date = -1;
        
        System.out.println("Please enter your customer ID.");
        String custID = s.nextLine();
        System.out.println("Please enter the ID of the car you are renting.");
        String carID = s.nextLine();
        r = rentalList.findRental(custID, carID); 
         while(r == null) {
            System.out.println("The provided customer ID and car ID did not match.\n"
                    + "Please try again.\n");
            System.out.println("Please enter your customer ID.");
            custID = s.nextLine();
            System.out.println("Please enter the ID of the car you are renting.");
            carID = s.nextLine();
            r = rentalList.findRental(custID, carID);  
        }
        
        do {
            try {
                System.out.println("Please enter the year.");
                year = Integer.parseInt(s.nextLine()) -1900;
                System.out.println("Please enter the month in numeric form.");
                month = Integer.parseInt(s.nextLine()) -1;
                System.out.println("Please enter the date.");
                date = Integer.parseInt(s.nextLine());
            }
            catch (Exception e) {
                System.out.println("There was a problem processing your date.");
            }
        } while (year == -1 || month == -1 || year == -1);
        
        Date d = new Date(year, month, date);
        r.setDateOut(d);
        
        System.out.println("Thank you. Here are your keys. Drive safely! :^)");
    }
    
    /**
     * returns the customer's car
     */
    public void returnCar(){
        Scanner s = new Scanner(System.in);
        Rental r = null;
        int year = -1; 
        int month = -1; 
        int date = -1;
        
        System.out.println("Please enter your customer ID.");
        String custID = s.nextLine();
        System.out.println("Please enter the ID of the car you are renting.");
        String carID = s.nextLine();
        r = rentalList.findRental(custID, carID); 
         while(r == null || r.getDateOut() == null) {
            System.out.println("The provided customer ID and car ID did not match.\n"
                    + "Please try again.\n");
            System.out.println("Please enter your customer ID.");
            custID = s.nextLine();
            System.out.println("Please enter the ID of the car you are renting.");
            carID = s.nextLine();
            r = rentalList.findRental(custID, carID);  
        }
        
        do {
            try {
                System.out.println("Please enter the year.");
                year = Integer.parseInt(s.nextLine()) -1900;
                System.out.println("Please enter the month in numeric form.");
                month = Integer.parseInt(s.nextLine()) -1;
                System.out.println("Please enter the date.");
                date = Integer.parseInt(s.nextLine());
            }
            catch (Exception e) {
                System.out.println("There was a problem processing your date.\n");
            }
        } while (year == -1 || month == -1 || year == -1);
        
        Date d = new Date(year, month, date);
        r.setDateIn(d);
     
        carList.findCar(carID).setAvailable(true);
        
        System.out.println("You owe "+String.valueOf(r.calcPayment())+
                " Please provide a credit card number.");
        String cc = s.nextLine();
        custList.findCustWithID(custID).setCreditCard(cc);
        rentalList.pay(r);
        
        System.out.println("Thank you for your patronage. Please come again!");
    }
    
    
    
    private CustomerList custList = null;
    private CarList carList = null;
    private RentalList rentalList = null;  
}

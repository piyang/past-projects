/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalagency;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author piyang
 */
public class RentalListTest {
    
    public RentalListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findRental method, of class RentalList.
     */
    @Test
    public void testFindRental() {
        System.out.println("findRental");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        String custID = cu.getID();
        Car ca = new Car("Test Car", "1", 200);
        RentalList instance = new RentalList();
        
        instance.createRental(ca, cu);
        Rental expResult = instance.get(0);
        Rental result = instance.findRental(custID, ca.getID());
        
        assertEquals(expResult, result);
    }

    /**
     * Test of createRental method, of class RentalList.
     */
    @Test
    public void testCreateRental() {
        System.out.println("createRental");
        
        Car ca = new Car("Test Car", "1", 200);
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        
        RentalList instance = new RentalList();
        instance.createRental(ca, cu);
        
        assertEquals(instance.get(0).getCarID(), ca.getID());
        assertEquals(instance.get(0).getCustID(), cu.getID());
        
        
    }

    /**
     * Test of pay method, of class RentalList.
     */
    @Test
    public void testPay() {
        System.out.println("pay");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        RentalList instance = new RentalList();
        
        instance.createRental(ca, cu);
        instance.pay(instance.findRental(cu.getID(), ca.getID()));
        
        assertTrue(instance.getRecord(0).getHasPaid());
    }
    
}

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
public class CarTest {
    
    public CarTest() {
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
     * Test of getName method, of class Car.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        
        Car instance = new Car("Test Car", "1", 200);
        
        String expResult = "Test Car";
        String result = instance.getName();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getID method, of class Car.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        
        Car instance = new Car("Test Car", "1", 200);
        
        String expResult = "1";
        String result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Car.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        Car instance = new Car("Test Car", "1", 200);
        
        double expResult = 200.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 200.0);
    }

    /**
     * Test of checkAvail method, of class Car.
     */
    @Test
    public void testCheckAvail() {
        System.out.println("checkAvail");
        
        Car instance = new Car("Test Car", "1", 200);
        
        boolean expResult = true;
        boolean result = instance.checkAvail();
        assertEquals(expResult, result);
        
        System.out.println("checkAvail");
        
        Car instance2 = new Car("Test Car", "1", 200);
        instance2.setAvailable(false);
        
        boolean expResult2 = false;
        boolean result2= instance2.checkAvail();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setAvailable method, of class Car.
     */
    @Test
    public void testSetAvailable() {
        System.out.println("setAvailable");
        
        boolean b = false;
        Car instance = new Car("Test Car", "1", 200);
        
        instance.setAvailable(b);
        assertFalse(instance.checkAvail());
    }

    /**
     * Test of toString method, of class Car.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        Car instance = new Car("Test Car", "1", 200);
        
        String expResult = "Test Car ID: 1 Price: 200.0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}

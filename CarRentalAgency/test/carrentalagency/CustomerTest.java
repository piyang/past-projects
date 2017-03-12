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
public class CustomerTest {
    
    public CustomerTest() {
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
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        
        Customer instance = new Customer("Bob", "234", "123 Main St.");
        
        String expResult = "Bob";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getID method, of class Customer.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        
        Customer instance = new Customer("Bob", "234", "123 Main St.");
        
        String expResult = "234";
        String result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class Customer.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        
        Customer instance = new Customer("Bob", "234", "123 Main St.");
        
        String expResult = "123 Main St.";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCreditCard method, of class Customer.
     */
    @Test
    public void testGetCreditCard() {
        System.out.println("getCreditCard");
        
        Customer instance = new Customer("Bob", "234", "123 Main St.");
        instance.setCreditCard("1234567891234567");
        
        String expResult = "1234567891234567";
        String result = instance.getCreditCard();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCreditCard method, of class Customer.
     */
    @Test
    public void testSetCreditCard() {
        System.out.println("setCreditCard");
        
        String cc = "1234567891234567";
        Customer instance = new Customer("Bob", "234", "123 Main St.");
        instance.setCreditCard(cc);
        
        assertEquals(cc, instance.getCreditCard());
    }
}

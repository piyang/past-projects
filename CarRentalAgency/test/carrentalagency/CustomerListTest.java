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
public class CustomerListTest {
    
    public CustomerListTest() {
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
     * Test of createCust method, of class CustomerList.
     */
    @Test
    public void testCreateCust() {
        System.out.println("createCust");
        
        String n = "Bob";
        CustomerList instance = new CustomerList();
        
        Customer result = instance.createCust(n, "");
        Customer expResult = instance.findCustWithName(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of findCust method, of class CustomerList.
     */
    @Test
    public void testFindCustWithName() {
        System.out.println("findCust");
        
        String name = "Bob";
        CustomerList instance = new CustomerList();
        
        Customer expResult = instance.createCust(name, "");
        Customer result = instance.findCustWithName(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findCust method, of class CustomerList.
     */
    @Test
    public void testFindCustWithID() {
        System.out.println("findCust");
        
        CustomerList instance = new CustomerList();
        Customer c = new Customer("", "123", "");
        
        Customer expResult = instance.createCust("Bob", "123 Main St.");
        Customer result = instance.findCustWithID(expResult.getID());
        assertEquals(expResult, result);
    }  
}

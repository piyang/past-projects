/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalagency;

import java.util.Date;
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
public class RentalTest {
    
    public RentalTest() {
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
     * Test of getCustID method, of class Rental.
     */
    @Test
    public void testGetCustID() {
        System.out.println("getCustID");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        
        String expResult = cu.getID();
        String result = instance.getCustID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCarID method, of class Rental.
     */
    @Test
    public void testGetCarID() {
        System.out.println("getCarID");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        
        String expResult = ca.getID();
        String result = instance.getCarID();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of getDateIn method, of class Rental.
     */
    @Test
    public void testGetDateIn() {
        System.out.println("getDateIn");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        Date d = new Date(2016,9,4);
        instance.setDateIn(d);
        
        Date expResult = d;
        Date result = instance.getDateIn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateOut method, of class Rental.
     */
    @Test
    public void testGetDateOut() {
        System.out.println("getDateOut");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        Date d = new Date(2016,9,4);
        instance.setDateOut(d);
        
        Date expResult = d;
        Date result = instance.getDateOut();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of getPayDue method, of class Rental.
     */
    @Test
    public void testGetPayDue() {
        System.out.println("getPayDue");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        Date out = new Date(2016,9,1);
        Date in = new Date(2016,9,4);
        
        instance.setDateIn(in);
        instance.setDateOut(out);
        instance.calcPayment();
        
        double expResult = 600.0;
        double result = instance.getPayDue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getHasPaid method, of class Rental.
     */
    @Test
    public void testGetHasPaid() {
        System.out.println("getHasPaid");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        
        boolean expResult = false;
        boolean result = instance.getHasPaid();
        assertEquals(expResult, result);
        instance.setHasPaid();
        assertTrue(instance.getHasPaid());
    }

    /**
     * Test of setHasPaid method, of class Rental.
     */
    @Test
    public void testSetHasPaid() {
        System.out.println("setHasPaid");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        
        instance.setHasPaid();
        assertTrue(instance.getHasPaid());
    }

    /**
     * Test of setDateIn method, of class Rental.
     */
    @Test
    public void testSetDateIn() {
        System.out.println("setDateIn");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        Date d = new Date(2016,9,1);
        instance.setDateIn(d);
        
        assertEquals(d, instance.getDateIn());
    }

    /**
     * Test of setDateOut method, of class Rental.
     */
    @Test
    public void testSetDateOut() {
        System.out.println("setDateOut");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        Date d = new Date(2016,9,1);
        instance.setDateOut(d);
        
        assertEquals(d, instance.getDateOut());
    }

    /**
     * Test of calcPayment method, of class Rental.
     */
    @Test
    public void testCalcPayment() {
        System.out.println("calcPayment");
        
        Customer cu = new Customer("Bob", "234", "123 Main St.");
        Car ca = new Car("Test Car", "1", 200);
        Rental instance = new Rental(ca,cu);
        Date out = new Date(2016,9,1);
        Date in = new Date(2016,9,4);
        instance.setDateIn(in);
        instance.setDateOut(out);
        
        double expResult = 600;
        double result = instance.calcPayment();
        assertEquals(expResult, result, 0.0);
    }
    
}

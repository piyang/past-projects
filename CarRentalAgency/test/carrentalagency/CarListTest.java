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
public class CarListTest {
    
    public CarListTest() {
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
     * Test of addCar method, of class CarList.
     */
    @Test
    public void testAddCar() {
        System.out.println("addCar");
        
        Car c = new Car("Test Car", "1", 200);
        CarList instance = new CarList();
        instance.addCar(c);
        
        assertEquals(c, instance.findCar(c.getID()));
    }

    /**
     * Test of findCar method, of class CarList.
     */
    @Test
    public void testFindCar() {
        System.out.println("findCar");
        
        Car c = new Car("Test Car", "1", 200);
        String carID = c.getID();
        CarList instance = new CarList();
        instance.addCar(c);
        
        Car expResult = c;
        Car result = instance.findCar(carID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCarList method, of class CarList.
     */
    @Test
    public void testGetCarList() {
        System.out.println("getCarList");
        
        Car c = new Car("Test Car", "1", 200);
        CarList instance = new CarList();
        instance.addCar(c);
        
        String expResult = c.toString()+"\n";
        String result = instance.getCarList();
        assertEquals(expResult, result);
    }
    
}

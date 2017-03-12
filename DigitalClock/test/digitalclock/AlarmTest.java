/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalclock;

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
public class AlarmTest {
    
    public AlarmTest() {
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
     * Test of setAlarm method, of class Alarm.
     */
    @Test
    public void testSetAlarm() {
        System.out.println("setAlarm");
        String h = "12";
        String m = "30";
        String p = "AM";
        Alarm instance = new Alarm();
        instance.setAlarm(h, m, p);
        assertEquals(instance.getHours(), 0);
        assertEquals(instance.getMinutes(), 30);
    }
    
}

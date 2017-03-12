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
public class ClockTest {
    
    public ClockTest() {
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
     * Test of tick method, of class Clock.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        Clock instance = new Clock();
        instance.tick();
        assertEquals(instance.getSeconds(), 1);
    }

    /**
     * Test of incHours method, of class Clock.
     */
    @Test
    public void testIncHours() {
        System.out.println("incHours");
        Clock instance = new Clock();
        instance.incHours();
        assertEquals(instance.getHours(), 1);

    }

    /**
     * Test of incMins method, of class Clock.
     */
    @Test
    public void testIncMins() {
        System.out.println("incMins");
        Clock instance = new Clock();
        instance.incMins();
        assertEquals(instance.getMinutes(), 1);
    }
    
    /**
     * Test of decHours method, of class Clock.
     */
    @Test
    public void testDecHours() {
        System.out.println("decHours");
        Clock instance = new Clock();
        instance.decHours();
        assertEquals(instance.getHours(), 23);
    }
    
    /**
     * Test of decMins method, of class Clock.
     */
    @Test
    public void testDecMins() {
        System.out.println("decMins");
        Clock instance = new Clock();
        instance.decMins();
        assertEquals(instance.getMinutes(), 59);
    }

    /**
     * Test of clearSeconds method, of class Clock.
     */
    @Test
    public void testClearSeconds() {
        System.out.println("clearSeconds");
        Clock instance = new Clock();
        instance.clearSeconds();
        assertEquals(instance.getSeconds(), 0);
    }


    /**
     * Test of checkAlarm method, of class Clock.
     */
    @Test
    public void testCheckAlarm() {
        System.out.println("checkAlarm");
        Clock instance = new Clock();
        instance.setAlarm("6", "30", "AM");
        boolean expResult = false;
        boolean result = instance.checkAlarm();
        assertEquals(expResult, result);
    }
    
    
    
}

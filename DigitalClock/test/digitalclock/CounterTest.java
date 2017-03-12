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
public class CounterTest {
    
    public CounterTest() {
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
     * Test of setValue method, of class Counter.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int v = 20;
        Counter instance = new Counter(60);
        instance.setValue(v);
        assertEquals(instance.getValue(), 20);
    }

    /**
     * Test of getValue method, of class Counter.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Counter instance = new Counter(60);
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of increment method, of class Counter.
     */
    @Test
    public void testIncrement() {
        System.out.println("increment");
        Counter instance = new Counter(60);
        instance.increment();
        assertEquals(instance.getValue(), 1);
    }
    
    /**
     * Test of decrement method, of class Counter.
     */
    @Test
    public void testDecrement() {
        System.out.println("decrement");
        Counter instance = new Counter(60);
        instance.decrement();
        assertEquals(instance.getValue(), 59);
    }
    
}

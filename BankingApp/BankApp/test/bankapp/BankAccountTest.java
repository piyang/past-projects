package bankapp;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A set of tests for the methods in the BankAccount class
 * @author piyang
 */
public class BankAccountTest {
    
    public BankAccountTest() {
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
     * Test of compareTo method, of class BankAccount.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        BankAccount other = new BankAccount("Joe Smith", 1000.00, new Date(2016,10,10));
        BankAccount instance = new BankAccount("Sally Roberts", 500.00, new Date(2016,10,10));
        int expResult = -1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
    }


    /**
     * Test of setBalance method, of class BankAccount.
     */
    @Test
    public void testSetBalance() {
        System.out.println("setBalance");
        double amt = 200.00;
        BankAccount instance = new BankAccount("Joe Smith", 1000.00, new Date(2016,10,10));
        instance.setBalance(amt);
        assertEquals(instance.getBalance(), amt, 0.0);
    }
    
    /**
     * Test of setDateCreated method, of class BankAccount.
     */
    @Test
    public void testSetDateCreated(){
        System.out.println("setDateCreated");
        Date d = new Date(2016, 1, 12);
        BankAccount instance = new BankAccount("Joe Smith", 1000.00, new Date(2016,10,10));
        instance.setDateCreated(d);
        assertEquals(instance.getDateCreated().getDate(), 12);
        assertEquals(instance.getDateCreated().getMonth(), 1);
        assertEquals(instance.getDateCreated().getYear(), 2016);
    }

    /**
     * Test of withdraw method, of class BankAccount.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        double amt = 20.0;
        BankAccount instance = new BankAccount("Joe Smith", 1000.00, new Date(2016,10,10));
        double expResult = 980.00;
        double result = instance.withdraw(amt);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of deposit method, of class BankAccount.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        double amt = 20.0;
        BankAccount instance = new BankAccount("Joe Smith", 1000.00, new Date(2016,10,10));
        double expResult = 1020.0;
        double result = instance.deposit(amt);
        assertEquals(expResult, result, 0.0);
    }

    
}

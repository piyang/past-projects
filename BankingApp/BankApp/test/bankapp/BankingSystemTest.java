package bankapp;

import java.util.Comparator;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A set of tests for the methods in the BankingSystem Class
 * @author piyang
 */
public class BankingSystemTest {
    
    public BankingSystemTest() {
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
     * Test of addAccount method, of class BankingSystem.
     */
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        BankAccount b = new BankAccount("John Smith", 1000.10, new Date(2016, 10, 10));
        BankingSystem instance = new BankingSystem();
        instance.addAccount(b);
        assertEquals(instance.numAccounts(), 1);
    }
    
    /**
     * Test of numAccounts method, of class BankingSystem
     */
    @Test
    public void testNumAccounts(){
        System.out.println("numAccounts");
        BankAccount b = new BankAccount("John Smith", 1000.10, new Date(2016, 10, 10));
        BankAccount b2 = new BankAccount("Jane Smith", 200.10, new Date(2016, 10, 11));
        BankingSystem instance = new BankingSystem();
        instance.addAccount(b);
        instance.addAccount(b2);
        int expResult = 2;
        int result = instance.numAccounts();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findAcct method, of class BankingSystem
     */
    @Test
    public void testFindAcct(){
        System.out.println("findAcct");
        BankAccount b = new BankAccount("John Smith", 1000.10, new Date(2016, 10, 10));
        BankingSystem instance = new BankingSystem();
        instance.addAccount(b);
        BankAccount expResult = b;
        BankAccount result = instance.findAcct("John Smith");
        assertEquals(expResult, result);
    }

    /**
     * Test of createComparatorByBalance method, of class BankingSystem.
     */
    @Test
    public void testCreateComparatorByBalance() {
        System.out.println("createComparatorByBalance");
        boolean increasing = true;
        Comparator<BankAccount> result = BankingSystem.createComparatorByBalance(increasing);
        assertTrue(result instanceof Comparator);
       
    }

    /**
     * Test of createComparatorByName method, of class BankingSystem.
     */
    @Test
    public void testCreateComparatorByName() {
        System.out.println("createComparatorByName");
        boolean increasing = true;
        Comparator<BankAccount> result = BankingSystem.createComparatorByName(increasing);
        assertTrue(result instanceof Comparator);
    }
    
    /**
     * Test of getAccount method, of class BankingSystem
     */
    @Test
    public void testGetAccount() {
        System.out.println("getAccount");
        BankAccount b = new BankAccount("John Smith", 1000.10, new Date(2016,10,10));
        BankingSystem instance = new BankingSystem();
        instance.addAccount(b);
        assertEquals(instance.getAccount(0), b);
    }
    
}

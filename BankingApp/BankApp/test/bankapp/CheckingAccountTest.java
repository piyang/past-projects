/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author piperyang
 */
public class CheckingAccountTest {
    
    public CheckingAccountTest() {
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
     * Test of deposit method, of class CheckingAccount.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        double amt = 10.0;
        CheckingAccount instance = new CheckingAccount("John Smith", 1000.30, new Date(2016, 10, 10));
        double expResult = 1010.30;
        double result = instance.deposit(amt);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of withdraw method, of class CheckingAccount.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        double amt = 20.0;
        CheckingAccount instance = new CheckingAccount("John Smith", 1000.30, new Date(2016, 10, 10));
        double expResult = 980.20;
        double result = instance.withdraw(amt);
        assertEquals(expResult, result, 0.0);
        
    }
    
}

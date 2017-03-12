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
public class SavingsAccountTest {
    
    public SavingsAccountTest() {
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
     * Test of deposit method, of class SavingsAccount.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        double amt = 10.0;
        SavingsAccount instance = new SavingsAccount("John Smith", 1000.30, new Date(2016, 10, 10));
        double expResult = 1010.30;
        double result = instance.deposit(amt);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of withdraw method, of class SavingsAccount.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        double amt = 20.0;
        SavingsAccount instance = new SavingsAccount("John Smith", 1000.30, new Date(2016, 10, 10));
        double expResult = 980.30;
        double result = instance.withdraw(amt);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of accrueInterest method, of class SavingsAccount.
     */
    @Test
    public void testAccrueInterest() {
        System.out.println("accrueInterest");
        SavingsAccount instance = new SavingsAccount("John Smith", 10000.00, new Date(2016, 10, 10));
        instance.accrueInterest();
        assertEquals(10001.00, instance.getBalance(), 0.0);
    }

    /**
     * Test of interest method, of class SavingsAccount.
     */
    @Test
    public void testInterest() {
        System.out.println("interest");
        Date d = new Date(2016, 10, 10);
        SavingsAccount instance = new SavingsAccount(
                "John Smith", 1000.10, new Date(2016, 10, 05));
        double expResult = Math.round((instance.getBalance() * Math.pow(1.0001, 5)) * 100) / 100D;
        double result = instance.interest(d);
        assertEquals(expResult, result, 0.0);
    }

    
}

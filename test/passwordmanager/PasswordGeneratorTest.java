/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import passwordmanager.authentication.PasswordGenerator;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author ryans
 */
public class PasswordGeneratorTest {
    
    public PasswordGeneratorTest() {
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
     * Test of createGenPass method, of class PasswordGenerator.
     * 
     */
    @Test
    public void testCreateGenPass() {
        System.out.println("createGenPass");
        int expResult = 14;
        PasswordGenerator generate = new PasswordGenerator();
        String password = generate.createGenPass();
        int result = password.length();
        assertEquals(expResult, result);
        System.out.println("Generated Password: " + password);
    }
}

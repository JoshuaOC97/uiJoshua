/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.authentication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author up878976
 */
public class RegistrationTest {
    
    public RegistrationTest() {
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
     * Test of isValidEmail method, of class Registration.
     */
    @Test
    public void testIsInvalidEmail() {
        System.out.println("isValidEmail");
        String email = "sdfjlskdjf";
        Registration instance = new Registration("email","username", "password", "passwordConfirmation");
        boolean expResult = false;
        boolean result = instance.isValidEmail(email);
        assertEquals(expResult, result);

    }
    /**
     * Test of isValidEmail method, of class Registration.
     */
    @Test
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        String email = "something@email.com";
        Registration instance = new Registration("email","username", "password", "passwordConfirmation");
        boolean expResult = true;
        boolean result = instance.isValidEmail(email);
        assertEquals(expResult, result);

    }

    /**
     * Test of isPasswordSecure method, of class Registration.
     */
    @Test
    public void testIsPasswordinsecure() {
        System.out.println("isPasswordSecure");
        String password = "hello";
        Registration instance = new Registration("email","username", "password", "passwordConfirmation");
        boolean expResult = false;
        boolean result = instance.isPasswordSecure(password);
        assertEquals(expResult, result);
    }
        /**
     * Test of isPasswordSecure method, of class Registration.
     */
    @Test
    public void testIsPasswordSecure() {
        System.out.println("isPasswordSecure");
        String password = "Password2019@@@";
        Registration instance = new Registration("email","username", "password", "passwordConfirmation");
        boolean expResult = true;
        boolean result = instance.isPasswordSecure(password);
        assertEquals(expResult, result);
    }
    
}

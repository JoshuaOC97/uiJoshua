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
import passwordmanager.user.Encryption;

import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class EncryptionTest {
    
    public EncryptionTest() {
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
     * Test of getSecKey method, of class Encryption.
     */
    @Test
    public void testGetSecKey() {
        System.out.println("getSecKey");
        String userMainPassword = "mainpassword";
        Encryption instance = new Encryption(userMainPassword);
        int expResult = 16;
        byte[] resultKey = instance.getSecKey(userMainPassword);
        int result = resultKey.length;
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class Encryption.
     * This test ensures both encrypt and decrypt method work
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        String userMainPassword = "mainPassword";
        Encryption instance = new Encryption(userMainPassword);
        byte[] secKey = instance.getSecKey(userMainPassword);
        String cipherText = instance.encrypt("password",secKey);
        String expResult = "password";
        String result = Encryption.decrypt(cipherText, secKey);
        assertEquals(expResult, result);
    }

}

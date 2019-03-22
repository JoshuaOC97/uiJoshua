/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class EntryManagerTest {
    
    public EntryManagerTest() {
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
     * Test of addEntry method, of class EntryManager.
     */
    @Test
    public void testAddEntry_5args() {
        System.out.println("addEntry");
        String entryID = "abc";
        String service = "google";
        String username = "username";
        String password = "password";
        LocalDateTime passwordAge = LocalDateTime.MAX;
        EntryManager instance = new EntryManager();
        instance.addEntry(entryID, service, username, password, passwordAge);
    }

    /**
     * Test of addEntry method, of class EntryManager.
     */
    @Test
    public void testAddEntry_6args_1() {
        System.out.println("addEntry");
        String entryID = "";
        String service = "";
        String username = "";
        String password = "";
        String hint = "";
        LocalDateTime passwordAge = null;
        EntryManager instance = new EntryManager();
        instance.addEntry(entryID, service, username, password, hint, passwordAge);
    }

    /**
     * Test of addEntry method, of class EntryManager.
     */
    @Test
    public void testAddEntry_6args_2() {
        System.out.println("addEntry");
        String entryID = "";
        String service = "";
        String username = "";
        String password = "";
        LocalDateTime passwordAge = null;
        String email = "";
        EntryManager instance = new EntryManager();
        instance.addEntry(entryID, service, username, password, passwordAge, email);
    }

    /**
     * Test of addEntry method, of class EntryManager.
     */
    @Test
    public void testAddEntry_7args() {
        System.out.println("addEntry");
        String entryID = "";
        String service = "";
        String username = "";
        String password = "";
        String hint = "";
        String email = "";
        LocalDateTime passwordAge = null;
        EntryManager instance = new EntryManager();
        instance.addEntry(entryID, service, username, password, hint, email, passwordAge);

    }

    /**
     * Test of getEntry method, of class EntryManager.
     */
    @Test
    public void testGetEntry() {
        EntryManager instance = new EntryManager();
        System.out.println("getEntry");
        Entry entry1 = new Entry("123", "amazon", "username", "password", LocalDateTime.MAX);
        Entry entry2 = new Entry("123", "google", "username", "password", LocalDateTime.MAX);
        instance.addEntry(entry1);
        int entryNo = 0;
        Entry expResult = entry1;
        Entry result = instance.getEntry(entryNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteEntry method, of class EntryManager.
     */
    @Test
    public void testDeleteEntry() {
        EntryManager instance = new EntryManager();
        Entry entry1 = new Entry("123", "amazon", "username", "password", LocalDateTime.MAX);
        Entry entry2 = new Entry("123", "google", "username", "password", LocalDateTime.MAX);
        instance.addEntry(entry1);
        instance.addEntry(entry2);
        System.out.println("deleteEntry");
        int entryNo = 0;
        instance.deleteEntry(entryNo);
        Entry result = instance.getEntry(0);
        assertEquals(entry2, result);
    }
    
}

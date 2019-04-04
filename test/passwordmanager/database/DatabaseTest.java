/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.database;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import java.sql.Date;
import static org.junit.Assert.*;

import passwordmanager.user.Entry;

/**
 *
 * @author Alex
 */
public class DatabaseTest {
    
    public DatabaseTest() {
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
     * Test of getInstance method, of class Database.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        File file = new File("/databaseTest");
        Database database = new Database("test.db", file);
        Database expResult = database;
        Database result = Database.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of createDatabase method, of class Database.
     */
    @Test
    public void testCreateDatabase() {
        System.out.println("createDatabase");
        File file = new File("/databaseTest");
        Database database = new Database("test.db", file);
    }
    
    /**
     * Test of insertData method, of class Database.
     */
    @Test
    public void testInsertData() throws SQLException {
        System.out.println("insertData");
        Entry entry1 = new Entry(1, "amazon", "username", "password", "hint1", "something@yahoo.com", LocalDate.MAX);
        Entry entry2 = new Entry(2, "google", "username", "password", "hint2", "something@gmail.com",LocalDate.MAX);
        File file = new File("/databaseTest");
        Database database = new Database("test.db", file);
        database.insertData(entry1);
        database.insertData(entry2);
        String sql = "SELECT STOREDACCOUNTID,USERNAME,PASSWORD,PASSWORDHINT,APPLICATIONNAME,EMAIL,CREATIONDATE FROM StoredAccounts";
        database.printData(sql);
    }
}
    


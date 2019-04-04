/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.user;
import java.util.*;
import java.time.*;
import java.sql.*;
import java.io.File;
import passwordmanager.database.Database;
import passwordmanager.authentication.PasswordGenerator;
/**
 *
 * @author Alex
 */
public class EntryManager {
    private ArrayList<Entry> entries = new ArrayList<>();
    Database database;
    File location;
    String  UserMainPass = "masterPassword";
    Encryption encryption = new Encryption(UserMainPass);
    byte[] secKey = encryption.getSecKey(UserMainPass);
    //notifications arraylist will go here when notifications are implemented

    /**
     * Constructor for EntryManager Class
     */
    public EntryManager(){
        //change place database is created
        location = new File("pmdb"); //(password manager database) folder
        location.mkdirs();
        database = new Database("userdb", location);
    } 
    /**
     * generates random password 
     * it use the createGenPass method from the 
     * password generator class to create 
     * the random generated password
     * @return 
     */
    public String generatePassword() {
        PasswordGenerator genPass = new PasswordGenerator(); 
        String randomPassword = genPass.createGenPass(); 
        return randomPassword; 
    }

    /**
     *
     * @param entry
     * @return
     */
    public String decryptPassword(Entry entry){
        String password = entry.getPassword();
        return encryption.decrypt(password, secKey);
    }
    /**
     * Imports all entries stored in the database
     * @throws SQLException
     */
    public void importEntries() throws SQLException{
        String sql = "SELECT * FROM StoredAccounts";
        ResultSet rs = database.selectData(sql);
        while (rs.next()) {
            Entry entry = new Entry(rs.getInt("STOREDACCOUNTID"),
            rs.getString("USERNAME"),
            rs.getString("PASSWORD"),
            rs.getString("PASSWORDHINT"),
            rs.getString("APPLICATIONNAME"),
            rs.getString("EMAIL"),
            (rs.getDate("CREATIONDATE")).toLocalDate());
            addEntry(entry);
        }
    }
   
    /**
     * Exports the specified entry to the database
     * @param entry 
     */
    public void exportEntry(Entry entry){
        database.insertData(entry);
    }
    /**
     * Exports entries to database
     */
    public void exportEntries(){
        for(Entry entry: entries){
            exportEntry(entry);
        }

    }
    

    /**
     * Add entry object to arraylist 
     * @param entry
     */
    public void addEntry(Entry entry){
        entries.add(entry);
    }
    

    /**
     * Create entry with the compulsory parameters, then add that entry to entries
     * @param entryID
     * @param service
     * @param username
     * @param password
     * @param passwordAge
     */
    public void addEntry(int entryID, String service, String username, 
            String password, LocalDate passwordAge){
        //encrypt password here
        String encryptedPassword = encryption.encrypt(password, secKey);
        Entry entry = new Entry(entryID, service, username, encryptedPassword, passwordAge);
        entries.add(entry);
        
    }
    /**
     *Create entry with the compulsory parameters and hint, then add that entry to entries
     * @param entryID
     * @param service
     * @param username
     * @param password
     * @param hint
     * @param passwordAge
     */
    public void addEntry(int entryID, String service, String username, 
            String password, String hint, LocalDate passwordAge){
        //encrypt password here
        String encryptedPassword = encryption.encrypt(password, secKey);
        Entry entry = new Entry(entryID, service, username, encryptedPassword, hint , passwordAge);
        entries.add(entry);  
    }

    /**
     *Create entry with the compulsory parameters and email, then add that entry to entries
     * @param entryID
     * @param service
     * @param username
     * @param password
     * @param passwordAge
     * @param email
     */
    public void addEntry(int entryID, String service, String username, 
            String password, LocalDate passwordAge, String email){
        //encrypt password here
        String encryptedPassword = encryption.encrypt(password, secKey);
        Entry entry = new Entry(entryID, service, username, encryptedPassword,  passwordAge, email);
        entries.add(entry);  
    }

    /**
     *Create entry with the compulsory parameters, hint and email, then add that entry to entries
     * @param entryID
     * @param service
     * @param username
     * @param password
     * @param hint
     * @param email
     * @param passwordAge
     */
    public void addEntry(int entryID, String service, String username, 
            String password, String hint, String email, LocalDate passwordAge){
        //encrypt password here
        String encryptedPassword = encryption.encrypt(password, secKey);
        Entry entry = new Entry(entryID, service, username, encryptedPassword, hint, 
                email, passwordAge);
        entries.add(entry);        
    }

    /**
     * Returns the specified entry
     * @param entryNo
     * @return entry
     */
    public Entry getEntry(int entryNo){
        return entries.get(entryNo);
    }
    //returns entries

    /**
     *
     * @return
     */
    public ArrayList<Entry> getEntries(){
        return entries;
    }

    /**
     *
     * @param entryNo
     */
    public void deleteEntry(int entryNo){
        entries.remove(entryNo);
    }

    /**
     *
     * @return
     */
    public Database getDB(){
        return database;
    }

    /**
     *
     * @return
     */
    public File getLocation(){
        return location;
    }
 
    /**
     *
     * @return
     */
    public int getNumEntries(){
        return entries.size();
    }

}

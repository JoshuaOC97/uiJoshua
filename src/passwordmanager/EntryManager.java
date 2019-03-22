/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;
import java.util.*;
import java.time.*;
/**
 *
 * @author Alex
 */
public class EntryManager {
    private ArrayList<Entry> entries = new ArrayList<>();
    //notifications arraylist will go here when notifications are implemented
    public EntryManager(){
        
    }
    //add entry with entry object
    public void addEntry(Entry entry){
        entries.add(entry);
    }
    //add entry with default parameters
    public void addEntry(String entryID, String service, String username, 
            String password, LocalDateTime passwordAge){
        //encrypt password here
        Entry entry = new Entry(entryID, service, username, password, passwordAge);
        entries.add(entry);
        
    }
    //add entry with hint
    public void addEntry(String entryID, String service, String username, 
            String password, String hint, LocalDateTime passwordAge){
        //encrypt password here
        Entry entry = new Entry(entryID, service, username, password, hint, passwordAge);
        entries.add(entry);  
    }
    //add entry with email
    public void addEntry(String entryID, String service, String username, 
            String password, LocalDateTime passwordAge, String email){
        //encrypt password here
        Entry entry = new Entry(entryID, service, username, password, passwordAge, email);
        entries.add(entry);  
    }
    //add entry with hint and email
    public void addEntry(String entryID, String service, String username, 
            String password, String hint, String email, LocalDateTime passwordAge){
        //encrypt password here
        Entry entry = new Entry(entryID, service, username, password, hint, 
                email, passwordAge);
        entries.add(entry);        
    }
    //returns entry
    public Entry getEntry(int entryNo){
        return entries.get(entryNo);
    }
    //returns entries
    public ArrayList<Entry> getEntries(){
        return entries;
    }
    public void deleteEntry(int entryNo){
        entries.remove(entryNo);
    }
    
    
}

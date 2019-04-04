/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.user;
import java.util.*;
import java.time.*;
/**
 *
 * @author Alex
 */
public class Entry {
    private int entryID;
    private String service;
    private String username;
    private String password;
    private String hint;
    private String email;
    private LocalDate passwordAge;
  
    //no hint or email

    /**
     *
     * @param entryID
     * @param service
     * @param username
     * @param password
     * @param passwordAge
     */
    public Entry(int entryID, String service, String username, 
            String password, LocalDate passwordAge){
        this.entryID = entryID;
        this.service = service;
        this.username = username;
        this.password = password;
        this.passwordAge = passwordAge;
    }
    //hint no email

    /**
     *
     * @param entryID
     * @param service
     * @param username
     * @param password
     * @param hint
     * @param passwordAge
     */
    public Entry(int entryID, String service, String username, 
            String password, String hint, LocalDate passwordAge){
        this.entryID = entryID;
        this.service = service;
        this.username = username;
        this.password = password;
        this.hint = hint;
        this.passwordAge = passwordAge;
    }
    //email no hint

    /**
     *
     * @param entryID
     * @param service
     * @param username
     * @param password
     * @param passwordAge
     * @param email
     */
    public Entry(int entryID, String service, String username, 
            String password, LocalDate passwordAge, String email){
        this.entryID = entryID;
        this.service = service;
        this.username = username;
        this.password = password;
        this.email = email;
        this.passwordAge = passwordAge;
    }
    //email and hint

    /**
     *
     * @param entryID
     * @param service
     * @param username
     * @param password
     * @param hint
     * @param email
     * @param passwordAge
     */
    public Entry(int entryID, String service, String username, 
            String password, String hint, String email, LocalDate passwordAge){
        this.entryID = entryID;
        this.service = service;
        this.username = username;
        this.password = password;
        this.hint = hint;
        this.email = email;
        this.passwordAge = passwordAge;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     *
     * @param service
     */
    public void setService(String service){
        this.service = service;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     *
     * @param passwordAge
     */
    public void setPasswordAge(LocalDate passwordAge){
        this.passwordAge = passwordAge;
    }

    /**
     *
     * @param hint
     */
    public void setHint(String hint){
        this.hint = hint;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     *
     * @return
     */
    public int getID(){
        return entryID;
    }

    /**
     *
     * @return
     */
    public String getUsername(){
        return username;
    }

    /**
     *
     * @return
     */
    public String getService(){
        return service;
    }

    /**
     *
     * @return
     */
    public String getPassword(){
        return password;
    }

    /**
     *
     * @return
     */
    public LocalDate getPasswordAge(){
        return passwordAge;
    }

    /**
     *
     * @return
     */
    public String getHint(){
        return hint;
    }

    /**
     *
     * @return
     */
    public String getEmail(){
        return email;
    }
}

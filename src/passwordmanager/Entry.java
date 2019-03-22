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
public class Entry {
    private String entryID;
    private String service;
    private String username;
    private String password;
    private String hint;
    private String email;
    private LocalDateTime passwordAge;
  
    //no hint or email
    public Entry(String entryID, String service, String username, 
            String password, LocalDateTime passwordAge){
        this.entryID = entryID;
        this.service = service;
        this.username = username;
        this.password = password;
        this.passwordAge = passwordAge;
    }
    //hint no email
    public Entry(String entryID, String service, String username, 
            String password, String hint, LocalDateTime passwordAge){
        this.entryID = entryID;
        this.service = service;
        this.username = username;
        this.password = password;
        this.hint = hint;
        this.passwordAge = passwordAge;
    }
    //email no hint
    public Entry(String entryID, String service, String username, 
            String password, LocalDateTime passwordAge, String email){
        this.entryID = entryID;
        this.service = service;
        this.username = username;
        this.password = password;
        this.email = email;
        this.passwordAge = passwordAge;
    }
    //email and hint
    public Entry(String entryID, String service, String username, 
            String password, String hint, String email, LocalDateTime passwordAge){
        this.entryID = entryID;
        this.service = service;
        this.username = username;
        this.password = password;
        this.hint = hint;
        this.email = email;
        this.passwordAge = passwordAge;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setService(String service){
        this.service = service;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPasswordAge(LocalDateTime passwordAge){
        this.passwordAge = passwordAge;
    }
    public void setHint(String hint){
        this.hint = hint;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getUsername(){
        return username;
    }
    public String getService(){
        return service;
    }
    public String getPassword(){
        return password;
    }
    public LocalDateTime getPasswordAge(){
        return passwordAge;
    }
    public String getHint(){
        return hint;
    }
    public String getEmail(){
        return email;
    }
}

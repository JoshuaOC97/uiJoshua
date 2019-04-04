/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.authentication;
import java.security.SecureRandom; 

/**
 *
 * @author Ryan Smith
 */
public class PasswordGenerator {
   
    private SecureRandom random = new SecureRandom();
  //what characters will the password be made of.

    /**
     *the large string of different characters is for the 
     * generated password to use to grab at random. 
     */
    public String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabc"
            + "defghijklmnopqrstuvwxyz0123456789~`"
            + "!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?"; 
 
// this part of the code creates the random password         

    /**
     * it use a empty string to start and then add to it
     * in till it reaches the character length that 14.  
     * @return
     */
 public String createGenPass(){
  String password = "";  
  
  for (int i = 0; i < 14; i++){
    int value = random.nextInt(characters.length());
    password += characters.charAt(value);
    
 }
   return password;
}   

 
}
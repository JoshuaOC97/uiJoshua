/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;
import java.security.SecureRandom;  
/**
 *
 * @author Ryan Smith
 */
public class PasswordGenerator {
 
    private static  SecureRandom random = new SecureRandom();
    private static int len = 14;
 private static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?"; 
 
          
 public static String createGenPass(String letter){
  String password = "";  
  for (int i = 0; i < len; i++){
    int value = random.nextInt(letter.length());
    password += letter.charAt(value);
    
 }
   return password;
}   
 public static void main(String[] args){
     String randomPassword = createGenPass(len + characters);
     System.out.println(randomPassword);
     
 }
}

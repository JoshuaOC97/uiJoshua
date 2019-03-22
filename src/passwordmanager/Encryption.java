
package passwordManager;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.nio.charset.*;
//Currently unused, import for hex and base 64 conversions
//import javax.xml.bind.DatatypeConverter;
/**
 * 
 *
 * @author UP854565
 * 
 * 
 */
public class Encryption {

    public Encryption() {

    }
    public static void main(String[] args) {
        
        String password = "password";
        String salt = "1234";
        int iterations = 10000;
        int keyLength = 128;
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = salt.getBytes(StandardCharsets.UTF_8);
        
        //hashed in PBKDF2 WithHmacSHA512
        byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
        
       //String hashedStringHex = javax.xml.bind.DatatypeConverter.printHexBinary(hashedBytes);

        byte[] encryptedBoy = (encrypt("passToStore".getBytes(StandardCharsets.UTF_8), hashedBytes));
        System.out.println(new String(decrypt(encryptedBoy,hashedBytes)));

    }

    private static final String ALGORITHM = "AES";

    public static byte[] encrypt(byte[] valueToEnc, byte[] secKey) {
        
        try {
            final Key key = new SecretKeySpec(secKey, ALGORITHM);
            final Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, key);
                
            byte[] encrypted= new byte[c.getOutputSize(valueToEnc.length)];
            int enc_len = c.update(valueToEnc, 0, valueToEnc.length, encrypted, 0);
            enc_len += c.doFinal(encrypted, enc_len);

            return encrypted;
            
            //returns encrypted value in base 64 (String)
            //return Base64.getMimeEncoder().encodeToString(encrypted);
            
            //returns encrypted value in hex (String)
            //return javax.xml.bind.DatatypeConverter.printHexBinary(encrypted);
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public static byte[] decrypt(byte[] cipherText, byte[] key){
        try{
            
        
       Key secretKey = new SecretKeySpec(key, ALGORITHM);
       Cipher cipher = Cipher.getInstance(ALGORITHM);
       cipher.init(Cipher.DECRYPT_MODE, secretKey);
       
       return cipher.doFinal(cipherText);
       
       //prints decrypted String
       //System.out.println(new String(cipher.doFinal(cipherText));
       
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public static byte[] hashPassword(char[] password, byte[] salt, int iterations, int keyLength ) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
            PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded( );
            return res;
            
        } catch(Exception e){
            throw new RuntimeException( e );
        }
    }
}

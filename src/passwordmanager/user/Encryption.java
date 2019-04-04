package passwordmanager.user;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.nio.charset.*;


/**
 *
 *
 * @author UP854565
 *
 *'
 */
public class Encryption {

    /**
     *
     * @param UserMainPassword
     */
    public Encryption(String UserMainPassword) {
        byte[] secKey = getSecKey(UserMainPassword);
    }

    /**
     *
     * @param UserMainPassword
     * @return
     */
    public byte[] getSecKey(String UserMainPassword) {
        String salt = "1234";
        int iterations = 10000;
        int keyLength = 128;
        char[] passwordChars = UserMainPassword.toCharArray();
        byte[] saltBytes = salt.getBytes(StandardCharsets.UTF_8);
        //hashed in PBKDF2 WithHmacSHA512
        byte[] secKey = hashPassword(passwordChars, saltBytes, iterations, keyLength);
        return secKey;
    }

    private static final String ALGORITHM = "AES";

    /**
     *
     * @param entryPassword
     * @param secKey
     * @return
     */
    public String encrypt(String entryPassword, byte[] secKey) {

        byte[] valueToEnc = entryPassword.getBytes(StandardCharsets.UTF_8);
        try {
            final Key key = new SecretKeySpec(secKey, ALGORITHM);
            final Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);

            byte[] encrypted = new byte[c.getOutputSize(valueToEnc.length)];
            int enc_len = c.update(valueToEnc, 0, valueToEnc.length, encrypted, 0);
            enc_len += c.doFinal(encrypted, enc_len);
            String s = javax.xml.bind.DatatypeConverter.printHexBinary(encrypted);
            System.out.println("successfully encrypted password to: " + s);
            return s;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     *
     * @param cipherText
     * @param secKey
     * @return
     */
    public static String decrypt(String cipherText, byte[] secKey) {
        try {

            byte[] cipherByteArray = new byte[cipherText.length() / 2];
            for (int i = 0; i < cipherByteArray.length; i++) {
                int index = i * 2;
                int v = Integer.parseInt(cipherText.substring(index, index + 2), 16);
                cipherByteArray[i] = (byte) v;
            }

            Key secretKey = new SecretKeySpec(secKey, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decrypted = cipher.doFinal(cipherByteArray);

            String decryptedString = new String(decrypted);
            System.out.println("succesfully decrypted string" + cipherText);
            System.out.println("into " + decryptedString);
            return decryptedString;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     *
     * @param password
     * @param salt
     * @param iterations
     * @param keyLength
     * @return
     */
    public byte[] hashPassword(char[] password, byte[] salt, int iterations, int keyLength) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

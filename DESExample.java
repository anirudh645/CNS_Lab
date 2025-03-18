 
import javax.crypto.*; 
import javax.crypto.spec.SecretKeySpec; 
import java.util.Base64; 
import java.util.Scanner; 
public class DESExample  
{ 
    public static String encrypt(String plaintext, String key) 
    { 
        try  
       { 
            Cipher ci = Cipher.getInstance("DES"); 
            SecretKeySpec ks = new SecretKeySpec(key.getBytes(), "DES"); 
            ci.init(Cipher.ENCRYPT_MODE, ks); 
            byte[] encryptedBytes = ci.doFinal(plaintext.getBytes()); 
            return Base64.getEncoder().encodeToString(encryptedBytes); 
        }  
       catch (Exception e)  
       { 
            e.printStackTrace(); 
            return null; 
        } 
    } 
       public static String decrypt(String ciphertext, String key) 
      { 
        try  
        { 
            Cipher cipher = Cipher.getInstance("DES"); 
            SecretKeySpec ks = new SecretKeySpec(key.getBytes(), "DES"); 
            cipher.init(Cipher.DECRYPT_MODE, ks); 
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext)); 
            return new String(decryptedBytes); 
        }  
       catch (Exception e)  
       { 
            e.printStackTrace(); 
            return null; 
        } 
    } 
    public static void main(String[] args)  
     { 
        Scanner scanner = new Scanner(System.in); 
        try  
        { 
           System.out.print("Enter text: "); 
            String text = scanner.nextLine(); 
            System.out.print("Enter key (8 characters): "); 
            String key = scanner.nextLine(); 
            String encryptedText = encrypt(text, key); 
            System.out.println("Encrypted Text: " + encryptedText); 
            String decryptedText = decrypt(encryptedText, key); 
            System.out.println("Decrypted Text: " + decryptedText); 
        } 
       finally  
      { 
            scanner.close(); 
        } 
    } 
} 
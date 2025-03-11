 
import java.util.Scanner; 
public class caeserCipher 
{ 
     public static String encrypt(String plaintext, int key) 
     { 
        String plaintext1=plaintext.toLowerCase(); 
        String ciphertext = new String(); 
        for (int i = 0; i < plaintext1.length(); i++)  
        { 
            int pascii = (int)plaintext1.charAt(i); 
            int result = (pascii+key)%256; 
            char encryptedChar = (char) (result); 
            ciphertext=ciphertext+encryptedChar; 
        } 
        return ciphertext.toUpperCase(); 
    } 
       public static String decrypt(String ciphertext, int key) 
        { 
        String retrievedplaintext = new String(); 
        for (int i = 0; i <ciphertext.length(); i++) { 
            int cascii = (int)ciphertext.charAt(i); 
            int result = (cascii-key)%256; 
            char decryptedChar = (char) (result); 
            retrievedplaintext=retrievedplaintext+decryptedChar; 
        } 
        return retrievedplaintext.toLowerCase(); 
    } 
        public static void main(String[] args) 
       { 
        Scanner scanner = new Scanner(System.in); 
         System.out.println("Enter plaintext: "); 
        String plaintext = scanner.nextLine(); 
        System.out.println("Enter key: "); 
        int key = scanner.nextInt(); 
        String encryptedText = encrypt(plaintext, key); 
        System.out.println("Encrypted Text: " + encryptedText); 
        String decryptedText = decrypt(encryptedText, key); 
        System.out.println("Decrypted Text: " + decryptedText); 
        scanner.close(); 
    } 
} 
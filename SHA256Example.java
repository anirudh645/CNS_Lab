 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.Scanner; 
public class SHA256Example  
{ 
 public static String generateSHA256(String input)  
  { 
        try  
       { 
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
            byte[] hash = digest.digest(input.getBytes()); 
            StringBuilder hexString = new StringBuilder(); 
            for (byte b : hash) 
            { 
                String hex = Integer.toHexString(0xff & b); 
                if (hex.length() == 1)  
               { 
                    hexString.append('0'); 
                } 
                hexString.append(hex); 
            } 
            return hexString.toString(); 
        }  
       catch (NoSuchAlgorithmException e)  
      { 
            e.printStackTrace(); 
            return null; 
        } 
    } 
    public static void main(String[] args)  
     { 
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter the Message:"); 
        String input = scanner.nextLine(); 
        String sha256Hash = generateSHA256(input); 
        System.out.println("SHA-256 Hash: " + sha256Hash); 
        scanner.close(); 
    } 
}
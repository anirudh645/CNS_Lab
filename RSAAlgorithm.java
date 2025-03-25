 
import java.math.BigInteger; 
import java.security.SecureRandom; 
import java.util.*; 
public class RSAAlgorithm 
{ 
    private BigInteger privateKey; 
    private BigInteger publicKey; 
    private BigInteger n; 
    public RSAAlgorithm(int bitLength)  
   { 
        SecureRandom random = new SecureRandom(); 
        BigInteger p = BigInteger.probablePrime(bitLength / 2, random); 
        System.out.println("First Prime Number p="+p); 
        BigInteger q = BigInteger.probablePrime(bitLength / 2, random); 
        System.out.println("Second Prime Number q="+q); 
        n = p.multiply(q); 
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); 
        publicKey = generatePublicKey(phi, random); 
        privateKey = publicKey.modInverse(phi); 
    } 
    private BigInteger generatePublicKey(BigInteger phi, SecureRandom random) 
      { 
        BigInteger e; 
        do { 
            e = new BigInteger(phi.bitLength(), random); 
        } while (e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0 || 
!e.gcd(phi).equals(BigInteger.ONE)); 
        return e; 
    } 
    public BigInteger[] encrypt(String message)  
    { 
        byte[] bytes = message.getBytes(); 
        BigInteger[] encrypted = new BigInteger[bytes.length]; 
        for (int i = 0; i < bytes.length; i++) { 
            encrypted[i] = BigInteger.valueOf(bytes[i]).modPow(publicKey, n); 
        } 
        return encrypted; 
    } 
    public String decrypt(BigInteger[] ciphertext)  
    { 
        byte[] decryptedBytes = new byte[ciphertext.length]; 
        for (int i = 0; i < ciphertext.length; i++)  
        { 
            decryptedBytes[i] = ciphertext[i].modPow(privateKey, n).byteValue(); 
        } 
        return new String(decryptedBytes); 
    } 
    public static void main(String[] args)  
    { 
        int bitLength = 1024;  
        RSAAlgorithm rsa = new RSAAlgorithm(bitLength); 
        Scanner s=new Scanner(System.in); 
        System.out.println("Enter the plain text:");
        String message =s.nextLine(); 
        BigInteger[] encryptedMessage = rsa.encrypt(message); 
        System.out.println("Encrypted Message: " + Arrays.toString(encryptedMessage)); 
        String decryptedMessage = rsa.decrypt(encryptedMessage); 
        System.out.println("Decrypted Message: " + decryptedMessage); 
        s.close();
    } 
}
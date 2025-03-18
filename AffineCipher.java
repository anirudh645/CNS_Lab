import java.util.Scanner;
public class AffineCipher
{
    public static String encrypt(String plaintext, int key1,int key2)
    {
        String plaintext1=plaintext.toLowerCase();
        StringBuffer ciphertext = new StringBuffer();
        for (int i = 0; i < plaintext1.length(); i++) {
            int pAscii = (int)plaintext1.charAt(i);
            int result = (pAscii*key1+key2)%256;
            char encryptedChar = (char) (result);
            ciphertext=ciphertext.append(encryptedChar);
        }
        return ciphertext.toString();
    }
    public static String decrypt(String ciphertext, int key1, int key2)
    {
        StringBuffer retrievedplaintext = new StringBuffer();
        for (int i = 0; i <ciphertext.length(); i++)
        {
            int cascii = (int)ciphertext.charAt(i);
            int inversekey=multiplicativeInverse(key1);
            int result = ((cascii-key2)*inversekey)%256;
            char decryptedChar = (char) (result);
            retrievedplaintext.append(decryptedChar);
        }
        return retrievedplaintext.toString();
    }
    public static int multiplicativeInverse(int key)
    {
        int m=256;
        int m0=m;
        int y = 0, x = 1;
        while (key > 1)
        {
            int q = key / m;
            int t = m;
            m = key % m;
            key = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0)
            x += m0;
        return x;
    }
        public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        System.out.println("Enter the first key: ");
        int key1 = scanner.nextInt();
        System.out.println("Enter the second key: ");
        int key2 = scanner.nextInt();
        String encryptedText = encrypt(plaintext, key1, key2);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = decrypt(encryptedText, key1, key2);
        System.out.println("Decrypted Text: " + decryptedText);
        scanner.close();
    }
}
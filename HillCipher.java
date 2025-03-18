import java.util.Scanner;
public class HillCipher {
    public static String encrypt(String plaintext, int[][] key) {
        StringBuilder ciphertext = new StringBuilder();
        StringBuilder plaintextBuilder = new StringBuilder(plaintext);
        while (plaintextBuilder.length() % 3 != 0) {
            plaintextBuilder.append('X');
        }
        plaintext = plaintextBuilder.toString();
        plaintext = plaintext.toUpperCase();
        for (int i = 0; i < plaintext.length(); i += 3) {
            int[] block = new int[3];
            for (int j = 0; j < 3; j++) {
                block[j] = plaintext.charAt(i + j) - 'A';
            }
            {
                int[] result = multiplyMatrix(key, block);
                for (int j = 0; j < 3; j++)
                    ciphertext.append((char) (result[j] % 26 + 'A'));
            }
        }
        return ciphertext.toString();
    }

    private static int[] multiplyMatrix(int[][] matrix, int[] vector) {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = 0;
            for (int j = 0; j < 3; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        int[][] key = new int[3][3];
        System.out.println("Enter key matrix (3x3):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                key[i][j] = scanner.nextInt();
            }
        }
        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + encryptedText);
        scanner.close();
    }
}
 
import java.util.Scanner; 
public class ModularInverseSolver  
{ 
    public static int modInverse(int a, int m) 
 { 
        int[] coefficients = new int[2]; 
        int gcd = extendedGCD(a, m, coefficients); 
        if (gcd != 1)  
       { 
            throw new ArithmeticException("Modular inverse does not exist"); 
        } 
        return (coefficients[0] % m + m) % m;  
    } 
    public static int extendedGCD(int a, int b, int[] coefficients) 
 { 
        int r1 = a, r2 = b, s1 = 1, s2 = 0, t1 = 0, t2 = 1; 
        int q, r, s, t; 
        while (r2 > 0) { 
            q = r1 / r2; 
            r = r1 - q * r2; 
            r1 = r2; 
            r2 = r; 
            s = s1 - q * s2; 
            s1 = s2; 
            s2 = s; 
            t = t1 - q * t2; 
            t1 = t2; 
            t2 = t; 
        } 
        coefficients[0] = s1; 
        coefficients[1] = t1; 
        return r1; 
    } 
    public static int determinantModulo(int[][] matrix, int mod) 
 { 
        int det = (matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) 
                 - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) 
                 + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0])) % 
mod; 
        return (det + mod) % mod;  
    } 
    public static int[][] adjugateMatrix(int[][] matrix, int mod)  
{ 
        int[][] adj = new int[3][3]; 
        adj[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) % mod; 
        adj[0][1] = (matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2]) % mod; 
        adj[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]) % mod; 
        adj[1][0] = (matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2]) % mod; 
        adj[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]) % mod; 
        adj[1][2] = (matrix[0][2] * matrix[1][0] - matrix[0][0] * matrix[1][2]) % mod; 
        adj[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]) % mod; 
        adj[2][1] = (matrix[0][1] * matrix[2][0] - matrix[0][0] * matrix[2][1]) % mod; 
        adj[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) % mod; 
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                adj[i][j] = (adj[i][j] + mod) % mod; 
        return adj; 
    } 
    public static int[] solveModularSystem(int[][] matrix, int[] constants, int mod)  
   { 
        int det = determinantModulo(matrix, mod); 
        int detInverse = modInverse(det, mod); 
        int[][] adj = adjugateMatrix(matrix, mod); 
        int[] solution = new int[3]; 
        for (int i = 0; i < 3; i++) { 
            solution[i] = 0; 
            for (int j = 0; j < 3; j++) { 
                solution[i] = (solution[i] + adj[i][j] * constants[j]) % mod; 
            } 
            solution[i] = (solution[i] * detInverse) % mod; 
        } 
        return solution; 
    } 
    public static void main(String[] args) 
 { 
        Scanner scanner = new Scanner(System.in); 
        int[][] matrix = new int[3][3]; 
        int[] constants = new int[3]; 
        System.out.println("Enter the modulo value:"); 
        int mod = scanner.nextInt(); 
        System.out.println("Enter the coefficients of the equations (row-wise):"); 
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) 
                matrix[i][j] = scanner.nextInt() % mod; 
        System.out.println("Enter the constant terms:"); 
        for (int i = 0; i < 3; i++) 
            constants[i] = scanner.nextInt() % mod; 
        try { 
            int[] solution = solveModularSystem(matrix, constants, mod); 
            System.out.println("Solution:"); 
            for (int i = 0; i < 3; i++) 
                System.out.printf("x%d ≡ %d (mod %d)\n", i + 1, solution[i], mod); 
        }  
catch (ArithmeticException e) 
 { 
            System.out.println("No unique solution exists."); 
        } 
 
        scanner.close(); 
    } 
} 
import java.util.Scanner; 
public class LinearCongruenceSolver 
 { 
    public static int extendedGCD(int a, int b, int[] coefficients) 
 { 
        int r1 = a, r2 = b; 
        int s1 = 1, s2 = 0, t1 = 0, t2 = 1; 
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
    public static void solveLinearCongruence(int a, int b, int n) 
    { 
        int[] coefficients = new int[2];  
        int gcd = extendedGCD(a, n, coefficients); 
        if (b % gcd != 0)  
       { 
            System.out.println("No solution exists."); 
            return; 
        } 
        int x0 = (coefficients[0] * (b / gcd)) % n; 
        if (x0 < 0) 
       { 
            x0 += n; 
        } 
        System.out.println("Particular Solution: x0 = " + x0); 
     System.out.println("General Solution: x = " + x0 + " + " + (n / gcd) + "t (mod " + n + ")"); 
        System.out.println("(where t is any integer)"); 
    } 
    public static void main(String[] args) 
   { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter coefficient a: "); 
        int a = scanner.nextInt(); 
        System.out.print("Enter constant b: "); 
        int b = scanner.nextInt(); 
        System.out.print("Enter modulus n: "); 
        int n = scanner.nextInt(); 
        solveLinearCongruence(a, b, n); 
        scanner.close(); 
    } }
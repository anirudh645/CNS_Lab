import java.util.Scanner; 
public class LinearDiophantineSolver 
 { 
 public static int extendedGCD(int a, int b, int[] coefficients) 
 { 
        int r1 = a, r2 = b; 
        int s1 = 1, s2 = 0, t1 = 0, t2 = 1; 
        int q, r, s, t; 
        while (r2 > 0) 
       { 
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
    public static void solveDiophantine(int a, int b, int c) 
 { 
        int[] coefficients = new int[2]; // To store x0 and y0 
        int gcd = extendedGCD(a, b, coefficients); 
        if (c % gcd != 0)  
      { 
            System.out.println("No integer solution exists."); 
            return; 
        } 
        int x0 = coefficients[0] * (c / gcd); 
        int y0 = coefficients[1] * (c / gcd); 
        System.out.println("Particular Solution: x0 = " + x0 + ", y0 = " + y0); 
        System.out.println("General Solution: x = " + x0 + " + (" + (b / gcd) + ")t"); 
        System.out.println("                   y = " + y0 + " - (" + (a / gcd) + ")t"); 
        System.out.println("(where t is any integer)"); 
    } 
    public static void main(String[] args)  
     { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter coefficient a: "); 
        int a = scanner.nextInt(); 
        System.out.print("Enter coefficient b: "); 
        int b = scanner.nextInt(); 
        System.out.print("Enter constant c: "); 
        int c = scanner.nextInt(); 
        solveDiophantine(a, b, c); 
        scanner.close(); 
    }}
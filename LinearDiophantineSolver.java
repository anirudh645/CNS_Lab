import java.util.Scanner; 
public class LinearDiophantineSolver 
 { 
 public static int extendedGCD(int a, int b, int[] coefficients) 
 {
     return LinearCongruenceSolver.extendedGCD(a, b, coefficients);
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
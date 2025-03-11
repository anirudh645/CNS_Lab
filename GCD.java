//Take two numbers as input and find the geatest common divisor with the help of extended euclidean method
import java.util.*;

class GCD{
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the 2 integers to find GCD:");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r1 = Math.max(a, b);
            int r2 = Math.min(a, b);
            int  q = 0, r = 0;
            while (r2 > 0){
                q = r1 / r2;
                r = r1 - q * r2;
                r1 = r2;
                r2 = r;
            }
            System.out.println("The GCD of "+a+" and "+b+" is: "+r1);
            sc.close();
    }
}
//Take two numbers as input and find the geatest common divisor with the help of extended euclidean method
import java.util.*;
class ExtendedEuclidean{
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the 2 integers to find GCD:");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r1 = Math.max(a, b);
            int r2 = Math.min(a, b);
            int s1 = 1;
            int s2 = 0, s = 0;
            int t1 = 0, t2 = 1, t = 0, q = 0, r = 0;
            while (r2 > 0){
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
            System.out.println("The GCD of "+a+" and "+b+" is: "+r1);
            System.out.println("Values of S and T are:");
            System.out.println("S: "+s1);
            System.out.println("T: "+t1);
            sc.close();
    }
}
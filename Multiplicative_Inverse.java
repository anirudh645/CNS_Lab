import java.util.*;
public class Multiplicative_Inverse {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the intger to find Multiplicative inverse:");
            int a = sc.nextInt();
            System.out.println("Enter the modulo value to find Multiplicative inverse:");
            int b = sc.nextInt();
            if (a > b){
                a = a % b;
            }
            int r1 = b, r2 = a;
            int t1 = 0, t2 = 1, t = 0, q = 0, r = 0;
            while (r2 > 0){
                q = r1 / r2;
                r = r1 - q * r2;
                r1 = r2;
                r2 = r;
                t = t1 - q * t2;
                t1 = t2;
                t2 = t;
            }
            if (r1 != 1){
                System.out.println("The give number does not have a multiplicative inverse...");
            }else{
                System.out.println("The multiplicative inverse of "+a+" in mod "+b+" is: "+ (t1<0?Math.max(a,b)+t1:t1));
            }
            sc.close();
    }
}

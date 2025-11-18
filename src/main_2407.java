import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static int n, c;
    public static BigInteger a = BigInteger.ONE;
    public static BigInteger b = BigInteger.ONE; 

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        c = sc.nextInt();
        
        int or_n = n;
        int or_c = c;
        

        if (n / 2 > c) {

        } else {
            c = n - c;
        }


        while (n >= (or_n - c + 1)) {
            a = a.multiply(BigInteger.valueOf(n)); 
            n--;
        }
        
        while (c > 1) {
            b = b.multiply(BigInteger.valueOf(c)); 
            c--;
        }
        
        System.out.println(a.divide(b)); 
        
        sc.close();
    }
}

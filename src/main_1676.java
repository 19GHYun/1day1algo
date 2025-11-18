import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	
    	int count2 = countPrime(n, 2);
        int count5 = countPrime(n, 5);
        
        int trailingZeros = Math.min(count2, count5);
        System.out.println(trailingZeros);
    	
    }
    
    public static int countPrime(int k, int p) {
        int count = 0;	//소인수 분해. p 가 몇번 들어가는지
        while (k >= p) {
            k /= p;
            count += k;
        }
        return count;
    }
    
}



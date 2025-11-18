import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        sc.close();

        
        int length = (int)(max - min + 1);
        boolean[] isNotSquareFree = new boolean[length]; // 제곱ㄴㄴ수 넣을 곳

        
        int sqrtMax = (int)Math.sqrt(max);
        List<Integer> primes = getPrimes(sqrtMax);

        
        for (int p : primes) {
            long p2 = (long)p * p; // p^2 계산 (long으로 캐스팅)
            if (p2 > max) break;

            // min 이상의 첫 번째 p의 제곱 배수를 찾아야함
            long start = ((min + p2 - 1) / p2) * p2; // 올림 처리
            for (long i = start; i <= max; i += p2) {
                isNotSquareFree[(int)(i - min)] = true; // 제곱 ㄴㄴ수 아니면 컷
            }
        }

       
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (!isNotSquareFree[i]) count++;
        }

        System.out.println(count);
    }

    
    private static List<Integer> getPrimes(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) { //
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = i + i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        return primes;
    }
}

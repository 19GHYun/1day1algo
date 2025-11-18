import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        final long MOD = 1000000007L;
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            long[] dp = new long[K + 1]; // K까지만 계산하면 충분
            
            dp[0] = 1; // nC0 = 1
            
            int bun_ja_count = N;
            int bun_mo_count = 1;
            
            for (int j = 1; j <= K; j++) { // K까지만 계산
                dp[j] = (dp[j - 1] % MOD * bun_ja_count % MOD) % MOD; // 곱셈
                
                long bun_mo_inverse = 1;
                long base = bun_mo_count % MOD;
                long exp = MOD - 2;
                long temp = 1;
                while (exp > 0) {
                    if (exp % 2 == 1) {
                        temp = (temp * base) % MOD;
                    }
                    base = (base * base) % MOD;
                    exp /= 2;
                }
                bun_mo_inverse = temp;
                
                dp[j] = (dp[j] * bun_mo_inverse) % MOD; // 나눗셈 대신 역원 곱셈
                
                bun_ja_count--;
                bun_mo_count++;
            }
            
            System.out.println(dp[K]); // 이미 모듈러 적용된 값 출력
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[100002];
        
        dp[1] = 3;
        dp[2] = 7;
        dp[3] =17;
        
        if(N>3) {
        	for(int i = 4 ; i <= N ; i++) {
        		dp[i] = dp[i-1] * 2 % 9901 + dp[i-2] % 9901;
        	}
        	System.out.println(dp[N]%9901);
        }else {
        	System.out.println(dp[N]);
        }
        
    }

}

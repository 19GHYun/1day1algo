import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        int divide = 1000000009;
    	int[] dp = new int[1000002];
    	
    	dp[1] = 1;
    	dp[2] = 2;
    	dp[3] = 4;
    	
    	for(int j = 3 ; j < 1000001 ; j++) {
    		dp[j+1] += dp[j]%divide;
    		dp[j+1] %= divide;
    		dp[j+1] += dp[j-1]%divide;
    		dp[j+1] %= divide;
    		dp[j+1] += dp[j-2]%divide;
    		dp[j+1] %= divide;
    	}
    	
        for(int i = 0 ; i < T ; i++) {

        	System.out.println(dp[Integer.parseInt(br.readLine())]);
        	
        }
        

    }
}


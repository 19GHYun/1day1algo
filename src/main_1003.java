import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[41];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        
        for(int i = 0 ; i < N ; i++) {
            int M = Integer.parseInt(br.readLine());
        	for(int j = 4 ; j < 41 ; j++) {
            	dp[j] = dp[j-1] + dp[j-2];
            	
            }
            
            
            if( M == 0) {
            	sb.append(1).append(" ").append(0).append("\n");
            }
            else {
            	sb.append(dp[M-1]).append(" ").append(dp[M]).append("\n");
            }
            
        }
        System.out.println(sb);
        

        
    }

}


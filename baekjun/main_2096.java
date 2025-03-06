import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1][3];
        
        int[][][] dp = new int[N + 1][3][2];
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < 3 ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dp[0][0][0] = arr[0][0];
        dp[0][1][0] = arr[0][1];
        dp[0][2][0] = arr[0][2];
        dp[0][0][1] = arr[0][0];
        dp[0][1][1] = arr[0][1];
        dp[0][2][1] = arr[0][2];
        
        for(int i = 1 ; i <= N ; i++) { // 큰거
        	dp[i][0][0] = arr[i][0] + Math.max(dp[i-1][0][0], dp[i-1][1][0]);
        	dp[i][0][1] = arr[i][0] + Math.min(dp[i-1][0][1], dp[i-1][1][1]);
        	dp[i][1][0] = arr[i][1] + Math.max(dp[i-1][2][0],Math.max(dp[i-1][1][0], dp[i-1][0][0]));
        	dp[i][1][1] = arr[i][1] + Math.min(dp[i-1][2][1],Math.min(dp[i-1][1][1], dp[i-1][0][1]));
        	dp[i][2][0] = arr[i][2] + Math.max(dp[i-1][2][0], dp[i-1][1][0]);
        	dp[i][2][1] = arr[i][2] + Math.min(dp[i-1][2][1], dp[i-1][1][1]);
        }
        
        
        System.out.print(Math.max(dp[N - 1][2][0],Math.max(dp[N - 1][1][0], dp[N - 1][0][0])));
        System.out.print(" ");
        System.out.print(Math.min(dp[N - 1][2][1],Math.min(dp[N - 1][1][1], dp[N - 1][0][1])));
        

    }
    

}

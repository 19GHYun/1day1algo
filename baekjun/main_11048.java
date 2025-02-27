import java.util.*;
import java.io.*;

public class Main {
	public static int N,M,answer; // height, width, answer
	public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int[][] dp = new int[N+2][M+2];
        
        
        
        for(int i = 1 ; i < N + 1 ; i++) {
        	for(int j = 1 ; j < M + 1 ; j++) {
        		if(i == 1 && j == 1) {
        			dp[1][1] = arr[0][0];
        		}else {
        			dp[i][j] = Math.max(dp[i][j - 1] + arr[i - 1][j - 1], dp[i - 1][j] + arr[i - 1][j - 1]);
        		}
   				
        	}
        }
        
        System.out.println(dp[N][M]);
        
        
    }
}













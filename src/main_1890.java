import java.util.*;
import java.io.*;

public class Main {
	public static int N,answer; // height&width, answer
	public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());

        
        arr = new int[N][N];
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < N ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        long[][] dp = new long[120][120];
        dp[0][0] = 1;
        
        for(int i = 0 ; i < N ; i++) {
        	for(int j = 0 ; j < N ; j++) {
        		if( i == N - 1 && j == N - 1) {
        			break;
        		}
        		dp[i + arr[i][j]][j] = dp[i][j] + dp[i + arr[i][j]][j] ;
        		dp[i][j + arr[i][j]] = dp[i][j] + dp[i][j + arr[i][j]];
        	}
        }

        
        System.out.println(dp[N - 1][N - 1]);
    }
}













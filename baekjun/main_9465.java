import java.util.*;
import java.io.*;

public class Main {
    public static int T,N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < T ; i++) {
        	N = Integer.parseInt(br.readLine());
        	
        	arr = new int[2][N];
        	
        	for(int q = 0 ; q < 2 ; q++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0 ; j < N ; j++) {
        			arr[q][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int[][] dp = new int[2][N+1];
        	
        	dp[0][0] = arr[0][0];
        	dp[1][0] = arr[1][0];
        	
        	for(int q = 1 ; q < N ; q++) {
        		if(q == 1) {
            		dp[0][q] = dp[1][q-1] + arr[0][q];
            		dp[1][q] = dp[0][q-1] + arr[1][q];
        		}else {
            		dp[0][q] = Math.max(dp[1][q-1] + arr[0][q], dp[1][q-2] + arr[0][q] );
            		dp[1][q] = Math.max(dp[0][q-1] + arr[1][q], dp[0][q-2] + arr[1][q] );
        		}

        	}
        	
//        	for(int q = 0 ; q < 2 ; q++) {
//        		for(int j = 0 ; j < N ; j++) {
//        			System.out.print(dp[q][j] + " ");
//        		}
//        		System.out.println();
//        	}
        	
        	
        	
        	System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
        	
        }
        
        
        
    }



}

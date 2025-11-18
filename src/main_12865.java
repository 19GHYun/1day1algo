import java.util.*;
import java.io.*;

public class Main {
	public static int N,K; // 물품수, 버틸수 있는 최대무게
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[] weight = new int[N+1];
        int[] good = new int[N+1];
        
        for(int i = 1 ; i <= N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	weight[i] = Integer.parseInt(st.nextToken());
        	good[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N+1][K+1];
        
        for(int i = 1 ; i <= N ; i++) {
        	for(int j = 0 ; j <= K ; j++) {
        		dp[i][j] = dp[i-1][j]; // 물건을 안넣을 때
        		
        		//물건을 넣을 수 있을 때
        		if(j >= weight[i]) {
        			dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight[i]] + good[i]);
        			//안넣은 거랑 넣은것 중 더 큰거로.
        		}
        	}
        }
        
        System.out.println(dp[N][K]);
        

        
    }

}


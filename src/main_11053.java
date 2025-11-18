import java.io.*;
import java.util.*;

    public class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int N = Integer.parseInt(br.readLine());
            
            int[] arr = new int[N + 1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 1 ; i <= N ; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] dp = new int[N + 1];
            for(int i = 0 ; i < N + 1 ; i++) {
            	dp[i] = 1;
            }
            
            for(int i = 1 ; i <= N ; i++) {
            	for(int j = 1 ; j <= i ; j++) {
            		if(arr[j] < arr[i]) {
            			dp[i] = Math.max(dp[i], dp[j] + 1);
            		}
            	}
            	
            }
//            for(int a : dp) {
//            	System.out.print(a + " ");
//            }
//            System.out.println();
            int a1 = 0;
            for(int i = 1 ; i <= N ; i++) {
            	a1 = Math.max(a1, dp[i]);
            }
            
            System.out.println(a1);
            
        }

}

import java.io.*;
import java.util.*;

    public class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int N = Integer.parseInt(br.readLine());
            
            int[][] arr2 = new int[501][501];
            int[] arr = new int[501];
            int[] arr3 = new int[N+1];
            
            for(int i = 0 ; i < N ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                int a1 = Integer.parseInt(st.nextToken());
                int a2 = Integer.parseInt(st.nextToken());
                
                arr2[a1][a2] = 1;

            }
            
            for(int i = 1 ; i <= 500 ; i++) {
            	for(int ii = 1 ; ii <= 500 ; ii++) {
            		if(arr2[i][ii] == 1) {
            			arr[ii] = i;
            		}
            		
            	}
            }
            
            int test = 1;
            
            for(int i = 1 ; i <= 500 ; i++) {
            	if(test == N + 1) {
            		break;
            	}
            	if(arr[i] != 0) {
            		arr3[test] = arr[i];
                	test++;
            	}

            }

            
            int[] dp = new int[N + 1];
            for(int i = 0 ; i < N + 1 ; i++) {
                dp[i] = 1;
            }
            
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= i ; j++) {
                    if(arr3[j] < arr3[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                
            }
//            for(int a : arr3) {
//                System.out.print(a + " ");
//            }
//            System.out.println();
//            
//            for(int a : arr) {
//                System.out.print(a + " ");
//            }
//            System.out.println();
//            
//            for(int a : dp) {
//                System.out.print(a + " ");
//            }
//            System.out.println();
            int a1 = 0;
            for(int i = 1 ; i <= N ; i++) {
                a1 = Math.max(a1, dp[i]);
            }
            
            System.out.println(N - a1);
            
        }

}



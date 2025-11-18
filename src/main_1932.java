import java.util.*;
import java.io.*;

public class Main {
    public static int N ; // 삼각형 크기


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        int size = 0;
        
        for(int i = N ; i >= 0 ; i--) {
        	size += i;
        }
        
        int[] arr = new int[size + 1];
        int[] dp = new int[size + 1];
        
        int cnt = 0;
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < i + 1 ; j++) {
        		arr[cnt] = Integer.parseInt(st.nextToken());
        		cnt++;
        	}
        }
        
        dp[0] = arr[0];
        cnt = 1;
        for (int i = 1; i < N; i++) { // 1번 수정
            for (int j = 0; j < i + 1; j++) { // i+1개 원소 처리
                if (j > 0) { // 왼쪽 부모
                    dp[cnt] = Math.max(dp[cnt], dp[cnt - i - 1] + arr[cnt]);
                }
                if (j < i) { // 오른쪽 부모
                    dp[cnt] = Math.max(dp[cnt], dp[cnt - i] + arr[cnt]);
                }
                cnt++;
            }
        }
        
//        for(int a : dp) {
//        	System.out.print(a + " ");
//        }
//        System.out.println();
        // 출력 수정
        int max = 0;
        for (int j = cnt - N; j < cnt; j++) {
            max = Math.max(max, dp[j]);
        }
        System.out.println(max);
        
        
    }

}

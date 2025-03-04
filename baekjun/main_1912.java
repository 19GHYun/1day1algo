import java.io.*;
import java.util.*;

	public class Main {
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        // 수열의 크기 입력
	        int n = Integer.parseInt(br.readLine());
	        
	        // 수열 입력
	        int[] arr = new int[n];
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int i = 0; i < n; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        // DP 배열: 각 위치까지의 최대 연속합
	        int[] dp = new int[n];
	        dp[0] = arr[0];  // 첫 번째 수로 초기화
	        
	        // 최대값 추적
	        int max = dp[0];
	        
	        // DP 점화식 적용
	        for(int i = 1; i < n; i++) {
	            // 이전까지의 합에 현재 수를 더하는 경우 vs 현재 수부터 새로 시작
	            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
	            // 전체 최대값 갱신
	            max = Math.max(max, dp[i]);
	        }
//	        for(int a : dp) {
//	        	System.out.print(a + " ");
//	        }
	        
	        // 결과 출력
	        System.out.println(max);
	    }
	}

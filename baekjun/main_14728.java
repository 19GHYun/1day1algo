import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 단원 개수
		int T = Integer.parseInt(st.nextToken()); // 최대 시간
		
		int[] subject = new int[N+1];
		int[] limit = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			subject[i] = Integer.parseInt(st.nextToken());
			limit[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int[][] DP = new int[N+1][T+1];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int ii = 1 ; ii <= T ; ii++) {
				DP[i][ii] = DP[i-1][ii];
				
				if(ii >= subject[i]) {
					DP[i][ii] = Math.max(DP[i][ii], DP[i - 1][ii-subject[i]] + limit[i]);
				}
				
			}
		}

		System.out.println(DP[N][T]);
		

	}

}

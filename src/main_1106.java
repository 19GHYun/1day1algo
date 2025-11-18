import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken()); // 목표 인원
		int N = Integer.parseInt(st.nextToken()); // 도시 개수
		
		int[] city_money = new int[N+1];
		int[] city_person = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st =  new StringTokenizer(br.readLine());
		
			city_money[i] = Integer.parseInt(st.nextToken());
			city_person[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] DP = new int [N+1][100001];
		
		int answer = Integer.MAX_VALUE;
		
		for(int i = 1 ; i <= N ; i++) {
			for(int ii = 1 ; ii <= 100000 ; ii++) {
				DP[i][ii] = DP[i-1][ii];
				
				
				if(ii >= city_money[i]) {
					DP[i][ii] = Math.max(DP[i][ii], DP[i][ii-city_money[i]] + city_person[i]);
					if(DP[i][ii] >= C) {
						answer = Math.min(answer, ii);
					}
				}
				
			}
			
			
		}
				
		System.out.println(answer);
		
	}

}

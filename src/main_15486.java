import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		int[] day = new int[N+1];
		
		int[] money = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			day[i] = Integer.parseInt(st.nextToken());
			
			money[i] = Integer.parseInt(st.nextToken());
			
		}
		
		
		int[] DP = new int[1500051];
		
		
		for(int i = 1 ; i <= N + 1 ; i++) {
			DP[i] = Math.max(DP[i],DP[i-1]);
			
			if(i <= N) {
				DP[i + day[i]] = Math.max(DP[i + day[i]],DP[i] + money[i]);
			}

			

		}

//		for(int i = 1 ; i <= N + 5 ; i++) {
//			System.out.print(DP[i] + " ");
//		}
		
		System.out.println(DP[N + 1]);
		
	}


}

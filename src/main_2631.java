import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] DP = new int[201];
		
		Arrays.fill(DP, 1);
		
		DP[0] = 0;
		
		
		for(int i = 1 ; i <= N ; i++) {
			for(int ii = 1 ; ii <= i ; ii++) {
				if(arr[ii] < arr[i]) {
					DP[i] = Math.max(DP[i], DP[ii]+1);
				}
				
				
			}
		}
		int length = -1;
		
		for(int a : DP) {
			length = Math.max(a, length);
		}
		
		System.out.println(N - length);

	}


}

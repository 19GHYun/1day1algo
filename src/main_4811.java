import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long[] DP = new long[31];
		
		DP[0] = 1;
		DP[1] = 1;
		DP[2] = 2;
		
		
		for(int i = 2 ; i < 30 ; i++) {
			for(int ii = 0 ; ii <= i ; ii++ ) {
				DP[i+1] = DP[i+1] + DP[ii]*DP[i-ii];
			}
			
			
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			else {
				System.out.println(DP[N]);
			}
			
		}

	}


}

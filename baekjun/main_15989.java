import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		int[] DP = new int[10001];
		
		for(int i = 1; i <= 10000 ; i++) {
			int a = 0;
			
			for(int ii = i - 3 ; ii >= 2 ; ii -= 3) {
				a += ii/2;
			}
			
			DP[i] = 1 + i/2 + i/3 + a;
			
			
		}
		
		for(int i = 0 ; i < N ; i++) {
			System.out.println(DP[Integer.parseInt(br.readLine())]);
		}
		
	}


}


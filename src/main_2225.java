import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int DIVIDE = 1000000000;
		
		int[][] DP = new int[201][201];
		
		
		for(int i = 1 ; i <= 200 ; i++) {
			DP[i][1] = i;
			DP[1][i] = 1;
		}
		
		for(int i = 2 ; i <= 200 ; i++) {
			for(int ii = 2 ; ii <= 200 ; ii++) {
				DP[i][ii] = DP[i-1][ii]%DIVIDE + DP[i][ii-1]%DIVIDE;
			}
		}
		
		
		System.out.println(DP[E][N]%DIVIDE);
		

	}

}

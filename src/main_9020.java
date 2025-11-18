import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N =Integer.parseInt(br.readLine());

		boolean[] sosu = new boolean[10001];
		
		sosu[1] = true;
		
		for(int i = 2 ; i <= 5000 ; i++) {
			int p = 2;
			while(p * i <= 10000) {
				if(!sosu[i * p]) {
					sosu[i*p] = true;
				}
				
				p++;
			}
			
		}

		
		for(int i = 0 ; i < N ; i++) {
			int S = Integer.parseInt(br.readLine());
			
			int answer1 = 0;
			int answer2 = 0;
			
			for(int ii = 1 ; ii <= S / 2 ; ii++) {
				if(!sosu[ii]) {
					if(!sosu[S-ii]) {
						answer1 = ii;
						answer2 = S - ii;
					}
				}
			}
			sb.append(answer1).append(" ").append(answer2).append("\n");
			
		}
		
		System.out.println(sb);
	}

}

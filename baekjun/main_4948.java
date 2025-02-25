import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			if(K == 0) {
				break;
			}
			
			boolean[] check = new boolean[K*2 + 1];
			check[1] = true;
			int cnt = 0;
			for(int i = 2 ; i <= Math.sqrt(K * 2) ; i++) { // = 해줘야함
				if(!check[i]) {
					for(int j = 2 ; j <= K*2/i ; j++) {
						if(!check[i*j]) {
							check[i*j] = true;
						}
					}
				}
			}
			
			for(int i = K + 1 ; i < K * 2 + 1 ; i++) {
				if(!check[i]) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		
		
		

		
	}
}

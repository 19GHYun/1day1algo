import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] check = new boolean[K + 1];
		check[1] = true;
		for(int i = 2 ; i <= Math.sqrt(K) ; i++) { // = 해줘야함
			if(!check[i]) {
				for(int j = 2 ; j <= K / i ; j++) {
					if(!check[i*j]) {
						check[i*j] = true;
					}
				}
			}
		}
		
		for(int i = N ; i < K + 1 ; i++) {
			if(!check[i]) {
				System.out.println(i);
			}
		}
		

		
	}
}

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		boolean[] check = new boolean[N + 1];
		for(int i = 2 ; i < N + 1; i++) {
			if(!check[i]) {
				for(int j = 1 ; j <= N / i ; j++) {
					if(!check[j * i]) {
//						System.out.println("엄 " + j * i);
						check[j * i] = true;
						cnt++;
						if(cnt == K) {
							System.out.println(j * i);
							i = N;
							break;
						}
					}
				}
			}
		}
		

		
	}
}

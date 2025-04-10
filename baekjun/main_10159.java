import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[V+1][V+1];
		
		for(int i = 1 ; i <= V ; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
			arr[i][i] = 0;
		}
		
		
		for(int i = 1 ; i <= E ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			
		}
		
		for(int i = 1 ; i <= V ; i++) { // 중간
			for(int ii = 1 ; ii <= V ; ii++) { // 처음
				for(int iii = 1 ; iii <= V ; iii++) { // 끝
					if(arr[ii][i] != Integer.MAX_VALUE && arr[i][iii] != Integer.MAX_VALUE) {
						arr[ii][iii] = Math.min(arr[ii][iii], arr[ii][i] + arr[i][iii]);
						
					}
					
				}
			}
		}
		
//		for(int i = 1 ; i <= V ; i++) {
//			for(int ii = 1 ; ii <= V ; ii++) {
//				if(arr[i][ii] == 0 || arr[i][ii] == Integer.MAX_VALUE) {
//					System.out.print(0 + " ");
//				}
//				else {
//					System.out.print(1 + " ");
//				}
//			}
//			System.out.println();
//		}
		
		for(int i = 1 ; i <= V ; i++) {
			int a = 0;
			for(int ii = 1 ; ii <= V ; ii++) {
				if(i != ii && arr[i][ii] == Integer.MAX_VALUE && arr[ii][i] == Integer.MAX_VALUE ){
					a++;
				}
			}
			sb.append(a).append("\n");
		}
		
		System.out.println(sb);

	}
	

	
}

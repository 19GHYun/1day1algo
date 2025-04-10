import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[V+1][V+1];
		
		for(int i = 1 ; i <= V ; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
			arr[i][i] = 0;
		}
		
		for(int i = 1 ; i <= E ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			arr[a1][a2] = 1;

		}
		
		for(int i = 1 ; i <= V ; i++) {
			for(int ii = 1 ; ii <= V ; ii++) {
				for(int iii = 1 ; iii <= V ; iii++) {
					if(arr[ii][i] != Integer.MAX_VALUE && arr[i][iii] != Integer.MAX_VALUE){
						arr[ii][iii] = Math.min(arr[ii][iii], arr[ii][i] + arr[i][iii]);
					}
					
				}
			}
		}
		//a1 a2 가 주어질때
		//arr[a1][a2] arr[a2][a1] 둘다 21억이면 0
		// 둘중 하나인데 그게 arr[a1][a2] 면 -1
		//  그게 arr[a2][a1] 이면 1
//		for(int i = 1 ; i <= V ; i++) {
//			for(int ii = 1 ; ii <= V ; ii++) {
//				System.out.print(arr[i][ii] + "  ");
//			}
//			System.out.println();
//		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a3 = Integer.parseInt(st.nextToken());
			int a4 = Integer.parseInt(st.nextToken());
			
			if(arr[a3][a4] != Integer.MAX_VALUE && arr[a3][a4] > 0) {
				sb.append(-1).append("\n");
			}
			else if(arr[a4][a3] != Integer.MAX_VALUE &&arr[a4][a3] > 0) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
			
		}
		
		System.out.println(sb);
		
		
	}
	

	
}

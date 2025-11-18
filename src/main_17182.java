import java.io.*;
import java.util.*;

public class Main {
	public static int V, start;
	public static int[][] arr;
	public static int answer = Integer.MAX_VALUE;
	public static List<Integer> list = new ArrayList<Integer>();
	public static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		V = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		arr = new int[V][V];
		check = new boolean[V];
		
		for(int i = 0 ; i < V ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int ii = 0 ; ii < V ; ii++) {
				arr[i][ii] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < V ; i ++) {
			for(int ii = 0 ; ii < V ; ii++) {
				for(int iii = 0 ; iii < V ; iii++) {
					arr[ii][iii] = Math.min(arr[ii][iii], arr[ii][i] + arr[i][iii]);
				}
			}
		}
		
		backt(0);
		
		System.out.println(answer);
		
//		for(int i = 0 ; i < V ; i++) {
//			for(int ii = 0 ; ii < V ; ii++) {
//				System.out.print(arr[i][ii] + " ");
//			}
//			System.out.println();
//		}
		
	}
	
	public static void backt(int cnt) {
		if(cnt == V - 1) {
			int local_answer = 0;
			int a = start;
			int before_a = 0;
			
			for(int b : list) {
				local_answer += arr[a][b];
				a = b;
				
			}
			
			answer = Math.min(answer, local_answer);
		}
		for(int i = 0 ; i < V ; i++) {
			if(i == start) {
				continue;
			}
			if(!check[i]) {
				check[i] = true;
				list.add(i);
				backt(cnt + 1);
				check[i] = false;
				list.remove(list.size()-1);
			}
			
		}
		
	}
	

	
}

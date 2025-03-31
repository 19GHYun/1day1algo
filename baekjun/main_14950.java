import java.util.*;
import java.io.*;

class land implements Comparable<land>{
	int left;
	int right;
	int weight;
	
	public land(int left, int right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}
	
	public int compareTo(land land) {
		return Integer.compare(this.weight, land.weight);
	}
	
}
public class Main {

	public static int N, M, T;
	public static int[] parent;
	
	public static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);
		
		if(rootx != rooty) {
			parent[rooty] = rootx;
		}
		
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		int extra_add = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			parent[i] = i;
			
			if(i - 2 < 0) {
				
			}else {
				extra_add += i-2;
			}
		}
		
		PriorityQueue<land> que = new PriorityQueue<>();
		

		
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			
			que.add(new land(a1,a2,a3));
			

		}
		
		int total_l = 0;
		int ans = 0;
		
		while(!que.isEmpty() && total_l < N-1) {
			land where = que.poll();
			
			int LE = where.left;
			int RI = where.right;
			int WE = where.weight;
			
			if(find(LE) != find(RI)) {
				union(LE, RI);
				total_l++;
				ans += WE;
				
			}
			
			
		}
		
		System.out.println(ans + extra_add * T);
		
		
		
	}	

}

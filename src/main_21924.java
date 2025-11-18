import java.util.*;
import java.io.*;

class Apt implements Comparable<Apt>{
	int left;
	int right;
	int weight;
	
	public Apt(int left, int right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}
	
	public int compareTo(Apt apt) {
		return Integer.compare(this.weight, apt.weight);
	}
}

public class Main {
	public static int N, M;
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

		long total_m = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Apt> que = new PriorityQueue<>();
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			
			total_m += a3;
			
			que.add(new Apt(a1,a2,a3));
			
		}
		
		int total_apt = 0;
		long ans = 0;
		
		while(!que.isEmpty() && total_apt < N - 1) {
			Apt where = que.poll();
			
			int LE = where.left;
			int RI = where.right;
			int WE = where.weight;
			
			if(find(LE) != find(RI)) {
				union(LE,RI);
				ans += WE;
				total_apt ++;
			}
			
			
		}
		
		if(total_apt == N - 1) {
			System.out.println(total_m - ans);
		}else {
			System.out.println(-1);
		}
		
		
		
	}
	

}

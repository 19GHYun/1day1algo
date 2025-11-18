import java.util.*;
import java.io.*;

class graph{
	int v;
	List<List<Node>> arr;
	
	class Node implements Comparable<Node>{
		int dest;
		int weight;
		
		Node(int dest, int weight){
			this.dest = dest;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
		}
		
	}
	
	public graph(int v) {
		this.v = v;
		arr = new ArrayList<>(v+1);
		for(int i = 0 ; i <= v ; i++) {
			arr.add(new ArrayList<>());
			
		}
	}
	
	public void add_graph(int start, int end, int weight) {
		arr.get(end).add(new Node(start, weight));
	}
	
	public int[] stra(int start) {
		int[] length = new int[v+1];
		boolean[] check = new boolean[v+1];
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		Arrays.fill(length, Integer.MAX_VALUE);
		length[start] = 0;
		que.add(new Node(start, 0));
		
		while(!que.isEmpty()) {
			Node where = que.poll();
			int now = where.dest;
			
			if(check[now]) continue;
			check[now] = false;
			
			for(Node neighbor : arr.get(now)) {
				int end = neighbor.dest;
				int weight = neighbor.weight;
				
				if(!check[end] && length[now] != Integer.MAX_VALUE && length[now] + weight < length[end]) {
					length[end] = length[now] + weight;
					que.add(new Node(end, length[end]));
					
				}
				
				
			}
			
			
		}
		
		
		
		return length;
	}
	
	
}

public class Main {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= T ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph graph = new graph(N);
			
			for(int ii = 0 ; ii < D ; ii++) {
				st = new StringTokenizer(br.readLine());
				
				int a1 = Integer.parseInt(st.nextToken());
				int a2 = Integer.parseInt(st.nextToken());
				int a3 = Integer.parseInt(st.nextToken());
				
				graph.add_graph(a1, a2, a3);
			}
			
			int total_c = 0;
			int total_time = 0;
			
			int[] ans = graph.stra(C);
			
			for(int ii = 1 ; ii <= N ; ii++) {
				if(ans[ii] == Integer.MAX_VALUE) {
					continue;
				}
				else {
					total_c++;
					total_time = Math.max(total_time, ans[ii]);
				}
			}
			
			System.out.println(total_c + " " + total_time);
		}
		
	}

}

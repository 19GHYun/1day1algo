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
		arr.get(start).add(new Node(end, weight));
	}
	
	public int[] stra(int start) {
		int[] length = new int[v+1];
		boolean[] checked = new boolean[v+1];
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		Arrays.fill(length, Integer.MAX_VALUE);
		length[start] = 0;
		que.add(new Node(start, 0));
		
		while(!que.isEmpty()) {
			Node where = que.poll();
			int now = where.dest;
			
			if(checked[now]) continue;
			checked[now] = true;
			
			for(Node neighbor : arr.get(now)) {
				int end = neighbor.dest;
				int weight = neighbor.weight;
				
				if(!checked[end] && length[now] != Integer.MAX_VALUE && length[now] + weight < length[end]) {
					length[end] = length[now] + weight;
					que.add(new Node(end, length[end]));
					
				}
				
				
			}
			
			
		}
		
		
		return length;
	}
	
}

public class Main {
	public static int V,E,X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()); // 목적지
		
		graph graph = new graph(V);
		int[][] ans = new int[V+1][V+1];
		
		int final_ans = 0;
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			
			graph.add_graph(a1, a2, a3);

		}
		
		for(int i = 1 ; i <= V ; i++) {
			ans[i] = graph.stra(i);
			
		}
				
		for(int i = 1 ; i <= V ; i++) {
			if(i == X) continue;
			int local_answer = 0;
			local_answer += ans[i][X];
			local_answer += ans[X][i];
			
			final_ans = Math.max(final_ans, local_answer);
		}

		
		System.out.println(final_ans);
	}	

}

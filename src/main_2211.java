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
	
	graph(int v){
		this.v = v;
		arr = new ArrayList<>(v + 1);
		
		for(int i = 0 ; i <= v ; i++) {
			arr.add(new ArrayList<>());
		}
	}
	
	
	void add_graph(int start, int end, int weight) {
		arr.get(start).add(new Node(end, weight));
		arr.get(end).add(new Node(start, weight));
	}
	
	public int[] stra(int start){
		int[] list = new int[v+1];
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
			check[now] = true;
			
			for(Node neighbor : arr.get(now)) {
				int end = neighbor.dest;
				int weight = neighbor.weight;
				
				if(!check[end] && length[now] != Integer.MAX_VALUE && length[now] + weight < length[end]) {
					list[end] = now;
					length[end] = length[now] + weight;
					que.add(new Node(end, length[end]));
				}
				
				
			}
			
		}
		
		return list;
	}
	
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph graph = new graph(N);
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			
			graph.add_graph(a1, a2, a3);
			
		}
		
		int[] ans = graph.stra(1);
		
		int total_size = 0;
		for(int i = 2 ; i <= N ; i++) {
			if(ans[i] != 0) {
				total_size++;
				sb.append(i + " " + ans[i]);
			}
			sb.append("\n");
		}
		System.out.println(total_size);
		System.out.println(sb);
		
	}

}

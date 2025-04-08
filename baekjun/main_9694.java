import java.io.*;
import java.util.*;

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
	
	public int[] stra(int start, int[] prev) {
		int[] length = new int[v+1];
		boolean[] check = new boolean[v+1];
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		Arrays.fill(length, Integer.MAX_VALUE);
		length[0] = 0;
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
					prev[end] = now;
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
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= T ; i++) {
			sb.setLength(0);
			st = new StringTokenizer(br.readLine());
			
			int E = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			graph graph = new graph(V);
			
			for(int ii = 0 ; ii < E ; ii++) {
				st = new StringTokenizer(br.readLine());
				
				int a1 = Integer.parseInt(st.nextToken());
				int a2 = Integer.parseInt(st.nextToken());
				int a3 = Integer.parseInt(st.nextToken());
				
				graph.add_graph(a1, a2, a3);
				
			}
			int[] prev = new int[V+1];
			int[] ans = graph.stra(0, prev);
			Stack<Integer> stack = new Stack<>();
			if(ans[V-1] == Integer.MAX_VALUE){
				sb.append("-1").append("\n");
			}
			else {
				int current = V-1;
				while(current != 0) {
					stack.push(current);
					current = prev[current];
				}
				stack.push(0);
				
				
				while(!stack.isEmpty()) {
					sb.append(stack.pop()).append(" ");
				}
				sb.append("\n");
			}
			
			
			System.out.println("Case #" + i + ": " + sb );
		}
		


	}
	

	
}

import java.io.*;
import java.util.*;

class graph{
	int v;
	List<List<Node>> arr;
	
	class Node implements Comparable<Node>{
		int dest;
		long weight;
		
		Node(int dest, long length){
			this.dest = dest;
			this.weight = length;
		}
		
		@Override
		public int compareTo(Node node) {
			return Long.compare(this.weight, node.weight);
		}
	}
	
	graph(int v){
		this.v = v;
		
		arr = new ArrayList<>(v+1);
		
		for(int i = 0 ; i <= v ; i++) {
			arr.add(new ArrayList<>());
		}
		
	}
	
	void add_graph(int start, int end, int weight){
		arr.get(start).add(new Node(end, weight));
		arr.get(end).add(new Node(start, weight));
	}
	
	public long[] stra(int start) {
		long[] length = new long[v+1];
		boolean[] check = new boolean[v+1];
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		Arrays.fill(length, Long.MAX_VALUE);
		length[start] = 0;
		que.add(new Node(start, 0));
		
		while(!que.isEmpty()) {
			Node where =que.poll();
			int now = where.dest;
			
			if(check[now]) continue;
			check[now] = true;
			
			for(Node neighbor : arr.get(now)) {
				int end = neighbor.dest;
				long weight = neighbor.weight;
				
				if(!check[end] && length[now] != Long.MAX_VALUE && length[now] + weight < length[end]) {
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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < V ; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				set.add(i);
			}
			
		}
		
		set.remove(V - 1);
		
		graph graph = new graph(V);
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			
			if(set.contains(a1) || set.contains(a2)) {
				continue;
			}else {
				graph.add_graph(a1, a2, a3);
			}
			
	
			
		}
		
		long[] ans = graph.stra(0);
		
		if(ans[V-1] == Long.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans[V-1]);
		}
		

	}

}

import java.util.*;
import java.io.*;

class graph{
	public int v;
	public List<List<Node>> arr;
	
	class Node implements Comparable<Node>{
		public int dest;
		public int weight;
		
		public Node (int dest, int weight) {
			this.dest= dest;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
		}
		
	}
	
	public graph(int v) {
		this.v = v;
		arr = new ArrayList<>(v + 1);
		
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
			int now = where.dest; // 출발
			
			if(checked[now]) continue;
			checked[now] = true;
			
			for(Node neighbor : arr.get(now)) {
				int go = neighbor.dest;
				int weight = neighbor.weight;
				
				if(!checked[go] && length[now] != Integer.MAX_VALUE && length[now] + weight < length[go]) {
					length[go] = length[now] + weight;
					que.add(new Node(go, length[go]));
				}
				
				
			}

		}

		return length;
	}
	
	
}

public class Main {
	public static int V,E,ST,ED;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		graph graph = new graph(V);
		int[] ans = new int[V+1];
		
		for(int i = 0 ; i < E ; i++) {
			 st = new StringTokenizer(br.readLine());
			 
			 int a1 = Integer.parseInt(st.nextToken());
			 int a2 = Integer.parseInt(st.nextToken());
			 int a3 = Integer.parseInt(st.nextToken());
			 
			 graph.add_graph(a1, a2, a3);
		}
		
		st = new StringTokenizer(br.readLine());
		
		ST = Integer.parseInt(st.nextToken());
		ED = Integer.parseInt(st.nextToken());

		ans = graph.stra(ST);
		
		System.out.println(ans[ED]);
		
	}	

}






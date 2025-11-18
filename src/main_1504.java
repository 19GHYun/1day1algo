import java.util.*;
import java.io.*;

class graph{
	int v;
	List<List<Node>> arr;
	
	class Node implements  Comparable<Node>{
		int dest;
		int weight;
		
		Node(int dest, int weight){
			this.dest = dest;
			this.weight =weight;
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
		arr.get(end).add(new Node(start, weight));
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
	public static int V,E,ST,ED;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph graph = new graph(V);
		
		int[] ans1 = new int[V+1];
		int[] ans2 = new int[V+1];
		int[] ans3 = new int[V+1];
		
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

		
		long answer = Integer.MAX_VALUE;
		
		ans1 = graph.stra(1);
		ans2 = graph.stra(ST);
		ans3 = graph.stra(ED);
		
		long local_answer1 = 0;
		long local_answer2 = 0;
		
		local_answer1 += (long)ans1[ST] + (long)ans2[ED] + (long)ans3[V];
		local_answer2 += (long)ans1[ED] + (long)ans3[ST] + (long)ans2[V];
		
		if(local_answer1 >= Integer.MAX_VALUE && local_answer2 >= Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		answer = Math.min(answer, local_answer2);
		answer = Math.min(answer, local_answer1);
		
		
		System.out.println(answer);

	}

}

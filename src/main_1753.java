import java.util.*;
import java.io.*;

class graph{
	public int v;
	public List<List<Node>> arr;
	
	class Node implements Comparable<Node>{
		public int dest;
		public int weight;
		
		public Node(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
		}
		
	}
	
	public graph(int v) {
		this.v = v;
		
		arr = new ArrayList<>(v);
		for(int i = 0 ; i < v + 1 ; i++) { // 여기 v+1 해야함.
			arr.add(new ArrayList<>());
		}
	}
	
	public void add_graph(int start, int end, int weight) {
		arr.get(start).add(new Node(end, weight));
		
	}
	
	public int[] dijkstra(int start) {
		int[] length = new int[v + 1];
		boolean[] checked = new boolean[v + 1];
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		Arrays.fill(length, Integer.MAX_VALUE);
		length[start] = 0;
		que.add(new Node(start, length[start]));
		
		while(!que.isEmpty()) {
			Node where = que.poll();
			int u = where.dest;
			//뽑고 시작지점을 가져옴
			
			if(checked[u]) continue; // 뽑은거면 안됨. 최단거리가 아니니까
			checked[u] = true;
			
			// 
			for(Node neighbor : arr.get(u)) {
				int v = neighbor.dest; // 이동할 곳
				int weight = neighbor.weight; //이동할 곳의 가중치
				
				//이동 할 곳을 안갔고, 내가 지금 있는곳이 초기화된 값이 아니며, 현재위치 + 가중치가 이동할 곳에 잇는거보다 작으면
				if(!checked[v] && length[u] != Integer.MAX_VALUE && length[u] + weight < length[v]) {
					length[v] = length[u] + weight;
					// 길이 최신화.
					que.add(new Node(v, length[v]));
					// 그리고 이동한 곳의 큐랑 거기까지 웨이트 최신화.
				}
				
			}
			
		}
		
		return length;
		
	}
	
}

public class Main {
	public static int V,E,K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		graph graph = new graph(V);
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			
			graph.add_graph(a1, a2, a3);
		}
		
		int[] ans = new int[V + 1];
		ans = graph.dijkstra(K);

		for(int i = 1 ; i <= V ; i++) {
			if(ans[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			}
			else {
				sb.append(ans[i]).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}	

}

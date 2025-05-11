import java.io.*;
import java.util.*;

class graph{
	int n;
	List<List<Node>> arr;
	
	class Node implements Comparable<Node>{
		int dest;
		int weight;		
		
		Node(int dest, int weight){
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Node node) {
			return Integer.compare(this.weight,  node.weight);
		}
	}
	
	graph(int n){
		this.n = n;
		arr = new ArrayList<>(n + 1);
		for(int i = 0 ; i <= n ; i++) {
			arr.add(new ArrayList<>()); 
		}
	}
	
	void add_graph(int start, int end, int weight) {
		arr.get(start).add(new Node(end, weight));
		arr.get(end).add(new Node(start, weight));
	}
	
	public int[] stra(int start) {
		int[] length = new int[n+1];
		boolean[] check = new boolean[n+1];
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
				
				if(!check[end] && length[now] != Integer.MAX_VALUE && length[end] > length[now] + weight) {
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
		
		for(int i = 0 ; i < T ; i++){
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph graph = new graph(N);
			
			for(int ii = 0 ; ii < M ; ii++) {
				st = new StringTokenizer(br.readLine());
				
				int a1 = Integer.parseInt(st.nextToken());
				int a2 = Integer.parseInt(st.nextToken());
				int a3 = Integer.parseInt(st.nextToken());
				
				graph.add_graph(a1, a2, a3);
			}
			
			int small_length = Integer.MAX_VALUE;
			int who_start = 0;
			
			int[][] total_length = new int[N + 1][N + 1];
			
			int K = Integer.parseInt(br.readLine());
			
			int[] now = new int[K+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int ii = 1 ; ii <= K ; ii++) {
				now[ii] = Integer.parseInt(st.nextToken());
			}
			
			for(int ii = 1 ; ii <= N ; ii++) {
				total_length[ii] = graph.stra(ii);
//				for(int iii = 1 ; iii <= N ; iii++) {
//					System.out.print(total_length[ii][iii] + " ");
//				}
//				System.out.println();
			}
			for(int ii = 1 ; ii <= N ; ii++) {
				int length = 0;
				for(int iii = 1 ; iii <= K ; iii++) {
					length += total_length[ii][now[iii]];
				}
				if(length < small_length) {
					small_length = length;
					who_start = ii;
				}
			}
			
			System.out.println(who_start);
			
		}


	}


}

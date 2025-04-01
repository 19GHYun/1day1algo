import java.util.*;
import java.io.*;


class graph{
	int v;
	List<List<Node>> arr;
	
	class Node implements Comparable<Node>{
		int dest;
		long weight;
		
		Node(int dest, long weight){
			this.dest = dest;
			this.weight = weight;
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
	
	public void add_graph(int start, int end, int weight){
		arr.get(start).add(new Node(end, weight));
		
	}
	
    public List<PriorityQueue<Long>> stra(int start, int k) {
        List<PriorityQueue<Long>> paths = new ArrayList<>(v + 1);
        for (int i = 0; i <= v; i++) {
            paths.add(new PriorityQueue<>(Collections.reverseOrder()));
        }
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));

        while (!que.isEmpty()) {
            Node current = que.poll();
            int now = current.dest;
            long weight = current.weight;

            PriorityQueue<Long> currentlength = paths.get(now);
            if (currentlength.size() < k) {
                currentlength.add(weight);
                for (Node neighbor : arr.get(now)) {
                    int end = neighbor.dest;
                    long nextWeight = weight + neighbor.weight;
                    que.add(new Node(end, nextWeight));
                }
            }
        }
        return paths;
    }
	
}


public class Main {
	public static int N, M, K;
	public static int[] parent;
		
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        graph graph = new graph(N);
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	int a3 = Integer.parseInt(st.nextToken());
        
        	graph.add_graph(a1, a2, a3);
        }
        
        List<PriorityQueue<Long>> ans = graph.stra(1, K);
        

        for (int i = 1; i <= N; i++) {
            if (ans.get(i).size() < K) {
                System.out.println(-1);
            } else {
                System.out.println(ans.get(i).peek());
            }
        }
        
	}

}

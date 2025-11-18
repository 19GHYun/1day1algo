import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
	int left;
	int right;
	int weight;
	
	public Node(int left, int right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}
	
	public int compareTo(Node node) { // To임
		return Integer.compare(weight, node.weight);
	}
	
}
public class Main {
	public static int N,M;
	public static int[] parent;
	
	public static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);
		
		if(rootx != rooty) {
			parent[rooty] = rootx;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        
        for(int i = 1 ; i <= N ; i++) {
        	parent[i] = i;
        }
        
        PriorityQueue<Node> que = new PriorityQueue<>();
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	int a3 = Integer.parseInt(st.nextToken());
        	
        	que.add(new Node(a1,a2,a3));
        	
        	
        }
        
        int result = 0;
        int total_v = 0;
        
        while(!que.isEmpty() && total_v < N - 2) {
        	Node where = que.poll();
        	
        	int LE = where.left;
        	int RI = where.right;
        	int weight = where.weight;
        	
        	if(find(LE) != find(RI)) {
        		result += weight;
        		total_v++;
        		union(LE,RI);
        	}
        }
        
        System.out.println(result);
	}

}

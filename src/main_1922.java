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
	
	@Override
	public int compareTo(Node node) {
		return Integer.compare(this.weight, node.weight);
	}
}

public class Main {
	public static int V, E;
	public static int[] parent;
	
	public static int find(int x) {
		if(x == parent[x]) {
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
        StringTokenizer st;
        
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        
        parent = new int[V+1];
        
        for(int i = 1 ; i <= V ; i++) {
        	parent[i] = i;
        }
        
        PriorityQueue<Node> que = new PriorityQueue<>();
        
        for(int i = 0 ; i < E ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	int a3 = Integer.parseInt(st.nextToken());
        	
        	que.add(new Node(a1,a2,a3));
        	
        }
        
        int total_v = 0;
        int ans = 0;
        
        while(!que.isEmpty() && total_v < V - 1) {
        	Node where = que.poll();
        	
        	if(find(where.left) != find(where.right)) {
        		union(where.left, where.right);
        		ans += where.weight;
        		total_v++;
        	}
        }
        
        System.out.println(ans);
        
    }

}

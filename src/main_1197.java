import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int left;
	int right;
	int weight;
	Node(int left, int right, int weight){
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
    public static int V,E;
    public static int[] parent;
    
    public static int find(int x) {
    	if(parent[x] == x) return x;
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

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        Node[] node = new Node[V+1];
        parent = new int[V+1];
        for(int i = 1 ; i <= V ; i++) {
        	parent[i] = i;
        }
        
        PriorityQueue<Node> que = new PriorityQueue<>();
        
        for (int i = 0; i < E; i++) { 
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int a3 = Integer.parseInt(st.nextToken());
            
            que.add(new Node(a1, a2, a3));
        }
        
        long answer = 0;
        int edgenode = 0;
        
        while(!que.isEmpty() && edgenode < V - 1) {
        	Node where = que.poll();
        	int u = where.left;
        	int v = where.right;
        	int weight = where.weight;
        	
        	if(find(u) != find(v)) {
        		union(u,v);
        		answer += weight;
        		edgenode++;
        	}
        	
        }
        System.out.println(answer);
        

    }
    
}

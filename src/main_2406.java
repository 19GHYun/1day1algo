import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int left;
	int right;
	int weight;
	
	Node(int x, int y, int z){
		this.left = x;
		this.right= y;
		this.weight = z;
	}
	
	public int compareTo(Node node) {
		return Integer.compare(this.weight, node.weight);
	}
	
}


public class Main {
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
			parent[rootx] = rooty;
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        
        PriorityQueue<Node> pque = new PriorityQueue<>();
        
        for(int i = 1 ; i < N + 1 ; i++) {
        	parent[i] = i;
        }
        
        int total_n = 0;
        int ans = 0;
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	
        	if(find(a1) != find(a2)) {
        		union(a1, a2);
        	}
        	
        }

        for(int i = 1 ; i <= N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int ii = 1 ; ii <= N ; ii++) {
        		int a1 = Integer.parseInt(st.nextToken());
        		
        		if(i == ii) {
        			continue;
        		}
        		
        		pque.add(new Node(i,ii,a1));
        		
        	}
        }
        

        
        while(!pque.isEmpty() && total_n < N - 1) {
        	Node where = pque.poll();
        	
        	int LE = where.left;
        	int RI = where.right;
        	int WE = where.weight;
        	
        	if(LE == 1 || RI == 1) {
        		continue;
        	}
        	
        	if(find(LE) != find(RI)) {
        		union(LE, RI);
        		total_n++;
        		ans += WE;
        		sb.append(RI + " " + LE).append("\n");
        	}
        	
        }
        
        System.out.println(ans + " " + total_n);
        System.out.println(sb);

        
    }

}


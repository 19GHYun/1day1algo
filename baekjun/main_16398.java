import java.util.*;
import java.io.*;

class Planet implements Comparable<Planet>{
	int left;
	int right;
	int weight;
	
	public Planet(int left, int right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}
	
	public int compareTo(Planet planet) {
		return Integer.compare(this.weight, planet.weight);
	}
	
}

public class Main {
	public static int N;
	public static int[] parent;
	
	public static int find(int x) {
		if(parent[x]  == x) {
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
        
        N = Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        
        PriorityQueue<Planet> que = new PriorityQueue<>();
        
        for(int i = 1 ; i <= N ; i++) {
        	parent[i] = i;
        }

        
        for(int i = 1 ; i <= N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int ii = 1 ; ii <= N ; ii++) {
        		int a = Integer.parseInt(st.nextToken());
        		if(i == ii) {
        			
        		}
        		else {
        			que.add(new Planet(i, ii, a));
        		}
        		
        	}
        }
        
        int total_p = 0;
        long ans = 0;
        
        while(!que.isEmpty() && total_p < N - 1) {
        	Planet where = que.poll();
        	
        	int LE = where.left;
        	int RI = where.right;
        	int WE = where.weight;
        	
        	if(find(LE) != find(RI)) {
        		union(LE,RI);
        		total_p++;
        		ans += WE;
        	}
        	
        }
        System.out.println(ans);
        

	}

}

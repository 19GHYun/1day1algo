import java.util.*;
import java.io.*;

class Star implements Comparable<Star>{
	int node1;
	int node2;
	Double length;
	
	Star(int node1, int node2, double length){
		this.node1 = node1;
		this.node2 = node2;
		this.length = length;
	}
	
	public int compareTo(Star star) {
		return Double.compare(this.length, star.length);
	}
}

public class Main {
	public static int N;
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
        
        N = Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        
        for(int i = 1 ; i <= N ; i++) {
        	parent[i] = i;
        }
        
        PriorityQueue<Star> que = new PriorityQueue<>();
        
        int start = 1;
        int end = 2;
        
        double[] x = new double[N + 1];
        double[] y = new double[N + 1];

        for(int i = 1 ; i <= N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	double a1 = Double.parseDouble(st.nextToken());
        	double a2 = Double.parseDouble(st.nextToken());
        	
        	x[i] = a1;
        	y[i] = a2;
        	
        }
        
        for(int i = 0 ; i < (N * (N-1)) / 2 ; i++) {

        	double a3 = Math.sqrt(Math.pow(x[start] - x[end], 2) + Math.pow(y[start] - y[end], 2));
        	
        	que.add(new Star(start,end,a3));
        	end++;

        	if(end > N) {
        		start++;
        		end = start + 1;
        	}

        	
        }
        

        
        double ans = 0;
        int total_star = 0;
        
        while(!que.isEmpty() && total_star < N - 1) {
        	Star where = que.poll();
        	int sx = where.node1;
        	int sy = where.node2;
        	double len = where.length;
        	
        	if(find(sx) != find(sy)) {
        		ans += len;
        		total_star++;
        		union(sx,sy);
        	}
        	
        }
        
        System.out.printf("%.2f%n", ans);
        

	}

}

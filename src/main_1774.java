import java.util.*;
import java.io.*;

class Space implements Comparable<Space>{
	
	int left;
	int right;
	double weight;
	
	public Space(int left, int right, double weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Space space) {
		return Double.compare(this.weight, space.weight);
	}
	
}


public class Main {
	public static int N, M;
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
        
        PriorityQueue<Space> que = new PriorityQueue<>();
        
        int[] x = new int[N+1];
        int[] y = new int[N+1];
        
        int start = 1;
        int end=  2;
        
        for(int i = 1 ; i <= N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	
        	x[i] = a1;
        	y[i] = a2;
        	
        }
        
        int total_space = 0;
        double ans = 0;
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a3 = Integer.parseInt(st.nextToken());
        	int a4 = Integer.parseInt(st.nextToken());
            if(find(a3) != find(a4)) {  // 서로 다른 집합일 때만 합침
                union(a3, a4);
                total_space++;
            }
        }
        
        for(int i = 0 ; i < (N * (N-1)) / 2 ; i++) {
        	
        	double a3 = Math.sqrt(Math.pow(x[start] - x[end], 2) + Math.pow(y[start] - y[end], 2));
        	
        	que.add(new Space(start,end,a3));
        	
        	end++;
        	if(end > N) {
        		start++;
        		end = start + 1;
        	}
        }
        
        while(!que.isEmpty() && total_space < N - 1) {
        	
        	Space where = que.poll();
        	
        	int LE = where.left;
        	int RI = where.right;
        	double WE = where.weight;
        	
        	if(find(LE) != find(RI)) {
        		union(LE, RI);
        		total_space++;
        		ans += WE;
        	}
        	
        	
        	
        }
        System.out.println(String.format("%.2f",Math.round(ans * 100.0) / 100.0));
        
	}

}

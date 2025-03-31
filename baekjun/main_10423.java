import java.util.*;
import java.io.*;

class Baljeon implements Comparable<Baljeon>{
	int left;
	int right;
	int weight;
	
	public Baljeon(int left, int right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}
	
	public int compareTo(Baljeon baljeon) {
		return Integer.compare(this.weight, baljeon.weight);
	}
	
}

public class Main {
	public static int N, M, K;
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
        K = Integer.parseInt(st.nextToken());
        
        parent = new int[N+1];
        int[] self_baljeon = new int[K + 1];
        
        for(int i = 1 ; i <= N ; i++) {
        	parent[i] = i;
        }
        
        PriorityQueue<Baljeon> que = new PriorityQueue<>();
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1 ; i <= K ; i++) {
        	int a1 = Integer.parseInt(st.nextToken());
        	
        	self_baljeon[i] = a1;
        	
        }
        
        int total_baljeon = 0;
        int ans = 0;
        
        for(int i = 1 ; i < K ; i++) {
        	if(find(self_baljeon[i]) != find(self_baljeon[i+1])) {
        		union(self_baljeon[i], self_baljeon[i+1]);
        		total_baljeon++;
        	}
        }
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	int a3 = Integer.parseInt(st.nextToken());
        	
        	que.add(new Baljeon(a1,a2,a3));
        	
        }

        while(!que.isEmpty() && total_baljeon < N - 1) {
        	Baljeon where = que.poll();
        	
        	int LE = where.left;
        	int RI = where.right;
        	int WE = where.weight;
        	
        	if(find(LE) != find(RI)) {
        		union(LE,RI);
        		total_baljeon++;
        		ans += WE;
        	}
        	
        	
        }
        
        System.out.println(ans);



        
	}

}

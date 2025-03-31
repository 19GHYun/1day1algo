import java.util.*;
import java.io.*;

class Univers implements Comparable<Univers>{
	int left;
	int right;
	int weight;
	
	public Univers(int left, int right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}
	
	public int compareTo(Univers univers) {
		return Integer.compare(this.weight, univers.weight);
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
        char[] sex = new char[N+1];
        
        String a = br.readLine();
        
        for(int i = 1 ; i <= N ; i++) {
        	parent[i] =i;
        	sex[i] = a.charAt(i* 2 -2);
        }
        
        PriorityQueue<Univers> que = new PriorityQueue<>();
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	int a3 = Integer.parseInt(st.nextToken());
        	
        	if(sex[a1] == sex[a2]) {
        		continue;
        	}else {
        		que.add(new Univers(a1,a2,a3));
        		
        	}
        	
        	
        }
        
        int total_u = 0;
        int ans = 0;
        
        while(!que.isEmpty() && total_u < N - 1) {
        	Univers where = que.poll();
        	
        	int LE = where.left;
        	int RI = where.right;
        	int WE = where.weight;
        	
        	if(find(LE) != find(RI)) {
        		union(LE,RI);
        		total_u++;
        		ans += WE;
        	}
        	
        }
        
        if(total_u == N - 1) {
            System.out.println(ans);
        }else {
        	System.out.println(-1);
        }


        
	}

}

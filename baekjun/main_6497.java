import java.util.*;
import java.io.*;

class House implements Comparable<House>{
	
	int left;
	int right;
	int weight;
	
	public House(int left, int right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}
	
	public int compareTo(House house) {
		return Integer.compare(this.weight, house.weight);
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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
        	
            int total_money = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
        	if(N == 0 && M == 0) {
        		break;
        	}
        	
            parent = new int[N];
            
            for(int i = 0 ; i < N ; i++) {
            	parent[i] = i;
            }
            
            
            PriorityQueue<House> que = new PriorityQueue<>();
        	
            
            
            for(int i = 0 ; i < M ; i++) {
            	st = new StringTokenizer(br.readLine());
            	
            	int a1 = Integer.parseInt(st.nextToken());
            	int a2 = Integer.parseInt(st.nextToken());
            	int a3 = Integer.parseInt(st.nextToken());
            	
            	total_money += a3;
            	
            	que.add(new House(a1,a2,a3));

            	
            }
            
            int result_house = 0;
            int ans = 0;
            
            while(!que.isEmpty() && result_house < N-1) {
            	House where = que.poll();
            	
            	int LE = where.left;
            	int RI = where.right;
            	int we = where.weight;
            	
            	if(find(LE) != find(RI)) {
            		union(LE, RI);
            		ans += we;
            		result_house++;
            	}
            	
            }
            sb.append(total_money - ans).append("\n");
            
            
        }
        
        System.out.println(sb);

        
	}

}

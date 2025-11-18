import java.io.*;
import java.util.*;
 
    public class Main {
    	public static int N,M;
    	public static boolean end = false;


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            bfs(N);
            
            
        }   
        
        
        public static void bfs(int start) {
        	
        	Queue<int[]> que = new ArrayDeque<>();
        	boolean[] visited = new boolean[100001];
        	
        	que.add(new int[] {start, 0});
        	visited[start] = true;
        	
        	while(!que.isEmpty()) {
        		int[] where = que.poll();
        		int new_start = where[0];
        		int count = where[1];
        		if( new_start == M) {
        			System.out.println(count);
        			return;
        		}
        		
        		int[] new_move = {new_start - 1, new_start + 1, new_start * 2};
        		for(int next : new_move) {
        			if(next >= 0 && next<= 100000 && !visited[next]) {
        				visited[next] = true;
        				que.add(new int[] {next, count+1});
        			}
        		}
        		
        	}

        	
        }
        
        
}

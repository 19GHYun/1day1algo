import java.util.*;
import java.io.*;

public class Main {

	    public static int N, M;
	    public static int[][] arr;
	    public static boolean[][] check;
	    public static int cnt = 0;
	    public static int[] dx = {-1, 1, 0, 0};
	    public static int[] dy = {0, 0, 1, -1};
	    static Queue<int[]> q = new LinkedList<>();
	    public static void main(String[] args) throws IOException {
	    	
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    
	    int[] yeol = new int[M+1];
	    String a;
	    
	    arr = new int[N+1][M+1];
	    check = new boolean[N+1][M+1];
	    
	    for(int i = 1 ; i < N + 1 ; i++) {
	    	a = br.readLine();
	    	for(int j = 0 ; j < a.length() ; j++) {
	    		switch(a.charAt((j))) {
	    			case('0'):
	    				yeol[j+1] = 0;
	    				break;
	    			case('1'):
	    				yeol[j+1] = 1;
	    				break;
	    		}
	    	}
	    	
	    	for(int j = 1 ; j < M + 1 ; j++) {
	    		arr[i][j] = yeol[j];
	    	}
	    }
	    
	    bfs(1,1);
	    
	    System.out.print(arr[N][M]);
	    
	   	
//	    for(int i = 1 ; i < N+1 ; i++) {
//	    	for(int j = 1 ; j < M + 1 ; j++) {
//	    		System.out.print(miro[i][j]);
//	    	}
//	    	System.out.println();
//	    }
//	    
	
	    
    
	}
	    public static void bfs(int start_x, int start_y) {
	    	check[1][1] = true;
	    	q.add(new int[] {start_x, start_y});
	    	
	    	
	    	while(!q.isEmpty()) {
	    		int[] where = q.poll();
	    		
	    		start_x = where[0];
	    		start_y = where[1];
	    		
	    		for(int i = 0 ; i < 4 ; i++) {
	    			int new_x = start_x + dx[i];
	    			int new_y = start_y + dy[i];
	    			
	    			if(new_x  == 0 || new_y == 0 || new_x == N + 1 || new_y == M + 1) {
	    				continue;
	    			}
	    			if(arr[new_x][new_y] >= 1 && !check[new_x][new_y]) {
	    				q.add(new int[] {new_x, new_y});
	    				check[new_x][new_y] = true;
	    				arr[new_x][new_y] = arr[start_x][start_y] + 1;
	    				
	    		}
	    	}
	    	
	    }

	    }
}

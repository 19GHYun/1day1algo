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
	    int[] start_x_local = new int[N * M + 2];
	    int[] start_y_local = new int[N * M + 2];
	    int x_y_check = 0;
    
	    arr = new int[M+1][N+1];
	    check = new boolean[M+1][N+1];
	    st = new StringTokenizer(br.readLine());
	    
	    for(int i = 1 ; i < M + 1 ; i++) {
	    	for(int j = 1 ; j < N + 1 ; j++) {
	    		arr[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    	if( i == M) {
	    		
	    	}else {
	    		st = new StringTokenizer(br.readLine());
	    	}
	    	
	    }
	    
	    for(int i = 1 ; i < M + 1 ; i++) {
	    	for(int j = 1 ; j < N + 1 ; j++) {
	    		if(arr[i][j] == 1) {
	    			start_x_local[x_y_check] = i;
	    			start_y_local[x_y_check] = j;
	    			x_y_check++;
	    		}
	    	}
	    }
	    
	    start_x_local = Arrays.stream(start_x_local)
	    		.filter(num -> num != 0)
	    		.toArray();
	    
	    start_y_local = Arrays.stream(start_y_local)
	    		.filter(num -> num != 0)
	    		.toArray();
	    
	    int max = 0;
	    boolean minuscheck = false;
	    bfs(start_x_local, start_y_local);
	    
	    for(int i = 1; i < M + 1 ; i++) {
	    	for(int j = 1 ; j < N + 1 ; j++) {
	    		if(arr[i][j] == 0) {
	    			minuscheck = true;
	    		}
	    		else {
	    			if(max < arr[i][j]) {
	    				max = arr[i][j];
	    			}
	    		}
	    	}
	    }
	    
	    if(minuscheck) {
	    	System.out.print(-1);
	    }else {
	    	System.out.print(max - 1);
	    }
	    
	    
	   
	
//	    for(int a : start_x_local) {
//	    		System.out.print(a + " ");
//	    	
//	    }
//	    System.out.println();
//	    
//	    for(int a : start_y_local) {
//	    		System.out.print(a + " ");    	
//	    }
	   	
//	    for(int i = 1 ; i < M + 1 ; i++) {
//	    	for(int j = 1 ; j < N + 1 ; j++) {
//	    		System.out.print(arr[i][j]);
//	    	}
//	    	System.out.println();
//	    }
	    
	
	    
    
	}
	    public static void bfs(int[] start_x, int[] start_y) {
	    	for(int i = 0 ; i < start_x.length ; i++) {
		    	check[start_x[i]][start_y[i]] = true;
		    	q.add(new int[] {start_x[i], start_y[i]});
	    	}

	    	int tx;
	    	int ty;
	    	
	    	while(!q.isEmpty()) {
	    			int[] where = q.poll();
	    			tx = where[0]; // 이걸 초기화 해줘야할거같은데?
		    		ty = where[1];
		    		
		    		for(int i = 0 ; i < 4 ; i++) {
		    			int new_x = tx + dx[i];
		    			int new_y = ty + dy[i];
		    			
		    			if(new_x  <= 0 || new_y <= 0 || new_x >= M + 1 || new_y >= N + 1) {
		    				continue;
		    			}
		    			if(arr[new_x][new_y] == 0 && !check[new_x][new_y]) {
		    				q.add(new int[] {new_x, new_y});
		    				check[new_x][new_y] = true;
		    				arr[new_x][new_y] = arr[tx][ty] + 1;
		    				
		    		}
		    	}
	    	

	    	
	    }

	 }
}

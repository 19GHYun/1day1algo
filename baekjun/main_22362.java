import java.util.*;
import java.io.*;

public class Main {
		public static int W, H, N, D, B; //왼쪽부터 높이 너비 개수 폭발범위 폭발번호
		public static Queue<int[] > q = new LinkedList<>();
		public static int[] dx = { 1, -1, 0, 0};
		public static int[] dy = { 0, 0, 1, -1};
		public static boolean[][] check;
		public static int[][] arr;
		public static int cnt;
		
	    public static void main(String[] args) throws IOException {
	    
	    	Scanner sc = new Scanner(System.in);
	    	int boom_x;
	    	int boom_y;
	    	int boom_start_x = 0;
	    	int boom_start_y = 0; 
	    	
	    	while(true) {
	    		cnt = 0;
	    		
		    	W = sc.nextInt();
		    	H = sc.nextInt();
		    	N = sc.nextInt();
		    	D = sc.nextInt();
		    	B = sc.nextInt();
		    	
		    	if(W == 0 && H == 0 && N == 0 && D == 0 && B == 0) {
		    		break;
		    	}
		    	
		    	arr = new int[H + 1][W + 1];
		    	check = new boolean[H + 1][W + 1];
		    	
		    	for(int i = 0 ; i < N ; i++) {
		    		boom_x = sc.nextInt();
		    		boom_y = sc.nextInt();
		    		
		    		if(i == B - 1) {
		    			boom_start_x = boom_x;
		    			boom_start_y = boom_y;
		    		}
		    		arr[boom_y][boom_x] = 1;
		    		
		    	}
		    	
		    	bfs(boom_start_x , boom_start_y);
		    	
		    	System.out.println(cnt);
		    	
		    	//폭발하는 갯수
	    	}

	    			
	    	
	    	
	    }
	    
	    public static void bfs(int start_x, int start_y){
	    	check[start_y][start_x] = true;
	    	q.add(new int[] { start_y, start_x});
	    	while(!q.isEmpty()) {
	    		int[] where = q.poll();
	    		cnt++;
	    		int poll_y = where[0];
	    		int poll_x = where[1];
	    		for(int i = 1 ; i < D + 1 ; i++) {
	    			for(int j = 0 ; j < 4; j++) {
	    				int new_y = poll_y + dy[j] * i;
	    				int new_x = poll_x + dx[j] * i;
	    				
	    				if(new_x >= 1 && new_x <= W && new_y >= 1 && new_y <= H) {
	    					if(arr[new_y][new_x] == 1 && !check[new_y][new_x]) {
	    						check[new_y][new_x] = true;
	    						q.add(new int[] {new_y , new_x});
	    					}
	    				}
	    				
	    			}
	    		}
	    	}
	    	
	    	
	    	
	    }
	    
	    
	    
}

import java.io.*;
import java.util.*;

	public class Main {
		public static int N,M; // 가로 세로
		public static int[][] arr;
		public static boolean[][] check;
		public static int[] dx = {0,0,1,-1};
		public static int[] dy = {1,-1,0,0};
		public static int B_power = 0;
		public static int W_power = 0;
		public static int B_count = 1;
		public static int W_count = 1;
		
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        M = Integer.parseInt(st.nextToken());
	        N = Integer.parseInt(st.nextToken());
	        
	        arr = new int[N][M];
	        check = new boolean[N][M];
	        

	        
	        for(int i = 0 ; i < N ; i++) {
		        String a = br.readLine();
	        	for(int j = 0 ; j < M ; j++) {
	        		arr[i][j] = a.charAt(j) - 'B';
	        	}
	        	
	        }
	        
	        for(int i = 0 ; i < N ; i++) {
	        	for(int j = 0 ; j < M ; j++) {
	        		if(arr[i][j] == 0 && !check[i][j]) { // B
	        			B_dfs(i,j);
	        			B_power += B_count * B_count;
	        			B_count = 1;
	        		}
	        		else if(arr[i][j] == 21 && !check[i][j]) { // W
	        			W_dfs(i,j);
	        			W_power += W_count * W_count;
	        			W_count = 1;
	        		}
	        	}
	        }
	        
	        
	        System.out.println(W_power + " " + B_power);
	        
	        
	    }
	    public static void W_dfs(int x, int y) {
	    	check[x][y] = true;
	    	for(int i = 0 ; i < 4 ; i++) {
	    		int new_x = x + dx[i];
	    		int new_y = y + dy[i];
	    		if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
	    			if(arr[new_x][new_y] == 21 && !check[new_x][new_y]) {
	    				W_count++;
	    				W_dfs(new_x,new_y);
	    			}
	    		}
	    	}
	    }
	    public static void B_dfs(int x, int y) {
	    	check[x][y] = true;
	    	for(int i = 0 ; i < 4 ; i++) {
	    		int new_x = x + dx[i];
	    		int new_y = y + dy[i];
	    		if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
	    			if(arr[new_x][new_y] == 0 && !check[new_x][new_y]) {
	    				B_count++;
	    				B_dfs(new_x,new_y);
	    			}
	    		}
	    	}
	    }
	    
	}

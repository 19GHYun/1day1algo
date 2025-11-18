import java.io.*;
import java.util.*;

public class Main {
	public static int N,M;
	public static int[][] arr;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] check;
	public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int robot_x = Integer.parseInt(st.nextToken());
        int robot_y = Integer.parseInt(st.nextToken());
        int where = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        check = new boolean[N][M];
        
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 1) {
        			check[i][j] = true;
        		}
        	}
        }
        
        dfs(robot_x,robot_y,where);
        System.out.println(answer);
        
        
    }
    
    public static void dfs(int x, int y, int state) { // 0이면 북쪽 1이면 동쪽 2면 남쪽 3이면 서쪽
    	if(!check[x][y]) {
    		check[x][y] = true;
    		answer++;
    		dfs(x,y,state);
    		return;
    	}
    	else {
    		boolean can_clean = false;
    		for(int i = 0 ; i < 4 ; i++) {
    			int new_x = x + dx[i];
    			int new_y = y + dy[i];
    			if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
    				if(can_clean) {
    					break;
    				}
    				if(!check[new_x][new_y]) {
    					can_clean = true;
    				}
    				else {
    					
    				}
    				
    			}
    			
    		}
    		
    		if(can_clean) { //4방에 청소해야하는 곳이 있다면 
    			int new_state = state;
    			for(int i = 0 ; i < 4 ; i++) {
    				if(new_state == 0) {
    					new_state = 3;
    				}
    				else {
    					new_state--;
    				}
    				
    				if(robot_forward(x,y,new_state)) {
    					switch(new_state) {
    					case 0:
    						x--;
    						break;
    					
    					case 1:
    						y++;
    						break;
    						
    					case 2:
    						x++;
    						break;
    						
    					case 3:
    						y--;
    						break;
    					}
    					
    					dfs(x,y,new_state);
    					return;
    				}
    				
    			}
    			
    			
    			
    		}
    		else { // 4방에 청소해야하는곳이 없으면
    			switch(state) {
    			case 0:
    				x++;
    				break;
    			case 1:
    				y--;
    				break;
    			case 2:
    				x--;
    				break;
    			case 3:
    				y++;
    				break;
    			}
    			if(x >= 0 && x < N && y >= 0 && y < M && arr[x][y] == 0) {
    				dfs(x,y,state);
    				return;
    			}
    			else {
    				return;
    			}
    			
    		}
    		
    	}
    	
    	
    }
    
    public static boolean robot_forward(int x_x, int y_y, int rf_state) {
    	if(rf_state == 0) {
    		x_x--;
    	}
    	else if(rf_state == 1) {
    		y_y++;
    	}
    	else if(rf_state == 2) {
    		x_x++;
    	}
    	else if(rf_state == 3) {
    		y_y--;
    	}
    	
		if(x_x >= 0 && x_x < N && y_y >= 0 && y_y < M) {
			if(!check[x_x][y_y]) {
				return true;
			}
			
		}
    	
    	return false;
    	
    }
    
    
}

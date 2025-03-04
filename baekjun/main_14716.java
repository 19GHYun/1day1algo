import java.util.*;
import java.io.*;

public class Main {
    public static int N,M; // 정점, 간선
    public static int[][] arr;
    public static boolean[][] check;
    public static int[] dx = {0,0,1,1,1,-1,-1,-1};
    public static int[] dy = {1,-1,0,1,-1,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        check = new boolean[N][M];
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int answer = 0;
        
        for(int i = 0 ; i < N ; i++) {
        	for(int j = 0 ; j < M ; j++) {
        		if(arr[i][j] == 1 && !check[i][j]) {
        			dfs(i,j);
        			answer++;
        		}
        	}
        }
        
        System.out.println(answer);
        
    	
    }
    
    public static void dfs(int x, int y) {
    	check[x][y] = true;
    	
    	for(int i = 0 ; i < 8 ; i++) {
    		int new_x = x + dx[i];
    		int new_y = y + dy[i];
    		
    		if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
    			if(arr[new_x][new_y] == 1 && !check[new_x][new_y]) {
    				dfs(new_x,new_y);
    			}
    			
    			
    		}
    	}
    	
    }
    


}

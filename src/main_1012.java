import java.io.*;
import java.util.*;

public class Main {
	public static int T,N,H,M; // 테케,가로,높이 , 배추
	public static int[][] arr;
	public static boolean[][] check;
	public static int answer = 0;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        T = Integer.parseInt(st.nextToken());
        
        for(int q = 0 ; q < T ; q++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            answer = 0;
            
            check = new boolean[N][H];
            arr = new int[N][H];
            
            for(int i = 0 ; i < M ; i++) {
            	st = new StringTokenizer(br.readLine());
            	int a1 = Integer.parseInt(st.nextToken());
            	int a2 = Integer.parseInt(st.nextToken());
            	
            	arr[a1][a2] = 1;
            }
            
            for(int i = 0 ; i < N  ; i++) {
            	for(int j = 0 ; j < H ; j++) {
                	if(arr[i][j] == 1 && !check[i][j]) {
                		dfs(i,j);
                		answer++;
                	}
            	}
            }
            
            System.out.println(answer);
        }
        

        
        
	}
    
    public static void dfs(int x, int y) {
    	check[x][y] = true;
    	
    	for(int i = 0 ; i < 4;  i++) {
    		int new_x = x + dx[i];
    		int new_y = y + dy[i];
    		if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < H) {
    			if(arr[new_x][new_y] == 1 && !check[new_x][new_y]) {
    				dfs(new_x, new_y);
    			}
    		}
    	}
    }

}

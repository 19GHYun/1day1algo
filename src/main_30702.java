import java.io.*;
import java.util.*;

public class Main {
	public static char[][] arr_A;
	public static char[][] arr_B;
	public static boolean[][] check;
	public static int N,M;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr_A = new char[N][M];
        arr_B = new char[N][M];
        check = new boolean[N][M];
        
        String a;
        
    	for(int i = 0 ; i < N ; i++) {
    		a = br.readLine();
    		for(int j = 0 ; j < M ; j++) {
    			arr_A[i][j] = a.charAt(j);
    		}
    	}

    	for(int i = 0 ; i < N ; i++) {
    		a = br.readLine();
    		for(int j = 0 ; j < M ; j++) {
    			arr_B[i][j] = a.charAt(j);
    		}
    	}
    	
    	for(int i = 0 ; i < N ; i++) {
    		for(int j = 0 ; j < M ; j++) {
    			if(!check[i][j]) {
    				check[i][j] = true;
    				bfs(i,j,arr_B[i][j], arr_A[i][j]);
    				arr_A[i][j] = arr_B[i][j];
    			}
    		}
    	}
    	
    	if(same_flag()) {
    		System.out.println("YES");
    	}
    	else {
    		System.out.println("NO");
    	}
        
    }
    
    public static void bfs(int x, int y, char to_color, char my_color) {
    	Queue<int[]> que = new ArrayDeque<>();
    	que.add(new int[] {x, y});
    	
    	while(!que.isEmpty()) {
    		int[] where = que.poll();
    		
    		for(int i = 0 ; i < 4 ; i++) {
    			int new_x = where[0] + dx[i];
    			int new_y = where[1] + dy[i];
    			if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
    				if(!check[new_x][new_y] && arr_A[new_x][new_y] == my_color) {
    					check[new_x][new_y] = true;
    					arr_A[new_x][new_y] = to_color;
    					que.add(new int[] {new_x, new_y});
    				}
    				
    			}
    		}
    		
    		
    		
    	}
    	
    	
    }
    
    public static boolean same_flag() {
    	for(int i = 0 ; i < N ; i++) {
    		for(int j = 0 ; j < M ; j++) {
    			if(arr_A[i][j] == arr_B[i][j]) {
    				
    			}
    			else {
    				return false;
    			}
    		}
    	}
    	
    	
    	return true;
    }
    
    
}

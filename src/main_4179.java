import java.io.*;
import java.util.*;

public class Main {
	public static int R,C;
	public static char[][] arr;
	public static boolean[][] check;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int start_x, start_y;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new char[R][C];
        check = new boolean[R][C];
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i = 0 ; i < R ; i++) {
        	String a = br.readLine();
        	for(int j = 0 ; j < C ; j++) {
        		arr[i][j] = a.charAt(j);
        		
        		if(arr[i][j] == 'J') {
        			start_x = i;
        			start_y = j;
        			check[start_x][start_y] = true;
        		}
        		if(arr[i][j] == 'F') {
        			q.add(new int[] {i,j,0,1});
        		}
        		
        	}
        }
		q.add(new int[] {start_x,start_y,0,0});
        bfs(q);

        
    }
    
    public static void bfs(Queue<int[]> que) {
    	while(!que.isEmpty()) {
    		
 //   		for(int i = 0; i < R ; i++) {
 //  			for(int j = 0 ; j < C ; j++) {
//    				System.out.print(arr[i][j] + " ");
 //   			}
  //  			System.out.println();
   // 		}

    		for(int p = 0 ; p < que.size() ; p++) {
        		int[] where = que.poll();
        		int time = where[2];
        		int what = where[3];
        		if(what == 0 && (where[0] == 0 || where[1] == 0 || where[0] == R - 1 || where[1] == C - 1)) {
        			System.out.println(time + 1);
        			return;
        		}
        		
        		for(int i = 0 ; i < 4 ; i++) {
        			int new_x = where[0] + dx[i];
        			int new_y = where[1] + dy[i];
        			if(new_x >= 0 && new_x < R && new_y >= 0 && new_y < C) {
        				if(what == 1 && arr[new_x][new_y] == '.') {
        					arr[new_x][new_y] = 'F';
        					que.add(new int[] {new_x, new_y, time + 1, 1});
        					
        				}
        				
        				if(what == 0 && arr[new_x][new_y] == '.' && !check[new_x][new_y]) {
        					que.add(new int[] {new_x, new_y, time + 1 , 0});
        					arr[new_x][new_y] = 'J';
        					check[new_x][new_y] = true;
        				}
        				
        			}
        			
        			
        		}
    		}
    		
    	}
    	System.out.println("IMPOSSIBLE");
    	
    }


    
}

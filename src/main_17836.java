import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, T; // 가로 세로 시간
	public static int[][] arr;
	public static int answer = 100000;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] check;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        check = new boolean[N][M];
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        check[0][0] = true;
        bfs(0,0,0);
        if(answer > T) {
        	System.out.println("Fail");
        }
        else {
            System.out.println(answer);
        }

        
    }
    
    public static void bfs(int x, int y, int cnt) {
    	Queue<int[]> que = new ArrayDeque<>();
    	que.add(new int[] {x,y,cnt});
    	
    	while(!que.isEmpty()) {
    		
//    		for(int i = 0 ; i < N ; i++) {
//    			for(int j = 0 ; j < M ; j++) {
//    				System.out.print(arr[i][j] + " ");
//    			}
//    			System.out.println();
//    		}
//    		System.out.println();

    		
    		int[] where = que.poll();
    		int old_x = where[0];
    		int old_y = where[1];
    		int cnt2 = where[2];
    		
    		
        		if(where[0] == N - 1 && where[1] == M - 1) {
        			answer = Math.min(answer, cnt2);
        			return;
        		}
        		
        		for(int i = 0 ; i < 4 ; i++) {
        			int new_x = old_x + dx[i];
        			int new_y = old_y + dy[i];
        			if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
        				if((arr[new_x][new_y] == 0  || arr[new_x][new_y] == 2) && !check[new_x][new_y]) {
        					check[new_x][new_y] = true;
        					if(arr[new_x][new_y] == 2) {
        						int a = cnt2 + 1 + N - new_x + M - new_y - 2;
        						if( a > T) {
        							
        						}else {
            						answer = Math.min(answer, a);
        						}

        					}
        					arr[new_x][new_y] = 3;
        					que.add(new int[] {new_x, new_y, cnt2 + 1});
        				}
        				
        			}
        		}
        		
    		
    		




    	}
    	
    }
}

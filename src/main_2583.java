import java.util.*;
import java.io.*;

public class Main {
	     
	public static int M,N,K; // M이 가로, N이 세로, K는 직사각형 갯수
	public static int[][] arr;
	public static Queue<int[]> q = new LinkedList<>();
	public static List <Integer> list = new ArrayList<>();
	public static boolean[][] check;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int totalarea = 0;
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    M = sc.nextInt();
	    N = sc.nextInt();
	    K = sc.nextInt();
	    
	    arr = new int [N][M];
	    check = new boolean[N][M];
	    
	    int x1, x2, y1, y2;
	    
	    for(int i = 0 ; i < K ; i++) {
	    	x1 = sc.nextInt();
	    	y1 = sc.nextInt();
	    	x2 = sc.nextInt();
	    	y2 = sc.nextInt();
	    	
	    	for(int k = x1 ; k < x2 ; k++) {
	    		for(int p = y1 ; p < y2 ; p++) {
	    			arr[k][p] = 1;
	    		}
	    	}
	    	
	    }
	    
//	    for(int i = 0 ; i < N ; i++) {
//	    	for(int j = 0 ; j < M ; j++) {
//	    		System.out.print(arr[i][j] + " ");
//	    	}
//	    	System.out.println();
//	    }
//	    
//	    System.out.println();
	    for(int i = 0 ; i < N ; i++) {
	    	for(int j = 0 ; j < M ; j++) {
	    		bfs(i,j);
	    	}
	    }
	    
	    System.out.println(totalarea);
	    
	    Collections.sort(list);
	    for(int a : list) {
	    	System.out.print(a + " ");
	    }

	}
	
	public static void bfs(int start_x , int start_y) {
		int cnt = 0;
		if(arr[start_x][start_y] == 1) {
			
		}
		else if( arr[start_x][start_y] == 0 && !check[start_x][start_y]) {
			totalarea++;
			q.add( new int[] {start_x, start_y});
			check[start_x][start_y] = true;
			cnt++;
			while(!q.isEmpty()) {
				int where[] = q.poll();
				int new_x = where[0];
				int new_y = where[1];
				for(int i = 0 ; i < 4; i++) {
					int new_new_x = new_x + dx[i];
					int new_new_y = new_y + dy[i];
					
					if(new_new_x >= 0 && new_new_x <N && new_new_y >= 0 && new_new_y < M) {
						
						if(arr[new_new_x][new_new_y] == 0 && !check[new_new_x][new_new_y]) {
							q.add(new int[] {new_new_x , new_new_y});
							check[new_new_x][new_new_y] = true;
							cnt++;
						}
						
					}
					
				}
				
				
			}
			list.add(cnt);
		}
		
	}
	     
	
}

import java.util.*;
import java.io.*;


public class Main {
	public static int N; // N*N
	public static int[][] arr;
	public static int[][] arr_color;
	public static boolean[][] check;
	public static boolean[][] check_color;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int answer = 0;
		int answer_color = 0;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		arr_color = new int[N][N];
		check = new boolean[N][N];
		check_color = new boolean[N][N];
		
		String a;
		
		for(int i = 0 ; i < N ; i++) {
			a = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				if(a.charAt(j) == 'R') {
					arr[i][j] = 1; // 빨간색 1
					arr_color[i][j] = 1;
				}
				else if(a.charAt(j) == 'G') {
					arr[i][j] = 2; // 녹색 2
					arr_color[i][j] = 1;
				}
				else if(a.charAt(j) == 'B') {
					arr[i][j] = 3; // 파란색 3
					arr_color[i][j] = 3;
				}
			}
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(!check[i][j]) {
					dfs(i,j,arr[i][j]);
					answer++;
				}
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(!check_color[i][j]) {
					dfs_color(i,j,arr_color[i][j]);
					answer_color++;
				}
			}
		}
		
		System.out.print(answer + " " + answer_color);
		
		

	}
	
	public static void dfs(int x, int y, int color) {
		check[x][y] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			
			if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < N) {
				if(arr[new_x][new_y] == color && !check[new_x][new_y]) {
					dfs(new_x,new_y,color);
				}
			}
		}
	}
	
	public static void dfs_color(int x, int y, int color) {
		check_color[x][y] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			
			if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < N) {
				if(arr_color[new_x][new_y] == color && !check_color[new_x][new_y]) {
					dfs_color(new_x,new_y,color);
				}
			}
		}
	}

}

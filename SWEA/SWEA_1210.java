import java.util.*;
import java.io.*;

public class Solution {
	public static int[][] arr;
	public static boolean[][] check;
	public static int[] dx = {0,0,-1}; // 왼쪽보고 위에보고 오른쪽봄
	public static int[] dy = {-1,1,0}; // 
	public static int T;
	public static int start_x, start_y;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i = 1 ; i < 11 ; i++) {  // 10번 돌려서 그냥 
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			
			arr = new int[100][100];
			check = new boolean[100][100];
			String a;
			
			for(int j = 0 ; j < 100 ; j++) {
				a = br.readLine();
				for(int p = 0 ; p < 100 ; p++) {
					arr[j][p] = a.charAt(p*2 ) - '0';
					if(arr[j][p] == 2) {
						start_x = j;
						start_y = p;
					}
				}
			}
			
//			for(int j = 0 ; j < 100 ; j++) {
//				for(int p = 0 ; p < 100 ; p++) {
//					System.out.print(arr[j][p] + " ");
//				}
//				System.out.println();
//			}
			dfs(start_x,start_y);
			
			
		}
		
	}
	
	public static void dfs(int x, int y) {
		check[x][y] = true;
		boolean localcheck = false;
		if(x == 0) {
			System.out.println("#" + T + " " + y);
			return;
		}
		
		int new_x = 0;
		int new_y = 0;
		for(int i = 0 ; i < 3 ; i++) {
			new_x = x + dx[i];
			new_y = y + dy[i];
			
			
			if(new_x >= 0 && new_x < 100 && new_y >= 0 && new_y < 100) {
				if(!check[new_x][new_y] && arr[new_x][new_y] == 1) {
					localcheck = true;
//					System.out.println(new_x + " " +  new_y);
					break;
					
				}
			}
		}
		if(localcheck) {
			dfs(new_x,new_y);
		}
		
		
	}
	
}

import java.util.*;
import java.io.*;
/*
 * 하.... 구현은 했지만, 100% 메모리나 시간이 터질거 같은데, 최적의 방법을 모르겠다.. 
 * 
 */
public class Main {
	public static int N; // 크기
	public static int[][] arr;
	public static boolean[][] check;
	public static int answer = 0;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE; // 이걸 이용해서 그나마 가짓수를 줄여봤는데, 택도 없을거같다.
		
		StringTokenizer st;
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(arr[i][j], min);
				max = Math.max(arr[i][j], max);
			}
		}
		for(int p =  min-1 ; p < max ; p++) {
			int mid_answer = 0;
			check = new boolean[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(arr[i][j] > p && !check[i][j]) {
						mid_answer++;
						dfs(i,j,p);
					}
				}
			}
			answer = Math.max(answer, mid_answer);
		}
		
		System.out.println(answer);
		
	}
	public static void dfs(int x, int y,int safe) {
		check[x][y] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < N) {
				if(arr[new_x][new_y] > safe && !check[new_x][new_y]) {
					dfs(new_x,new_y,safe);
				}
			}
		}
	}

}

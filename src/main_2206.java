import java.util.*;
import java.io.*;
import java.lang.reflect.Parameter;
import java.security.DrbgParameters.NextBytes;

public class Main {
	public static int N, M; // 높이, 너비
	public static int[][] arr; // 배열
	public static boolean[][][] check;
	public static int answer = 0;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		check = new boolean[N][M][2];
		String a;
		
		for(int i = 0 ; i < N ; i++) {
			a =br.readLine();
			for(int j = 0 ; j < a.length() ; j++) {
				arr[i][j] = a.charAt(j) - '0';
			}
		}
		
		bfs(1);
		
		
		
//		for(int i = 0 ; i < N ; i++) {
//			for(int j = 0 ; j < M ; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		
	}
	
	public static void bfs(int crush) {
		Queue <int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {0, 0, crush, 1});
		check[0][0][crush] = true;
		
		while(!q.isEmpty()) {
			int[] where = q.poll();
			int old_new_x = where[0];
			int old_new_y = where[1];
			int new_crush = where[2];
			int new_cnt = where[3];
			
			if(old_new_x == N - 1 && old_new_y == M - 1) {
				System.out.println(new_cnt);
				return;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int new_x = old_new_x + dx[i];
				int new_y = old_new_y + dy[i];
				
				if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
					if(arr[new_x][new_y] == 0) {
						if(check[new_x][new_y][new_crush]) {
							continue;
						}
						check[new_x][new_y][new_crush] = true;
						q.add(new int[] {new_x, new_y, new_crush, new_cnt + 1});
						
					}
					else if(arr[new_x][new_y] == 1) {
						if(new_crush == 1) {
							if(check[new_x][new_y][new_crush - 1]) {
								continue;
							}
							check[new_x][new_y][new_crush - 1] = true;
							q.add(new int[] {new_x, new_y, new_crush - 1, new_cnt + 1});
						}
						
					}
				}
				
				
			}
			
			
			
		}
		System.out.println(-1);
		return;
		
	}

}

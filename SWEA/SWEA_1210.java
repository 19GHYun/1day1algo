import java.util.*;
import java.io.*;
/*
* 아이디어
* 도착지 X 부터 위로 올라가면서 dfs로 왼쪽 먼저 보고, 그다음 오른쪽 보고, 없으면 위로 올라가게 
* 설계 및 구현.
*
*
*/
public class Solution {
	public static int[][] arr;
	public static boolean[][] check;
	public static int[] dx = {0,0,-1}; // 왼쪽보고 위에보고 오른쪽봄
	public static int[] dy = {-1,1,0}; // 
	public static int T;
	public static int start_x, start_y;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;  // 입력이 많길래 이거 썼습니다.
		
		
		for(int i = 1 ; i < 11 ; i++) {  // 그냥 10번 돌립니다.
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken()); // 일단 받았습니다.
			
			arr = new int[100][100];	// 사다리
			check = new boolean[100][100]; // 사다리 체크. 왼쪽으로 꺾고 다시 오른쪽 가면 안되니까
			String a;
			
			for(int j = 0 ; j < 100 ; j++) {
				a = br.readLine();	//라인을 읽어서
				for(int p = 0 ; p < 100 ; p++) {
					arr[j][p] = a.charAt(p*2 ) - '0'; // 이렇게 줬습니다.
					if(arr[j][p] == 2) { // 2일때 시작할려고요. 그래서 받앗어요
						start_x = j; 
						start_y = p;
					}
				}
			}
			
//			for(int j = 0 ; j < 100 ; j++) {  // 디버깅인데 의미가 없더라구요
//				for(int p = 0 ; p < 100 ; p++) {
//					System.out.print(arr[j][p] + " ");
//				}
//				System.out.println();
//			}
			dfs(start_x,start_y); // dfs 시작
			
			
		}
		
	}
	
	public static void dfs(int x, int y) {
		check[x][y] = true; // 일단 현재자리 true 해주시고
		boolean localcheck = false; // 이건 이제보니 없어도 될거같네요
		if(x == 0) { // 도착했을때 y 좌표를 출력합니다. 이때 T를 처음썻네요
			System.out.println("#" + T + " " + y);
			return;
		}
		
		int new_x = 0; // 말 그대로 new_x
		int new_y = 0;
		for(int i = 0 ; i < 3 ; i++) {
			new_x = x + dx[i]; // i가 0이면 왼쪽보고, 1이면 오른쪽보고, 2면 올라갑니다.
			new_y = y + dy[i];
			
			
			if(new_x >= 0 && new_x < 100 && new_y >= 0 && new_y < 100) { // 유효한 범위에 있어야겠죠?
				if(!check[new_x][new_y] && arr[new_x][new_y] == 1) { // 안갔던 곳이고, 사다리라면?
					localcheck = true; // true
//					System.out.println(new_x + " " +  new_y);  // 디버깅용
					break; // break해서 끊어줍니다.
					
				}
			}
		}
		if(localcheck) {
			dfs(new_x,new_y); // 재커 돌려줍니다
		}
		
		
	}
	
}

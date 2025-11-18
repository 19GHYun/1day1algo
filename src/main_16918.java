import java.util.*;
import java.io.*;

public class Main {
	public static int R, C, N; // 높이, 너비, N초 후
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static char[][] arr;

	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		
//		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		String a;
		
		//br.readLine();
		for(int i = 0 ; i < R ; i++) {
			a = br.readLine();
			for(int j = 0 ; j < a.length() ; j++) {
				arr[i][j] = a.charAt(j);
			}
		}
		int i = 0; // 흐른시간
		
		if (N == 0 || N == 1) {
				for(int p = 0 ; p < R ; p++) {
				for(int j = 0 ; j < C ; j++) {
					System.out.print(arr[p][j]);
				}
				System.out.println();
			}
		}
		else if(N % 2 == 0) {
			for(int p = 0 ; p < R ; p++) {
			for(int j = 0 ; j < C ; j++) {
				System.out.print("O");
			}
			System.out.println();
		}
		}
		
		else if(N % 2 == 1) {
			int c = N / 2;
			
			for(int p = 0 ; p < c ; p++) {
				boom_array();
				boom_banjeon();
				
			}
			
			for(int p = 0 ; p < R ; p++) {
				for(int j = 0 ; j < C ; j++) {
					System.out.print(arr[p][j]);
				}
				System.out.println();
			}
			
		}
		
		//디버그용
//		for(int i = 0 ; i < R ; i++) {
//			for(int j = 0 ; j < C ; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
	}
	
	public static void boom_array(){
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(arr[i][j] == 'O') {
					for(int p = 0 ; p < 4 ; p++) {
						int new_x = i + dx[p];
						int new_y = j + dy[p];
						
						if(new_x >= 0 && new_x < R && new_y >= 0 && new_y < C) {
							if(arr[new_x][new_y] == '.')
								arr[new_x][new_y] = 'X';
						}
					}
					
					
				}
			}
		}
		
		
	
	}
	
	public static void boom_banjeon() {
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(arr[i][j] == 'O' || arr[i][j] == 'X') {
					arr[i][j] ='.';
				}else {
					arr[i][j] = 'O';
				}
			}
		}
	}

}

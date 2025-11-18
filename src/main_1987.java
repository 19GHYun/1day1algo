import java.util.*;
import java.io.*;


public class Main {
	public static int R, C; // 세로 ,가로
	public static char[][] arr;
	public static ArrayList<Character> list = new ArrayList<>();
	public static boolean start = false;
	public static int answer = Integer.MIN_VALUE;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		
		String a;
		
		for(int i = 0 ; i < R ; i++) {
			a = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				arr[i][j] = a.charAt(j);
			}
		}
		
		backt(0,0,0);
		
		System.out.println(answer);

	

	}

	public static void backt(int x, int y,int cnt) {
		answer = Math.max(answer, cnt);
		
		if(list.size() == 0 && !start) {
			list.add(arr[0][0]);
			backt(0,0,cnt+1);
			start = true;
		}else {
			for(int i = 0 ; i < 4 ; i++) {
				int new_x = x + dx[i];
				int new_y = y + dy[i];
				if(new_x >= 0 && new_x < R && new_y >= 0 && new_y < C) {
					if(!list.contains(arr[new_x][new_y])) {
						list.add(arr[new_x][new_y]);
						backt(new_x,new_y,cnt+1);
						list.remove(list.size()-1);
					}
					
					
				}
			}
		}
	}
	
	
}

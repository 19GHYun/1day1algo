import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[][] arr;
	public static int a1 = 0;
	public static int a2 = 0;
	public static int a3 = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);

	}
	public static void divide(int x, int y, int size) {
		if(check(x,y,size)) {
			if(arr[x][y] == -1) {
				a1++;
			}
			else if(arr[x][y] == 0) {
				a2++;
			}
			else {
				a3++;
			}
			return;
		}
		
		int new_size = size / 3;
		
		divide(x,y,new_size);
		divide(x,y + new_size,new_size);
		divide(x,y + new_size *2,new_size);
		divide(x + new_size,y,new_size);
		divide(x + new_size,y + new_size,new_size);
		divide(x + new_size,y + new_size *2,new_size);
		divide(x + new_size * 2,y,new_size);
		divide(x + new_size * 2,y + new_size,new_size);
		divide(x + new_size * 2,y + new_size *2,new_size);
		
	}
	
	public static boolean check(int x, int y, int size) {
		int color = arr[x][y];
		for(int i = x ; i < x + size ; i++) {
			for(int j = y ; j < y + size ; j++) {
				if(arr[i][j] != color) {
					return false;
				}
			}
		}
		
		
		return true;
	}

}

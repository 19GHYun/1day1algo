import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static char[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }

		
		divide(0,0,N);
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());

	}

	public static void divide(int x, int y, int size) {
		if(size == 3) {
			
			arr[x][y] = '*';
			arr[x][y+1] = '*';
			arr[x][y+2] = '*';
			arr[x+1][y] = '*';
			arr[x+1][y+1] = ' ';
			arr[x+1][y+2] = '*';
			arr[x+2][y] = '*';
			arr[x+2][y+1] = '*';
			arr[x+2][y+2] = '*';

			return;
		}
		
		int new_size = size /3;
		
		divide(x,y,new_size);
		divide(x,y + new_size,new_size);
		divide(x,y + new_size * 2,new_size);
		divide(x + new_size,y,new_size);
		divide(x + new_size,y + new_size*2,new_size);
		divide(x + new_size*2,y,new_size);
		divide(x + new_size*2,y + new_size,new_size);
		divide(x + new_size*2,y + new_size*2,new_size);
		
	}
	


}

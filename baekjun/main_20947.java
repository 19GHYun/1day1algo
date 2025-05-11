import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[][] arr;
	public static boolean[][] check;
	public static int[] dx = { 0, 1, -1, 0 };
	public static int[] dy = { 1, 0, 0, -1 };
	public static boolean boom_check = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new char[N][N];

		check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			for (int ii = 0; ii < N; ii++) {
				arr[i][ii] = a.charAt(ii);
				if (arr[i][ii] == 'O' || arr[i][ii] == 'X') {
					check[i][ii] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int ii = 0; ii < N; ii++) {
				if (arr[i][ii] == 'O') {
					safe_check(i,ii);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int ii = 0; ii < N; ii++) {
				if (!check[i][ii]) {
					arr[i][ii] = 'B';
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int ii = 0 ; ii < N ; ii++) {
				sb.append(arr[i][ii]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void safe_check(int x, int y) {
		for (int i = 0; i < 4; i++) {
			for (int ii = 1; ii < N; ii++) {
				int new_x = x + dx[i] * ii;
				int new_y = y + dy[i] * ii;

				if (new_x < 0 || new_x >= N || new_y < 0 || new_y >= N)
					break;
				if (arr[new_x][new_y] == '.') {
					check[new_x][new_y] = true;
				} else if (arr[new_x][new_y] == 'X' || arr[new_x][new_y] == 'O') {
					break;
				}

			}
		}
	}

}

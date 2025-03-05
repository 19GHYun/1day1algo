import java.io.*;
import java.util.*;
/*
 * 33920kb, 135ms
 * 각 위치로 밀때 메서드 구현했고, 오른쪽으로 밀때를 1차로 구현 한 다음 위 아래 왼쪽은
 * 오른쪽을 기준으로 다시 만들었습니다.
 * 
 */
public class Solution {
	public static int T, N; // 테스트 케이스, 크기
	public static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int p = 1; p < T + 1; p++) {

			sb.setLength(0); // sb 초기화

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			String a = st.nextToken();

			arr = new int[N][N];

			for (int i = 0; i < N; i++) { // 수 넣기
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			switch (a) { // 명령인자
			case ("up"):
				up();
				break;
			case ("down"):
				down();
				break;
			case ("left"):
				left();
				break;
			case ("right"):
				right();
				break;
			}

			System.out.println("#" + p);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}

			System.out.print(sb.toString());

		}

	}

	public static void up() {
		for (int j = 0; j < N; j++) {
			int[] arr2 = new int[N];
			// 열 복사
			for (int i = 0; i < N; i++) {
				arr2[i] = arr[i][j];
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				if (arr2[i] != 0) {
					arr2[count] = arr2[i];
					if (i != count) {
						arr2[i] = 0;
					}
					count++;
				}
			}

			// 위로 합치기
			for (int i = 0; i < N - 1; i++) {
				if (arr2[i] != 0 && arr2[i] == arr2[i + 1]) {
					arr2[i] = arr2[i] * 2;
					arr2[i + 1] = 0;
					i++; // 합친 후 한 칸 건너뜀
				}
			}

			// 위로 밀기
			count = 0;
			for (int i = 0; i < N; i++) {
				if (arr2[i] != 0) {
					arr2[count] = arr2[i];
					if (i != count) {
						arr2[i] = 0;
					}
					count++;
				}
			}

			// 결과 반영
			for (int i = 0; i < N; i++) {
				arr[i][j] = arr2[i];
			}
		}
	}

	public static void down() {
		for (int j = 0; j < N; j++) {
			int[] arr2 = new int[N];
			// 열 복사
			for (int i = 0; i < N; i++) {
				arr2[i] = arr[i][j];
			}

			// 아래로 밀기
			int count = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (arr2[i] != 0) {
					arr2[N - 1 - count] = arr2[i];
					if (i != N - 1 - count) {
						arr2[i] = 0;
					}
					count++;
				}
			}

			// 아래에서 위로 병합
			for (int i = N - 1; i > 0; i--) {
				if (arr2[i] != 0 && arr2[i] == arr2[i - 1]) {
					arr2[i] = arr2[i] * 2;
					arr2[i - 1] = 0;
					i--; // 병합 후 건너뜀
				}
			}

			// 다시 아래로 밀기
			count = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (arr2[i] != 0) {
					arr2[N - 1 - count] = arr2[i];
					if (i != N - 1 - count) {
						arr2[i] = 0;
					}
					count++;
				}
			}

			// 결과 반영
			for (int i = 0; i < N; i++) {
				arr[i][j] = arr2[i];
			}
		}
	}

	public static void right() {
		for (int i = 0; i < N; i++) {
			int[] arr2 = new int[N];
			for (int j = 0; j < N; j++) {
				arr2[j] = arr[i][j];
			}

			// 오른쪽으로 밀기
			int count = 0;
			for (int j = N - 1; j >= 0; j--) {
				if (arr2[j] != 0) {
					arr2[N - 1 - count] = arr2[j];
					if (j != N - 1 - count) {
						arr2[j] = 0;
					}
					count++;
				}
			}

			// 오른쪽에서 왼쪽으로 병합
			for (int j = N - 1; j > 0; j--) {
				if (arr2[j] != 0 && arr2[j] == arr2[j - 1]) {
					arr2[j] = arr2[j] * 2;
					arr2[j - 1] = 0;
					j--; // 병합 후 한 칸 건너뜀
				}
			}

			// 다시 오른쪽으로 밀기
			count = 0;
			for (int j = N - 1; j >= 0; j--) {
				if (arr2[j] != 0) {
					arr2[N - 1 - count] = arr2[j];
					if (j != N - 1 - count) {
						arr2[j] = 0;
					}
					count++;
				}
			}

			// 결과 반영
			for (int j = 0; j < N; j++) {
				arr[i][j] = arr2[j];
			}
		}
	}

	public static void left() {
		for (int i = 0; i < N; i++) {
			int[] arr2 = new int[N];
			// 행 복사
			for (int j = 0; j < N; j++) {
				arr2[j] = arr[i][j];
			}

			// 왼쪽으로 밀기
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (arr2[j] != 0) {
					arr2[count] = arr2[j];
					if (j != count) {
						arr2[j] = 0;
					}
					count++;
				}
			}

			// 왼쪽에서 오른쪽으로 병합
			for (int j = 0; j < N - 1; j++) {
				if (arr2[j] != 0 && arr2[j] == arr2[j + 1]) {
					arr2[j] = arr2[j] * 2;
					arr2[j + 1] = 0;
					j++; // 병합 후 한 칸 건너뜀
				}
			}

			// 다시 왼쪽으로 밀
			count = 0;
			for (int j = 0; j < N; j++) {
				if (arr2[j] != 0) {
					arr2[count] = arr2[j];
					if (j != count) {
						arr2[j] = 0;
					}
					count++;
				}
			}

			// 결과 반영
			for (int j = 0; j < N; j++) {
				arr[i][j] = arr2[j];
			}
		}
	}
}
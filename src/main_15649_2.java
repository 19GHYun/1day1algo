package algo_0218;

/*
 * N과 M1 난이도 2/10
 * 메모리 74480 시간 1744
 * dfs 같은 백트래킹을 썼지만 dfs라고 함수 적엇습니다.
 * 그냥 백트래킹이라 뭐라 할 말이 없네요
 *  다른 방법으로 푸는 걸 생각 해봐야 할지도
 */

import java.util.*;
import java.io.*;

public class Main {

		public static int[] arr;	// N 개수 보고 여기에 1 2 3 넣엇습니다.
		public static boolean[] check; // 뽑은거 또 뽑으면 안되니까요
		public static List<Integer> arr2 = new LinkedList<>(); // 리스트에 넣다 뺏다 반복햇습니다.
		public static int N, M; // N과 M
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);	//사나이는 bufferedreader 안쓰고 scanner 씁니다.
		
		N = sc.nextInt();	// N과 M 받아주고요
		M = sc.nextInt();
		
		arr = new int[N]; 	// 객체 만들어 줘야죠
		check = new boolean[N]; // 얘두요
		
		for(int i = 1 ; i < N + 1 ; i++) {
			arr[i-1] = i;  // 그래서 1 2 3 넣엇습니다.
		}
		dfs(0);  // dfs ㄱㄱ
		
	}
	public static void dfs(int cnt) {
		if(cnt == M) { // 기저 조건은 M개 뽑앗을때
			for(int a : arr2) {	// 여기서 stringbuilder 쓰면 시간이 줄어들거 같네요
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0 ; i < N ; i++) { // 카드풀 있는거만큼 반복하는데
			if(!check[i]) {				// 안뽑은거면
				arr2.add(arr[i]);		// 리스트에 넣습니다.
				check[i] = true;		// 그리고 체크 트루 해줘요.
				dfs(cnt + 1);			// 그리고 재귀 ㄱㄱ
				arr2.remove(arr2.size() - 1);	//이거랑 이 아래코드 25일전에 풀었을땐 이해가 안됐었는데 이젠 잘 되네요
				check[i] = false;
			}
		}
	}
	
}

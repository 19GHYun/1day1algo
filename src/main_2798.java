import java.util.*;
import java.io.*;
/*
 * dp로 풀어볼려다가 내 주제를 깨닿고 그냥 부분집합같은 조합으로 풀었다.
 * 
 */
public class Main {
	public static int N, M;
	public static int[] arr;
	public static ArrayList<Integer> list = new ArrayList<>();
	public static int answer = 0;
	public static int check_answer = 0;

	public static void main(String[] args) throws Exception{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N  ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		johap(0,0);
		
		System.out.println(answer);
		
	}
	
	public static void johap(int start, int cnt) {
		if(cnt >= 3) {
			check_answer = 0;
			for(int a : list) {
				check_answer += a;
				if(check_answer > M) {
					return; 
				}
			}
			answer = Math.max(answer, check_answer);

			return;
		}
		for(int i = start ; i < N ; i++) {
			list.add(arr[i]);
			johap(i + 1 , cnt + 1);
			list.remove(list.size() - 1);
		}
	}

}

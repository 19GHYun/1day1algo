import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] prev = new int[N];
		int[] DP = new int[N];
		
		Arrays.fill(DP, 1);
		
		for(int i = 0 ; i < N ; i++) {
			prev[i] = -1;
			for(int ii = 0 ; ii < i ; ii++) {
				if(arr[ii] < arr[i] && DP[i] < DP[ii] + 1) { // 이 조건 추가해야함
					DP[i] = Math.max(DP[i], DP[ii] + 1);
					prev[i] = ii;
				}
			}
		}
		
		int answer = -1;
		int low_answer = -1;
		for(int i = 0 ; i < N ; i++) {
			if(DP[i] > answer) {
				answer = DP[i];
				low_answer = i;
			}
		}
		System.out.println(answer);
		
		List<Integer> list = new ArrayList<Integer>();
		while(low_answer != -1) {
			list.add(arr[low_answer]);
			low_answer = prev[low_answer];
		}
		
		for(int i = list.size() - 1 ; i >= 0 ; i--) {
			System.out.print(list.get(i) + " ");
		}
		

	}


}

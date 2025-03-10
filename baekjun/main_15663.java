import java.util.*;
import java.io.*;

public class Main {

	static int N; // 자연수 N개 주어지고
	static int M; // 자연수 M개 뽑을때
	static int cnt ;  //이 녀석 어떡하지
	static boolean[] pick;
	static int[] arr;	//주어진 N에 대한 배열
	static ArrayList<Integer> list; //뽑을때 쓸 배열
	static ArrayList<Integer> list2; //전에 출력한거 알려주는 배열
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		pick = new boolean[N];

		
		
		for(int i = 1; i <= N ; i++) {
			arr[i-1] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		sc.close();
	}
	//cnt는 0
	public static void dfs(int index) {
			if(list.size() == M) {
				for (int k = 0; k < list.size(); k++) {
	            System.out.print(list.get(k));
	            if (k < list.size() - 1) {
	                System.out.print(" "); // 마지막 요소 뒤에는 공백을 추가하지 않음
	            	}
				}
				System.out.println();
			}
			
			int prev = -1; 	// 이걸 스태틱으로 주면 안되고 여기에 선언해야함. 이론은 파악했는데 이거때문에 30분 털림 ㅜㅜ
		for(int i = 0 ; i < N ; i++) {
			if(!pick[i] && arr[i] != prev) {
				pick[i] = true;
				list.add(arr[i]);
				prev = arr[i];
				index++;
				dfs(index);
				pick[i] = false;
				list.remove(list.size()-1);
			}
			else {
				continue;
			}
		}

	}

}

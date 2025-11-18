import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			for(int ii = 0 ; ii < N ; ii++) {
				arr[ii] = Integer.parseInt(br.readLine());
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			
			list.add(arr[0]);
			
			for(int ii = 1 ; ii < N ; ii++) {
				if(arr[ii] > list.get(list.size()-1)) {
					list.add(arr[ii]);
				}
				else {
					int index = bs(list, arr[ii]);
					list.set(index, arr[ii]);
				}
			}
			
			System.out.println(list.size());
			
		}

	}
	
	public static int bs(ArrayList<Integer> list, int num) {
		int left = 0;
		int right = list.size();
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(list.get(mid) < num) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
			
		}
		
		return left;
	}

	
}

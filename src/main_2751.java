import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		
		PriorityQueue<Integer> numberSet = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			numberSet.add(Integer.parseInt(st.nextToken()));
			if(i == N-1) {
		    
			}else {
				st = new StringTokenizer(br.readLine());
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = numberSet.poll();
		}

		for(int i  = 0 ; i < N ; i++) {
			System.out.println(arr[i]);
		}

		
		
	}

}

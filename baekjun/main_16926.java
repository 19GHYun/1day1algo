/*310508kb 2580ms
 * 이게 맞는 메모리랑 시간인가요?
 * 덱을 이용해서 배열 쓰까 돌렸습니다.
 * 아마 큐를 스태틱에 넣어서 쓰면 좀 줄어들거같긴합니다?
 */
import java.util.*;
import java.io.*;

public class Main {
	public static int N,M,R; // 높이 너비 횟수
	public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
//        for(int i = 0 ; i < N ; i++) {
//        	for(int j = 0 ; j < M ; j++) {
//        		System.out.print(arr[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        for(int i = 0 ; i < R ; i++) {
        	spin();
        }
//        System.out.println();
        for(int i = 0 ; i < N ; i++) {
        	for(int j = 0 ; j < M ; j++) {
        		System.out.print(arr[i][j] + " ");
        	}
        	System.out.println();
        }
        
        
    }
    
    public static void spin() {
    	Deque<Integer> deq = new ArrayDeque<>();
    	int tmp = 0;
    	int check = Math.min(M, N);
    	check = check / 2;
    	
    	for(int t = 0 ; t < check ; t++) {
        	for(int i = t ; i < N - 1 - t ; i++) {
        		deq.add(arr[i][t]);
        	}
        	for(int i = t ; i < M - 1 - t; i++) {
        		deq.add(arr[N-1 - t][i]);
        	}
        	for(int i = N - 1 - t ; i > t ; i--) {
        		deq.add(arr[i][M-1 - t]);
        	}
        	for(int i = M - 1 - t; i > t ; i--) {
        		deq.add(arr[t][i]);
        	}
        	
        	tmp = deq.pollLast();
        	deq.addFirst(tmp);
        	
        	for(int i = t ; i < N - 1 - t ; i++) {
        		arr[i][t] = deq.poll();
        	}
        	for(int i = t ; i < M - 1 - t; i++) {
        		arr[N-1 - t][i] = deq.poll();
        	}
        	for(int i = N - 1 - t ; i > t ; i--) {
        		arr[i][M-1 - t] = deq.poll();
        	}
        	for(int i = M - 1 - t ; i > t ; i--) {
        		arr[t][i] = deq.poll();
        	}
    	}
    	

    	
    }
}


/* 아이디어
 * 시작 시간으로 정렬하고
 * 시작 시작을 기준으로 for문 돌리면서 끝나는 시간을 큐에 넣음
 * peek를 해서 end가 start보다 작거나 같으면 poll
 * 위에 조건 이후 push 한다. 즉 마지막에 나오는 큐의 사이즈가 강의실 개수
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static List<int[]> pair = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        for(int i = 1 ; i < N + 1;  i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	pair.add(new int[] {start, end});
        }
        
        Collections.sort(pair, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a1, int[] a2) {
        		return Integer.compare(a1[0], a2[0]); // 시작 기준으로 정렬 
        	}
        });
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>(); // 리스트로 했다가 박음..
        
        for(int[] time :  pair) {
        	int start = time[0];
        	int end = time[1];
        	
        	if(!rooms.isEmpty() && rooms.peek() <= start) { // peek를 해서 end가 start보다 작거나 같으면 poll
        		rooms.poll();
        	}
        	
        	rooms.add(end);
        	
        }
        
        System.out.println(rooms.size());
        
        

    }
}

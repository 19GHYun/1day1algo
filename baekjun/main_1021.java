import java.util.*;
import java.io.*;


public class Main {
	public static Deque<Integer> q = new ArrayDeque<>();
	public static int N,M;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	for(int i = 1 ; i < N + 1 ; i++) {
    		q.add(i);
    	}
    	
    	Queue<Integer> q2 = new ArrayDeque<>();
    	
    	st = new StringTokenizer(br.readLine());
    	
    	for(int i = 0 ; i < M ; i++) {
    		q2.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	int pick_num = 0;
    	int answer = 0;
    	
    	while(!(pick_num == M)) {
    		if(q2.peek() == q.peek()) {
    			q2.poll();
    			q.poll();
    			pick_num++;
    		}
    		else {
    			int index = q.toArray().length - new ArrayList<>(q).indexOf(q2.peek()) - 1;
//    			System.out.println(index);
    			if(index < q.size() / 2) {
    				int tmp = q.pollLast();
    				q.addFirst(tmp);
    				answer++;
    			}
    			else{
    				int tmp = q.pollFirst();
    				q.addLast(tmp);
    				answer++;
    			}
    		}
//        	for(int a : q) {
//        		System.out.print(a + " ");
//        	}
//    		System.out.println();
    	}
    	System.out.println(answer);
    	

    	
    	
    }
    
    
}



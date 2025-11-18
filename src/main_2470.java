import java.io.*;
import java.util.*;

	public class Main {
		public static ArrayList<Integer> list = new ArrayList<>();
		public static int[] answer = new int[2];
		public static int check_num = Integer.MAX_VALUE;
		
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        
	        int N = Integer.parseInt(br.readLine());
	        
	        st = new StringTokenizer(br.readLine());
	        
	        for(int i = 0 ; i < N ; i++) {
	        	list.add(Integer.parseInt(st.nextToken()));
	        }
	        
	        Collections.sort(list);
	        
	        tp(0, N - 1);
	        
	        System.out.println(answer[0] + " " + answer[1]);
	        
	    }
	    
	    public static void tp(int start, int end) {
	    	if(start == end) {
	    		return;
	    	}
	    	
	    	int a = list.get(start) + list.get(end);
	    	
	    	if(a > 0) {
	    		if(check_num > a) {
	    			answer[0] = list.get(start);
	    			answer[1] = list.get(end);
	    			check_num = a;
	    		}
	    		
	    		tp(start,end - 1);
	    	}
	    	else if(a < 0) {
	    		a = a * -1;
	    		if(check_num > a) {
	    			answer[0] = list.get(start);
	    			answer[1] = list.get(end);
	    			check_num = a;
	    		}
	    		tp(start + 1, end);
	    	}
	    	else {
	    		answer[0] = list.get(start);
	    		answer[1] = list.get(end);
	    	}
	    	
	    }
	    
	}

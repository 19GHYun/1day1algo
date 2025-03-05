import java.io.*;
import java.util.*;

	public class Main {
		public static int[] arr;
		public static int[] answer = new int[2];
		public static int check_num = Integer.MAX_VALUE;
		
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        
	        int N = Integer.parseInt(br.readLine());
	        
	        arr = new int[N];
	        
	        st = new StringTokenizer(br.readLine());
	        
	        for(int i = 0 ; i < N ; i++) {
	        	arr[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        tp(0, N - 1);
	        
	        System.out.println(answer[0] + " " + answer[1]);
	        
	    }
	    
	    public static void tp(int start, int end) {
	    	if(start == end) {
	    		return;
	    	}
	    	
	    	int a = arr[start] + arr[end];
	    	
	    	if(a > 0) {
	    		if(check_num > a) {
	    			answer[0] = arr[start];
	    			answer[1] = arr[end];
	    			check_num = a;
	    		}
	    		
	    		tp(start,end - 1);
	    	}
	    	else if(a < 0) {
	    		a = a * -1;
	    		if(check_num > a) {
	    			answer[0] = arr[start];
	    			answer[1] = arr[end];
	    			check_num = a;
	    		}
	    		tp(start + 1, end);
	    	}
	    	else {
	    		answer[0] = arr[start];
	    		answer[1] = arr[end];
	    	}
	    	
	    }
	    
	}

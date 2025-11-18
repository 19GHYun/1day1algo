import java.io.*;
import java.util.*;

	public class Main {
		
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        
	        int N = Integer.parseInt(br.readLine());
	        
	        int[] arr = new int[N];
	        
	        st = new StringTokenizer(br.readLine());
	        
	        int end = Integer.MIN_VALUE;
	        
	        for(int i = 0 ; i <  N ; i++) {
	        	arr[i] = Integer.parseInt(st.nextToken());
	        	end = Math.max(end, arr[i]);
	        }
	        
	        int need_money = Integer.parseInt(br.readLine());
	        
	        int start = 1;
	        int mid = 0;
	        int answer = Integer.MIN_VALUE;
	        int get_money;
	        while(start <= end) {

	        	get_money = 0;
		        mid = (start + end) / 2;
	        	
		        
		        for(int i = 0 ; i < N ; i++) {
		        	if(arr[i] >= mid) {
		        		get_money += mid;
		        	}
		        	else {
		        		get_money += arr[i];
		        	}
		        }
		        if(get_money > need_money) {
		        	end = mid - 1;
		        }
		        else if(get_money <= need_money) {
		        	start = mid + 1;
		        	answer = Math.max(answer, mid);
		        }
		        
	        }
	        System.out.println(answer);

	    }
	    
	}

import java.io.*;
import java.util.*;
 
    public class Main {
        public static int N,S;
        public static int[] arr;
        public static int answer = Integer.MAX_VALUE;
        public static int local_sum = 0;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            
            arr = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            tp(0,0);
            
            if(answer == Integer.MAX_VALUE) {
            	System.out.println(0);
            }else {
            	System.out.println(answer);
            }
        
        }
        
        public static void tp(int start, int end) {
        	local_sum += arr[end];
        	while(true) {
        		if(start > end) {
        			return;
        		}
        		
        		if(local_sum < S) {
        			end +=1;
        			if(end == N) {
        				return;
        			}
        			local_sum += arr[end];
        		}
        		else if(local_sum >= S) {
        			answer = Math.min(answer, end - start + 1);
        			local_sum -= arr[start];
        			start += 1;

        		}

        	}
        	
        	
        	
        }
        
        
        
}



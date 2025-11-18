import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static boolean end = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        backt("", 0);
        
    }
    public static void backt(String b, int cnt) {
    	if(cnt == N && !end) {
    		System.out.println(b);
    		end = true;
    		return;
    	}
    	
    	if(!end) {
    		if(cnt == 0) {
    			backt("1", 1);
    			backt("2", 1);
    			backt("3", 1);
    			return;
    		}
    		else {
    			for(int i = 1 ; i <= 3 ; i++) {
    				boolean check = false;
    				String b_plus = b + i;
    				int b_size = b_plus.length();
    				for(int size = 1 ; size <= b_size / 2 ; size++) {
    					String left = b_plus.substring(b_size - size); //  왼쪽
    					String right = b_plus.substring(b_size - 2 * size, b_size - size);
    					if(left.equals(right)) {
    						check = true;
    						break;
    					}
    					
    				}
    				if(check) {
    					continue;
    				}
    				else {
    					backt(b_plus, cnt + 1);
    				}
    				
    			}
    			
    			
    		}
    		
    	}else {
    		return;
    	}
    	
    }
    
}

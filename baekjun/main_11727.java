import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	int[] answer = new int[1001];
    	
    	int divide = 10007;
    	
    	boolean plus = true;
    	answer[1] = 1;
    	
    	if(T == 1) {
    		System.out.println(1);
    		return;
    	}
    	
    	for(int i = 2 ; i <= T ; i++) {
    		if(plus) {
    			answer[i] = (answer[i-1] * 2 + 1) % divide;
    			plus = false;
    		}
    		else {
    			answer[i] = (answer[i-1] * 2 - 1) % divide;
    			plus = true;
    		}
    		
    		
    	}
    	
    	
    	System.out.println(answer[T] % divide);
    }
}

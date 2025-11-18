import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	long[] answer = new long[1001];
    	
    	answer[1] = 1;
    	answer[2] = 2;
    	
    	if(T < 2) {
    		System.out.println(answer[T]);
    		return;
    	}
    	
    	for(int i = 3 ; i <= T ; i++) {
    		answer[i] = answer[i-2] + answer[i-1];
    		answer[i] = answer[i] % 10007;
    	}
    	
    	
    	System.out.println(answer[T]);
    	
        
    }
}

import java.util.*;
import java.io.*;


public class Main {
	public static int N;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	int[] answer = new int[N+1];
    	
    	
    	for(int i = 2 ; i < N + 1 ; i++) {
    		answer[i] = answer[i-1] + 1;
    		if(i % 2 == 0) {
    			answer[i] = Math.min(answer[i], answer[i/2] + 1);
    		}
    		if(i % 3 == 0) {
    			answer[i] = Math.min(answer[i], answer[i/3] + 1);
    		}
    		

    	}
    	

    	

    	System.out.println(answer[N]);
    	
    }
    
}



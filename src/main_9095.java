import java.util.*;
import java.io.*;

public class Main {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < T ; i++) {
        	N = Integer.parseInt(br.readLine());
        	
        	int[] answer = new int[N + 1];
        	

        	if(N >= 4) {
            	answer[1] = 1;
            	answer[2] = 2;
            	answer[3] = 4;
            	for(int j = 4 ; j <= N ; j++) {
            		answer[j] += answer[j-1];
            		answer[j] += answer[j-2];
            		answer[j] += answer[j-3];
            		
            		
            	}
        	}else {
        		
        	}

        	

        	if(N == 1) {
        		System.out.println(1);
        	}
        	else if(N == 2) {
        		System.out.println(2);
        	}
        	else if(N == 3) {
        		System.out.println(4);
        	}else {
        		System.out.println(answer[N]);
        	}
        	
        	
        }

    }
}

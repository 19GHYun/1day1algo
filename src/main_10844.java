import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	long[][] answer = new long[101][10];
    	
    	int divide = 1000000000;
    	
    	answer[0][0] = 0;
    	for(int i = 1 ; i <= 9 ; i++) {
    		answer[0][i] = 1;
    	}
    	
    	for(int i = 1 ; i < T ; i++) {
    		answer[i][0] = answer[i-1][1] % divide;
    		answer[i][9] = answer[i-1][8] % divide;
    		for(int j = 1 ; j < 9 ; j++) {
    			answer[i][j] = (answer[i-1][j-1] + answer[i-1][j+1]) % divide;
    		}
    	}
        
    	long result = 0;
    	
    	for(int i = 0 ; i <= 9 ; i++) {
    		result += answer[T-1][i] % divide;
    	}
    	
    	System.out.println(result % divide);
    }
}

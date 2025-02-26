import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	long[][] answer = new long[1001][10];
    	
    	int divide = 10007;
    	
    	for(int i = 0 ; i <= 9 ; i++) {
    		answer[0][i] = 1;
    	}
    	
    	for(int i = 1 ; i < T ; i++) {
    		for(int j = 0 ; j <= 9 ; j++) {
    			for(int p = 0 ; p <= j ; p++) {
    				answer[i][j] += answer[i-1][p] % divide;
    			}
    		}
    	}
        
    	long result = 0;
    	
    	for(int i = 0 ; i <= 9 ; i++) {
    		result += answer[T-1][i] % divide;
    	}
    	
    	System.out.println(result % divide);
    }
}

import java.util.*;
import java.io.*;

public class Main {

		public static int N, K;
		public static int[] arr;
		public static int answer = Integer.MAX_VALUE;
		
	    public static void main(String[] args) throws IOException {
	    
	    	Scanner sc = new Scanner(System.in);
	    	int a3;
	    	int N = sc.nextInt();
	    	
	    	if(N == 0) {
	    		System.out.println(0);
	    		return;
	    	}
	    	else if(N == 2 || N == 1) {
	    		System.out.println(1);
	    		return;
	    	}
	    	else {
	    		int a1 = 0; int a2 = 1; a3 = 1;
	    		for(int i = 2 ; i <= N ; i++) {
	    			a3 = a1 + a2;
	    			a1 = a2;
	    			a2 = a3;
	    			
	    		}
	    	}
	    	System.out.println(a3);
	    	

	    }

	   
	    
}   


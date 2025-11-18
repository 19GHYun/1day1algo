import java.util.*;
import java.io.*;

public class Main {


	    public static void main(String[] args) throws IOException {
	    	
	    	Scanner sc = new Scanner(System.in);
	    	
	    	int N = sc.nextInt();

	    	for(int i = 0 ; i < N ; i++) {
	    		int c = sc.nextInt();
	    		int d = sc.nextInt();
	    		
	    		System.out.println(def(d-c));
	    		
	    	}
	    


	 }
	    
	    public static int def(int a) {
	    	
	    	int check = 1;
	    	int answer = 0;
	    	boolean check2 = false;
	    	
	    	while(!check2) {
	    		for(int i = 0 ; i < 2; i++) {
	    			if(a <= 0) {
	    				check2 = true;
	    				break;
	    			}
	    			a = a - check;
	    			answer++;

	    		}
	    		check++;
	    	}
	    	
	    	
	    	
	    	return answer;
	    }
}

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	
//    	Stack<String> maeda = new Stack<>();
//    	Stack<String> gouto = new Stack<>();
    	
    	int maeda = 0;
    	int gouto = 0;
    	
    	String a;
    	
    	boolean check = false;
    	boolean check2 = true;
    	
    	for(int i = 0 ; i < N ; i++) {
    		a = sc.next();
    		switch(a) {
    		case"A":
    			maeda++;
    			break;
    		case"Un":
    			gouto++;
    			break;
    		}
    		
    		if(maeda < gouto) {
    			check2 = false;
    			break;
    		}
    		

    	
    		
    	}
    	
		if(maeda == gouto && check2) {
			check = true;
		}
    	
    	System.out.print(check ? "YES" : "NO");
        
    }
    
}

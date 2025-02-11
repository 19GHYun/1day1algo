import java.util.*;
import java.io.*;

public class Main {

	static int time = 0;
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();

    	int[] arr;
    	
    	for(int i = 1 ; i < N + 1 ; i++) {
    		int answer = 0;
    		int num1 = 0;
    		int num2 = 0;
    		int M = sc.nextInt();
    		arr = new int[M];
    		int maxnum = 0;
    		for(int k = 0; k < M ; k++) {
    			arr[k] = sc.nextInt();
    			if(maxnum < arr[k]) {
    				maxnum = arr[k];
    			}
    		}
    		
    		for(int k = 0 ; k < M ; k++) {
    			arr[k] = maxnum - arr[k];
    			num2 += arr[k] / 2;
    			num1 += arr[k] % 2;
    		}
    		
    		while(num2 >= num1 + 2 ) {
    			num2--;
    			num1+=2;
    		}
    		
    		while(num2 != 0 && num1 != 0) {
    			num2--;
    			num1--;
    			answer+=2;
    		}
    		if(num1 > 0) {
    			answer = answer + num1 * 2 - 1;
    			num1 = 0;
    		}
    		if(num2 > 0) {
    			answer += 2;
    			num2--;
    		}
    		
    		System.out.println("#" + i + " " +answer);
    		
//    		for(int a : arr) {
//    			System.out.print(a+ " ");
//    		}
    		
    		
    	}
    	
    	sc.close();
        
    	
        
    }
    
}

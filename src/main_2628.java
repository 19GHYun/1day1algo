import java.util.*;
import java.io.*;

public class Main {

	static int time = 0;
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	
    	int X = sc.nextInt();
    	int Y = sc.nextInt();
    	
    	int N = sc.nextInt();
    	
    	
    	int[] x_cut = new int[N+1];
    	
    	int[] y_cut = new int[N+1];
    	
    	int x_count = 0;
    	int y_count = 0;
    	
    	for(int i = 0 ; i < N ; i ++) {
    		int check = sc.nextInt();
    		
    		switch(check) {
    		case(0):
    			y_cut[y_count]=sc.nextInt();
    			y_count++;
    			break;
    		case(1):
    			x_cut[x_count]=sc.nextInt();
    			x_count++;
    			break;
    		}
    	}
    	  	int real_x = size_long(X, x_cut);
    	  	int real_y = size_long(Y, y_cut);
    	  	
    	  	System.out.print(real_x * real_y);
    		
    	sc.close();
        
    }
    
    public static int size_long(int x, int[] arr) {
    	int i = 0;
    	boolean check = true;
    	int[] a = new int[x];
    	while(check) {
    		
    		a[arr[i]] = 1;
    		
    		
    		if(arr[i]==0) {
    			check=false;
    		}
    		i++;
    		
    	}
    	int max_length = 0;
    	int count = 0;
    	for(int b = 0 ; b < a.length ; b++) {
    		if(a[b] == 0) {
    			count++;
    		}else {
    			count = 0;
    		}
			if(max_length < count) {
				max_length = count;
			}
    	}
    	return max_length + 1;
    	
    }
    
}

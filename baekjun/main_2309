import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int dth = 0;
    static boolean check = false;
    static boolean[] picked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new int[9];
        picked = new boolean[9];
        
        for(int i = 0 ; i < 9 ; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	
        }
        
        int[] check = new int[10];
        for (int i = 0; i < check.length; i++) {
            check[i] = -100;
        }
        dfs(check, dth);
        
//        for(int i = 0 ; i < 9 ; i++) {
//        	System.out.print(arr[i]);
//        }
        

        

    }
    
    public static void dfs(int array[], int dth) {
    	if(dth == 7) {
    		int answer = 0;
    		for(int i = 0 ; i < dth ; i++) {
    			answer += array[i];
    		}
    		if((answer == 100) && (check == false)) {
    			Arrays.sort(array);
    			for(int i = 3 ; i < dth+3 ; i++) {
    				System.out.println(array[i]);
    			}
    			check = true;
    		}
    	}
    	else {
    		for(int i = dth ; i < arr.length ; i++) {
    			if(!picked[i]) {
	    			picked[i] = true;
	    			array[dth] = arr[i];
	    			dfs(array, dth +1);
	    			picked[i] = false;
	    			array[dth] = -1000;
    			}
    		}
    	}
    	
    	
    }


}

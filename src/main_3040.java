
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static int[] arr;
	public static boolean[] check = new boolean[9];
	public static List<Integer> list = new ArrayList<>();
	public static boolean check2 = false;
	
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	
    	arr = new int[9];
    	
    	for(int i = 0 ; i < 9 ; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	backt(0);
    	
    	
//    	for(int a : arr) {
//    		System.out.println(a);
//    	}
    	
    	

    }
    
    public static void backt(int cnt) {
    	if(!check2) {
        	if(cnt == 7) {
        		int sum = 0;
        		for(int i = 0 ; i < 7 ; i++) {
        			sum += list.get(i);
        		}
        		if(sum == 100) {
        			StringBuilder sb = new StringBuilder();
        			check2 = true;
        			for(int i = 0 ; i < 7 ; i++) {
        				sb.append(list.get(i));
        				sb.append("\n");
        			}
        			System.out.println(sb.toString());
        		}
        		
        		return;
        	}
        	
        	for(int i = 0 ; i < 9 ; i++) {
        		if(!check[i]) {
        			check[i] = true;
        			list.add(arr[i]);
        			backt(cnt + 1);
        			check[i] = false;
        			list.remove(list.size() - 1);
        		}
        	}
    	}

    	
    }
    
}



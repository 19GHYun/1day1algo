import java.util.*;

import javax.swing.ListModel;

import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        
        for(int i = 1 ; i < N ; i++) {
        	if(arr[i] > list.get(list.size()-1)) {
        		list.add(arr[i]);
        	}
        	else {
        		int index = bs(list, arr[i]);
        		list.set(index, arr[i]);
        	}
        	
        }
        
        System.out.println(list.size());
        
    }
    
    public static int bs(ArrayList<Integer>list ,int num) {
    	int left = 0;
    	int right = list.size();
    	
    	while(left<=right) {
    		int mid =(left + right) / 2;
    		
    		if(list.get(mid) < num) {
    			left = mid + 1;
    		}
    		else {
    			right = mid - 1;
    		}
    		
    	}
    	
    	
    	
    	return left;
    }
    
}

import java.util.*;

import javax.swing.ListModel;

import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        int[] prev = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        
        Arrays.fill(prev, -1);
        
        list.add(arr[0]);
        pos.add(0);
        prev[0] = -1;
        
        for(int i = 1 ; i < N ; i++) {
        	if(arr[i] > list.get(list.size()-1)) {
        		prev[i] = pos.get(list.size() - 1);
        		list.add(arr[i]);
        		pos.add(i);
        	}
        	else {
        		int index = bs(list, arr[i]);
        		if(index > 0) {
        			prev[i] = pos.get(index - 1);
        		}else {
        			prev[i] = -1;
        		}
        		list.set(index, arr[i]);
        		pos.set(index, i);
        	}
        	
        }
        
        int length = list.size();
        System.out.println(length);
        
        Stack<Integer> stack = new Stack<>();
        int current = pos.get(length - 1);
        
        while(current != -1) {
        	stack.push(arr[current]);
        	current = prev[current];
        
        }
        
        while(!stack.isEmpty()) {
        	sb.append(stack.pop()).append(" ");
        }
        
        System.out.println(sb);
    }
    
    public static int bs(ArrayList<Integer>list ,int num) {
    	int left = 0;
    	int right = list.size();
    	
    	while(left < right) {
    		int mid =(left + right) / 2;
    		
    		if(list.get(mid) < num) {
    			left = mid + 1;
    		}
    		else {
    			right = mid;
    		}
    		
    	}

    	return left;
    }
    
}

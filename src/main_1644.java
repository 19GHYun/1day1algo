import java.io.*;
import java.util.*;

public class Main {
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        boolean[] check = new boolean[N + 1];
        
        check[1] = true;
        for(int i = 2 ; i < N + 1 ; i++) {
        	if(!check[i]) {
        		for(int j = 2 ; j <= N / i ; j++) {
        			if(!check[j*i]) {
        				check[j*i] = true;
        			}
        		}
        	}
        	else {
        		continue;
        	}
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 1 ; i < N + 1 ; i++) {
        	if(!check[i]) {
        		list.add(i);
        	}
        }
        
//        for(int a : list) {
//        	System.out.print(a + " ");
//        }
//        
        int start = 0;
        int end = 0;
        int answer = 0;
        
        while(true) {
        	int a = 0;
        	if(start > list.size() - 1) {
        		break;
        	}
        	if(end > list.size() - 1) {
        		break;
        	}
        	
        	for(int i = start ; i <= end ; i++) {
        		a += list.get(i);
        	}
        	
        	if(a < N) {
        		end++;
        	}
        	else if(a > N) {
        		start++;
        	}
        	else if( a == N) {
        		answer++;
        		if(end == list.get(list.size() - 1)) {
        			start++;
        		}else {
        			end++;
        		}
        	}

        	
        }
        
        System.out.println(answer);

    }


    
}

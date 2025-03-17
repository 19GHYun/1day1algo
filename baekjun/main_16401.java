import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        int end = 0;
        
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	end = Math.max(end, arr[i]);
        }
        boolean check = false;
        int start = 1;
        int mid = 0;
        int answer = 0;
        while(start <= end) {
        	mid = (start + end) / 2;
        	
        	int snack = 0;
        	
        	for(int i = 0 ; i < N ; i++) {
        		snack += (arr[i] / mid);
        	}
        	
        	if(snack >= M) {
        		answer = mid;
        		start = mid + 1;
        	}
        	else {
        		end = mid - 1;
        	}
        	
        }

            System.out.println(answer);


        
    }
}

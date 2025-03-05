import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] arr;
	public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i < N ; i++) {
        	tp(0,N-1,i);
        }
        
        System.out.println(answer);
        
        
    }
    
    public static void tp(int start, int end, int gojung) {
    	if(start == end) {
    		return;
    	}
    	if(start == gojung) {
    		tp(start + 1, end, gojung);
    		return;
    	}
    	if( end == gojung) {
    		tp(start, end - 1, gojung);
    		return;
    	}
    	
    	int a = arr[start] + arr[end];
    	
    	if(a > arr[gojung]) {
    		tp(start,end-1,gojung);
    	}
    	else if(a < arr[gojung]) {
    		tp(start+1,end,gojung);
    	}
    	else if(a == arr[gojung]) {
    		answer++;
    		return;
    	}
    	
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static int[][] arr;
    public static boolean[] check;
    public static int size = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1][N+1];
        check = new boolean[N+1];
        
        for(int i = 1  ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	int a3 = Integer.parseInt(st.nextToken());
        	
        	arr[a1][a2] = a3;
        	arr[a2][a1] = a3;
        }
        
//        for(int i = 1 ; i < N + 1  ; i++) {
//        	for(int j = 1 ; j < N + 1 ; j++) {
//        		System.out.print(arr[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	size = 0;
        	int a4 = Integer.parseInt(st.nextToken());
        	int a5 = Integer.parseInt(st.nextToken());
        	check[a4] =true;
        	dfs(a4 ,a5 );
        	check[a4] = false;
        }
        

        
    }
    
    
    public static void dfs(int start, int end) {
    	
    	if(start == end) {
    		System.out.println(size);
    		return;
    	}
    	for(int i = 1 ; i < N + 1 ; i++) {
    		if(arr[start][i] > 0 && !check[i] ) {
    			size += arr[start][i];
    			check[i] = true;
    			dfs(i,end);
    			size -= arr[start][i];
    			check[i] = false;
    		}
    		
    		
    	}
    }
    
}

import java.io.*;
import java.util.*;


public class Main {
    public static int N, M;
    public static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        arr = new int[N+1][N+1];
        
        for(int[] a : arr) {
        	Arrays.fill(a, Integer.MAX_VALUE);
        }
        for(int i = 1 ; i <= N ; i++) {
        	arr[i][i] = 0;
        }
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	int a3 = Integer.parseInt(st.nextToken());        	
        	
        	arr[a1][a2] = Math.min(arr[a1][a2], a3); // ;; 여길 이렇게 해야하노
        	
        }
        
        for(int k = 1 ; k <= N ; k++) { // 중간
        	for(int i = 1 ; i <= N ; i++) { // 처음
        		for(int j = 1 ; j <= N ; j++) { // 끝
        			if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
        				arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
        			}
        		}
        	}
        }
        
        for(int i = 1 ; i <= N ; i++) {
        	for(int j = 1 ; j <= N ; j++) {
        		if(arr[i][j] == Integer.MAX_VALUE) {
        			sb.append(0).append(" ");
        		}
        		else {
        			sb.append(arr[i][j]).append(" ");
        		}
        		
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
    
}

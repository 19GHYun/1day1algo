import java.io.*;
import java.util.*;


public class Main {
    public static int N, M;
    public static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
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
        	
        	arr[a1][a2] = a3;
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
        
//        for(int i = 1 ; i<= N ; i++) {
//        	for(int j = 1 ; j<= N ; j++) {
//        		System.out.print(arr[i][j] + " ");
//        	}
//        	System.out.println();
//        }

        long answer = Integer.MAX_VALUE;
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(i != j && arr[i][j] != Integer.MAX_VALUE && arr[j][i] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }
        
        if(answer >= Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }

        
    }
    
}

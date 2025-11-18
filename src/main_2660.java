import java.io.*;
import java.util.*;


public class Main {
    public static int N;
    public static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+1][N+1];
        
        for(int[] a : arr) {
        	Arrays.fill(a, Integer.MAX_VALUE);
        }
        for(int i = 1 ; i <= N ; i++) {
        	arr[i][i] = 0;
        }
        
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	
        	if(a1 == -1 && a2 == -1) {
        		break;
        	}
        	
        	arr[a1][a2] = 1;
        	arr[a2][a1] = 1;
        	
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
        
        int final_answer = Integer.MAX_VALUE;
        
        for(int i = 1 ; i <= N ; i++) {
        	int local_answer = 0;
        	for(int j = 1 ; j <= N ; j++) {
        		if(arr[i][j] > local_answer) {
        			local_answer = arr[i][j];
        		}
        	}
        	final_answer = Math.min(final_answer, local_answer);
        }
        int num = 0;
        
        for(int i = 1 ; i <= N ; i++) {
        	int local_max = 0;
        	for(int j = 1 ; j <= N ; j++) {
        		if(arr[i][j] > local_max) {
        			local_max = arr[i][j];
        		}
        	}
        	if(local_max == final_answer) {
        		num++;
        		sb.append(i).append(" ");
        	}
        }
        
        System.out.println(final_answer + " " + num);
        System.out.println(sb);
        
    }
    
}

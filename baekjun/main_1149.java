import java.util.*;
import java.io.*;

/*
 * 바텀 - 탑 방식으로 하면 안됨.
 * 탑 - 바텀 방식으로 해야됨.
 * 이미 도달한 결과에 대해, 다른 두개의 뒤에 집에 대해 싼곳을 골라서 price를 더하는게 최소가 됨.
 * 
 */


public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	int[][] price = new int[T][3];
    	StringTokenizer st;
    	for(int i = 0 ; i < T ; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0 ; j < 3 ; j++) {
    			price[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[][] answer = new int[1001][3];
    	int j = 0;
    	for(int i = 1 ; i <= T ; i++) {
    		answer[i][0] = Math.min(answer[i-1][1], answer[i-1][2]) + price[i-1][0];
    		answer[i][1] = Math.min(answer[i-1][0], answer[i-1][2]) + price[i-1][1];
    		answer[i][2] = Math.min(answer[i-1][1], answer[i-1][0]) + price[i-1][2];

    	}
    	
    	int result = Integer.MAX_VALUE;
    	
    	for(int i = 0 ; i < 3 ; i++) {
    		result = Math.min(result, answer[T][i]);
    	}
    	System.out.println(result);
    }
}

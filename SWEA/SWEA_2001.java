import java.util.*;
import java.io.*;

/* 메모리 26,880kb, 158ms
 * 누적합을 잘 몰라서 5중 포문이라는 미친 짓을 하여 작성하였습니다.
 * 
 * check1, check2 를 이용해서 M과 같이 사용해 가변적으로 파리채의 크기를 조절하였습니다.
 * 
 */
public class Solution {
	public static int T,N,M; // 테스트케이스,가로세로 길이, 파리채 크기
	public static int[][] arr;	//전역 아니여도 되지만, 파리 매달려있는곳

    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	T = sc.nextInt();
    	
    	for(int i = 1 ; i < T + 1; i++) {
    		int max = Integer.MIN_VALUE;
    		
    		N = sc.nextInt();
    		M = sc.nextInt();
    		
    		arr = new int[N][N];	//파리생성	
    		for(int j = 0 ; j < N ; j++) {
    			for(int p = 0 ; p < N ; p++) {
    				arr[j][p] = sc.nextInt(); //파리 사이즈 넣어버리고
    			}
    		}
    		
    		int ans = 0; // 파리 다 잡고 += 하는 변수
    		int check1 = 0; // 가로세로 범위 정하는 변수
    		int check2 = 0;
    		for(int w = 0 ; w <= N - M ; w++) { 
	    		for(int q = 0 ; q <= N - M ; q++) {
	    			ans = 0;
	        		for(int j = check1 ; j < M + check1 ; j++) {
	        			for(int p = check2 ; p < M + check2 ; p++) {
	        				ans += arr[j][p];
	        			}
	
	        		}
	        		if(max < ans) {
	        			max = ans;
	        		}
	    			if(check2 < N - M) {
	    				check2++;
	    			}
	
	        		}
	    		if(check1 < N - M) {
	    			check1++;
	    		}
	    		check2 = 0;
    		}
    		
    		System.out.println("#" + i + " " + max);
    	} 	
    	
    }
    
    
}

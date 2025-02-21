import java.util.*;
import java.io.*;
/*
 * 26624kb, 99ms 
 * 그냥 재귀문제인거 같습니다. 쉬운편 문제였습니다.
 * 
 * 
 */
public class Solution {
	
	public static int[] asd;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	
    	
    	for(int i = 1 ; i < 11 ; i++) {
    		int T = Integer.parseInt(br.readLine());	//왜 받는지 이해가 안되는 것
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		asd = new int[8]; 
    		
    		for(int q = 0 ; q < 8 ; q++) {
    			asd[q] = Integer.parseInt(st.nextToken());
    		}
    		
    		secret();
    		
    		System.out.print("#" + i+ " " );
    		for(int a : asd) {
    			System.out.print(a + " ");
    		}
    		System.out.println();
    	}
    	
    	
    	
    }
    
    public static void secret() {
    	int tmp;
    	for(int i = 1 ; i < 6 ; i++) {

    		
    		tmp = asd[0] - i;
    		
    		if(tmp < 0) {
    			tmp = 0;
    		}
    		asd[0] = asd[1]; // ㅋㅋ 레전드
    		asd[1] = asd[2];
    		asd[2] = asd[3];
    		asd[3] = asd[4];
    		asd[4] = asd[5];
    		asd[5] = asd[6];
    		asd[6] = asd[7];
    		
    		asd[7] = tmp;
    		
    		if(asd[7] == 0) {
    			return;
    		}
    	}
    	

			secret();
		
    }
    

}

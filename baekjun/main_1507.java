import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][N];
        int[][] arr2 = new int[N][N];
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int ii = 0 ; ii < N ; ii++) {
        		int a = Integer.parseInt(st.nextToken());
        		arr[i][ii] = a;
        		arr2[i][ii] = a;
        	}
        }
                
        for(int i = 0 ; i < N ; i++) {
        	for(int ii = 0 ; ii < N ; ii++) {
        		for(int iii = 0 ; iii < N ; iii++) {
        			if(i == ii || ii == iii || iii == i) continue;
        			
        			if(arr2[ii][iii] > arr2[ii][i] + arr2[i][iii]) {
        				System.out.println(-1);
        				return;
        			}
        			
        			if(arr2[ii][iii] == (arr2[ii][i] + arr2[i][iii])) {
        				arr[ii][iii] = 0;
        			}

        			
        		}
        	}
        }
        

        
        int a = 0;
        
        for(int i = 0 ; i < N ; i++) {
        	for(int ii = 0 ; ii < N ; ii++) {
        		a += arr[i][ii];
        	}
        }
        
        System.out.println(a/2);
        
    }

}


import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, R;
    public static int[][] map; 
    public static int[] arr; 
    public static int answer = 0;
    public static int longsize = 1000000000; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 수색 범위
        R = Integer.parseInt(st.nextToken()); // 길 개수
        
        map = new int[N+1][N+1];
        arr = new int[N+1];
        
        for(int i = 1 ; i <= N ; i++) {
        	for(int j = 1 ; j <= N ; j++) {
        		if(i == j) {
        			map[i][j] = 0;
        		}
        		else {
            		map[i][j] = longsize;
        		}

        	}
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= R ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	int a3 = Integer.parseInt(st.nextToken());
        	
        	map[a1][a2] = a3;
        	map[a2][a1] = a3;
        	  	
        }
        
        for(int i = 1 ; i <= N ; i++) {
        	for(int j = 1 ; j <= N ; j++) {
        		for(int k = 1 ; k <= N ; k++) {
        			if(map[j][i] != longsize && map[i][k] != longsize) {
        				map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
        			}
        		}
        	}
        }
        
//        for(int i = 1 ; i <= N ; i++) {
//        	for(int j = 1 ; j <= N ; j++) {
//        		System.out.print(map[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        
        for(int i = 1 ; i <= N ; i++) {
        	int local_answer = 0;
        	for(int j = 1 ; j <= N ; j++) {
        		if(map[i][j] <= M) {
        			local_answer += arr[j];
        		}
        	}
        	answer = Math.max(answer, local_answer);
        }
        System.out.println(answer);

 
    }
}

import java.util.*;
import java.io.*;

public class Main {
	public static int N,M;
	public static int[][] arr;
	public static boolean[][] check;
	public static boolean[][] check2;
	public static int answer = 0;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        check = new boolean[N][M];
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		int a = Integer.parseInt(st.nextToken());
        		
        		if(a == 1) {
        			arr[i][j] = 2;
        			check[i][j] = true;
        		}
        		else {
        			arr[i][j] = 0;
        		}
        		
        	}
        }
        
//        for(int i = 0 ; i < N ; i++) {
//        	for(int j = 0 ; j < M ; j++) {
//        		System.out.print(arr[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        check2 = new boolean[N][M];
        while(!melt()) {
            for(int i = 0 ; i < N ; i++) {
                check2 = check.clone();
            }
            answer++;
            dfs(0,0);
            recovery();
        }
        System.out.println(answer);
        

        
    }

    public static void dfs(int x, int y) {
    	check2[x][y] = true;

    	for(int i = 0 ; i < 4 ; i++) {
    		int new_x = x + dx[i];
    		int new_y = y + dy[i];
    		
    		if(new_x>=0 && new_x < N && new_y >= 0 && new_y < M) {
    			if(arr[new_x][new_y] == 0 && !check2[new_x][new_y]) {
    				dfs(new_x,new_y);
    			}
    			else if(arr[new_x][new_y] > 0) {
    				arr[new_x][new_y]--;
    			}
    			
    		}
    		
    	}
    }
    public static boolean melt() {
    	for(int i = 0 ; i < N ; i++) {
    		for(int j = 0 ; j < M ; j++) {
    			if(arr[i][j] == 2) {
    				return false; // 안녹은거 있으면

    			}
    		}
    	}
    	return true; // 다녹음

    }
    public static void recovery() {
    	for(int i = 0 ; i < N ; i++) {
    		for(int j = 0 ; j < M ; j++) {
    			if(arr[i][j] > 0) {
    				arr[i][j] = 2; // 덜녹은거 복구
    			}else {
    				check[i][j] = false; // 다 녹은곳은 false
    			}
    		}
    	}
    }


}

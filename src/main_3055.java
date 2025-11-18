import java.io.*;
import java.util.*;

public class Main {
    public static int R,C;
    public static char[][] arr;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static boolean[][] check;
    public static int viver_x;
    public static int viver_y;
    public static int end_x;
    public static int end_y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new char[R][C];
        check = new boolean[R][C];
        
        for(int i = 0 ; i < R ; i++) {
        	String a = br.readLine();
        	for(int j = 0 ; j < C ; j++) {
        		arr[i][j] = a.charAt(j);
        		if(arr[i][j] == 'S') {
        			viver_x = i;
        			viver_y = j;
        		}
        		else if(arr[i][j] == 'D') {
        			end_x = i;
        			end_y = j;
        		}
        		else if(arr[i][j] == '*') {
        			check[i][j] = true;
        		}
        	}
        }
        
        bfs();
        
    }
    
    public static void bfs() {
    	int cnt = 0;
    	boolean end = false;
    	Queue<int[]> que = new ArrayDeque<>();
    	que.add(new int[] {viver_x, viver_y});
    	check[viver_x][viver_y] = true;
    	while(!que.isEmpty()) {
    		int size = que.size();
    		water();
    		for(int p = 0 ; p < size ; p++) {
        		int[] where = que.poll();
        		int x = where[0];
        		int y = where[1];
        		
        		
        		if(x == end_x && y == end_y) {
        			System.out.println(cnt);
        			end = true;
        			return;
        		}
        		
        		for(int i = 0 ; i < 4 ; i++) {
        			int new_x = x + dx[i];
        			int new_y = y + dy[i];
        			if(new_x >=0 && new_x < R && new_y >=0 && new_y < C) {
        				if(arr[new_x][new_y] == 'D' || arr[new_x][new_y] == '.' && !check[new_x][new_y]) {
        					que.add(new int[] {new_x, new_y});
        					check[new_x][new_y] = true;
        				}
        			}
        		}
    		}

    		cnt++;
    		w_t_w();
    		
    	}
    	if(!end) {
    		System.out.println("KAKTUS");
    	}
    }
    public static void water() { // 물 이동할곳을 체크
    	for(int i = 0 ; i < R ; i++) {
    		for(int j = 0 ; j < C ; j++) {
    			if(arr[i][j] == '*') {
    				for(int p = 0 ; p < 4 ; p++) {
    					int new_x = i + dx[p];
    					int new_y = j + dy[p];
    					if(new_x >=0 && new_x < R && new_y >=0 && new_y < C) {
    						if(arr[new_x][new_y] == '.') {
    							arr[new_x][new_y] = '+';
    						}
    						
    					}
    				}
    			}
    		}
    	}
    }
    
    public static void w_t_w() {
    	for(int i = 0 ; i < R ; i++) {
    		for(int j = 0 ; j < C ; j++) {
    			if(arr[i][j] == '+') {
    				arr[i][j] = '*';
    			}
    		}
    	}
    }
    
    
}

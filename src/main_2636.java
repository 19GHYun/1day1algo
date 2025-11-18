import java.io.*;
import java.util.*;

    public class Main {
    	public static int N,M;
    	public static int[][] arr;
    	public static boolean[][] check;
    	public static int time = 0;
    	public static int answer = 0;
    	public static int[] dx = {1,-1,0,0};
    	public static int[] dy = {0,0,1,-1};


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            arr = new int[N][M];
            check = new boolean[N][M];
            
            for(int i = 0 ; i < N ; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0 ; j < M ; j++) {
            		arr[i][j] = Integer.parseInt(st.nextToken());
            		if(arr[i][j] == 1) {
            			answer++;
            		}
            	}
            }
            
            
            for(int i = 0 ; i < N ; i++) {
            	for(int j = 0 ; j < M ; j++) {
            		if(arr[i][j] == 0) {

            		}
            	}
            }
            
            int pre_answer = 0;
            
            while(!melt()) {
            	pre_answer = answer;
            	bfs(0,0);
            	time++;
            	for(int i = 0 ; i < N ; i++) {
            		Arrays.fill(check[i], false);
            	}
            	
            }
            System.out.println(time);
            System.out.println(pre_answer);

            
        }
        
        public static void bfs(int x,int y) {
        	Queue<int[]> que = new ArrayDeque<>();
        	que.add(new int[] {x,y});
        	check[x][y] = true;
        	while(!que.isEmpty()) {
        		int[] where = que.poll();
        		
        		for(int i = 0 ; i < 4 ; i++) {
        			int new_x = where[0] + dx[i];
        			int new_y = where[1] + dy[i];
        			if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
        				if(arr[new_x][new_y] == 1 && !check[new_x][new_y]) {
        					arr[new_x][new_y] = 0;
        					answer--;
        					check[new_x][new_y] = true;
        				}
        				else if(arr[new_x][new_y] == 0 && !check[new_x][new_y]) {
        					que.add(new int[] {new_x, new_y});
        					check[new_x][new_y] = true;
        				}
        				
        			}
        			
        		}
        	}
        	
        }
        
        public static boolean melt() {
        	for(int i = 0 ; i < N ; i++) {
        		for(int j = 0 ; j < M ; j++) {
        			if(arr[i][j] == 1) {
        				return false;
        			}
        		}
        	}
        	
        	
        	return true;
        }
        

}

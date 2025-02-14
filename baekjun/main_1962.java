import java.util.*;
import java.io.*;

public class Main {
        public static int W;
        public static int H;
        public static boolean[][] check;
        public static Queue<int[] > q = new LinkedList<>();
        public static int[][] dohwaji;
        public static int gaetsu = 0;
        public static int picture_size = 0;
        public static int[] dx = { 1, -1, 0, 0};
        public static int[] dy = { 0, 0, 1, -1};

        public static void main(String[] args) throws IOException {
        	
        	Scanner sc = new Scanner(System.in);
        	
        	H = sc.nextInt();
        	W = sc.nextInt();
        	
        	dohwaji = new int[H + 1][W + 1];
        	check = new boolean[H + 1][W + 1];
        	
        	for(int i = 1 ; i < H + 1 ; i++) {
        		for(int j = 1 ; j < W + 1 ; j++) {
        			dohwaji[i][j] = sc.nextInt();
        		}
        		
        	}
        	bfs();
        	
        	System.out.println(gaetsu);
        	System.out.println(picture_size);
        	
        	
        	
        }
        
        public static void bfs() {
        	for(int i = 1 ; i < H + 1 ; i++) {
        		for(int j = 1 ; j < W + 1 ; j++) {
        			if(dohwaji[i][j] == 1 && !check[i][j]) {
        				int size = 0;
        				check[i][j] = true;
        				q.add(new int[] {i , j});
        				gaetsu++;
        				while(!q.isEmpty()) {
        					int[] where = q.poll();
        					int start_x = where[0];
        					int start_y = where[1];
        					size++;
        					
        					for(int p = 0 ; p < 4; p++) {
        						int new_x = start_x + dx[p];
        						int new_y = start_y + dy[p];
        						if(new_x >= 1 && new_x <= H && new_y >= 1 && new_y <= W) {
        							if(dohwaji[new_x][new_y] == 1 && !check[new_x][new_y]) {
        								q.add(new int[] {new_x , new_y});
        								check[new_x][new_y] = true;
        							}
        						}
        						else {
        							continue;
        						}
        					}
        					if(picture_size < size) {
        						picture_size = size;
        					}
        				}
        			}
        		}
        	}
        }

}

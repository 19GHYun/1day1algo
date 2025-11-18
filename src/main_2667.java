import java.util.*;
import java.io.*;

public class Main {
		public static int HW; //왼쪽부터 높이 너비 개수 폭발범위 폭발번호
		public static Queue<int[] > q = new LinkedList<>();
		public static int[] dx = { 1, -1, 0, 0};
		public static int[] dy = { 0, 0, 1, -1};
		public static boolean[][] check;
		public static int[][] arr;
		public static int[] cnt;
		public static int cnt_check = 0;
		
	    public static void main(String[] args) throws IOException {
	    
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	StringTokenizer st;
	    	
	    	HW = Integer.parseInt(br.readLine());
	    	
	    	String a = null;
	    	
	    	arr = new int[HW][HW];
	    	cnt = new int[HW * HW];
	    	check = new boolean[HW][HW];
	    	
	    	for(int i = 0 ; i < HW ; i++) {
	    		a = br.readLine();

	    		for(int j = 0 ; j < a.length() ; j++) {
	    			arr[i][j] = a.charAt(j) - 48;
	    		}
	    	}
	    	
	    	bfs();
	    	
	    	System.out.println(cnt_check);
	    	
	    	List<Integer> answer = new ArrayList<>();
	    	
	    	for(int i = 0 ; i < cnt.length ; i++) {
	    		if( cnt[i] > 0) {
	    			answer.add(cnt[i]);
	    		}
	    	}
	    	
	    	Collections.sort(answer);
	    	
	    	for(int b : answer) {
	    		System.out.println(b);
	    	}
	    	
//	    	for(int i = 0 ; i < HW ; i++) {
//	    		for(int j = 0 ; j < HW ; j++ ) {
//	    			System.out.print(arr[i][j] + " ");
//	    		}
//	    		System.out.println();
//	    	}
	    	
	    	
	    	
	    	
	    }
	    
	    public static void bfs() {
	    	for(int i = 0 ; i < HW ; i++) {
	    		for(int j = 0 ; j < HW ; j++) {
	    			if(arr[i][j] == 1 && !check[i][j]) {
	    				//System.out.println("시작좌표 " +  i +" " + j);
	    				q.add(new int[] {i, j});
	    				check[i][j] = true;
	    				cnt_check++;	
	    				while(!q.isEmpty()) {
	    					int[] where = q.poll();
	    					cnt[cnt_check]++;
	    					int start_x = where[0];
	    					int start_y = where[1];
	    					for(int index = 0 ; index < 4; index++) {
	    						int new_x = start_x + dx[index];
	    						int new_y = start_y + dy[index];
	    						if(new_x >= 0 && new_x <= HW-1 && new_y >= 0 && new_y <= HW-1) {
	    							if(arr[new_x][new_y] == 1 && !check[new_x][new_y]) {
	    								q.add(new int[] {new_x, new_y});
	    								check[new_x][new_y] = true;
	    								//System.out.println("좌표 " +  new_x +" " + new_y);
	    							}
	    						}
	    					}
	    				}
	    			}
	    			
	    		}
	    	}
	    }
	    
}

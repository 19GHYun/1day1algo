import java.io.*;
import java.util.*;
 /*
  * 500 * 500 -> 25000
  * 
  */
    public class Main {
    	public static int N;
    	public static int[][] arr;
    	public static boolean[][] check;
    	public static int start = 0;
    	public static int answer = 0;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            
            arr = new int[N][N];
            check = new boolean[N][N];
            
            st = new StringTokenizer(br.readLine());
            
            for(int i = 0 ; i < N ; i++) {
            	int a = Integer.parseInt(st.nextToken());
            	if(a == -1) {
            		start = i;
            		continue;
            	}
            	
            	arr[i][a] = 1;
            	arr[a][i] = 1;
            	
            }
            
            int cut = Integer.parseInt(br.readLine());
            
            for(int i = 0 ; i < N ; i++) {
            	arr[i][cut] = 0;
            	arr[cut][i] = 0;
            }
            
            if(cut == start) {
            	System.out.println(0);
            }else {
                dfs(start);
                
            	System.out.println(answer);
            }
            


            
        }   
        
        public static void dfs(int start1) {
        	boolean mid = false;
        	for(int i = 0 ; i < N ; i++) {
        		if(arr[start1][i] == 1 && !check[start1][i]) {
        			check[start1][i] = true;
        			check[i][start1] = true;
        			mid = true;
        			dfs(i);
        		}
        	}
        	if(!mid ) {
        		answer++;
        	}

        }

}

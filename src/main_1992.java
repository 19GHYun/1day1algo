import java.io.*;
import java.util.*;
 
    public class Main {
    	public static int N;
    	public static int[][] arr;
    	public static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            
            N = Integer.parseInt(br.readLine());
            
            arr = new int[N][N];
            
            for(int i = 0 ; i < N ; i++) {
            	String a = br.readLine();
            	for(int j = 0 ; j < N ; j++) {
            		arr[i][j] = a.charAt(j) - '0';
            	}
            }
            
            
//            for(int i = 0 ; i < N ; i++) {
//            	for(int j = 0 ; j < N ; j++) {
//            		System.out.print(arr[i][j] + " ");
//            	}
//            	System.out.println();
//            }

            divide(0,0,N);
            

            
            System.out.println(sb.toString());
        }
        
        public static void divide(int x, int y, int size) {
        	if(check(x,y,size)) {
        		sb.append(arr[x][y]);
        		return;
        	}
        	
        	int new_size = size / 2;
        	
        	sb.append("(");
        	
        	divide(x,y,new_size);
        	divide(x,y + new_size,new_size);
        	divide(x + new_size,y,new_size);
        	divide(x + new_size,y + new_size,new_size);
        	
        	sb.append(")");
        	
        }
        
        public static boolean check(int x, int y, int size) {
        	int color = arr[x][y];
        	for(int i = x ; i < x + size ; i++) {
        		for(int j = y ; j < y + size ; j++) {
        			if(arr[i][j] != color) {
        				return false;
        			}
        		}
        	}
        	
        	
        	return true;
        }

        
}

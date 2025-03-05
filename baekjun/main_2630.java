import java.io.*;
import java.util.*;
 
    public class Main {
         public static int N;
         public static int[][] arr;
         public static int white = 0;
         public static int blue = 0;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            
            N = Integer.parseInt(br.readLine());


            arr = new int[N][N];
            
            for(int i = 0 ; i < N ; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0 ; j < N ;  j++) {
            		arr[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            divide(0,0,N);
            
            System.out.println(white);
            System.out.println(blue);
            
        }
        
        public static void divide(int x, int y, int size) {
        	if(check(x,y,size)) {
        		if(arr[x][y] == 1) {
        			blue++;
        		}
        		else {
        			white++;
        		}
        		return;
        	}
        	
        	int newSize = size / 2;
        	
        	divide(x,y,newSize);
        	divide(x,y + newSize,newSize);
        	divide(x + newSize,y,newSize);
        	divide(x+ newSize,y+ newSize,newSize);
        	
        	
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

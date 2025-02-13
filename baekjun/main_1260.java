import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int[][] arr;
    public static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
   	Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    int M = sc.nextInt();
    
    int start = sc.nextInt();
    
    arr = new int[N+1][N+1];
    check = new boolean[N+1];

    int a;
    int b;
    for(int i = 0 ; i < M ; i++) {
        a = sc.nextInt();
        b = sc.nextInt();
        
        arr[a][b] = 1;
        arr[b][a] = 1;
    }
    
    dfs(start);
    check = new boolean[N+1];
    System.out.println();
    bfs(start);
    
    
}

//public static void dfs(int start) {
//    
//    check[start] = true;
//    
//    System.out.print(start +" ");
//    
//    for(int i = 1 ; i < N + 1 ; i ++) {
//        if(!check[i] && arr[start][i] == 1) {
//            dfs(i);
//        }
//    }
//    
//}
    
    public static void dfs(int start) {
    	System.out.print(start + " ");
    	check[start] = true;
    	
    	for(int i = 1 ; i < N + 1 ; i++) {
    		if(!check[i] && arr[start][i] == 1) {
    			dfs(i);
    		}
    	}
    }

//public static void bfs(int start) {
//	q.add(start);
//	check[start] = true;
//	
//	while(!q.isEmpty()) {
//		start = q.poll();
//		System.out.print(start + " ");
//		for(int i = 1 ; i < N+1 ; i++) {
//			if(!check[i] && arr[start][i] == 1) {
//				q.add(i);
//				check[i] = true;
//			}
//		}
//	}
//	
//}
    public static void bfs(int start) {
    	q.add(start);
    	check[start] = true;
    	
    	while(!q.isEmpty()) {
    		
    		start = q.poll();
    		System.out.print(start + " ");
    		
    		for(int i = 1 ; i < N + 1 ; i++) {
    			if(!check[i] && arr[start][i] == 1) {
    				q.add(i);
    				check[i] = true;
    			}
    		}
    	}
    	
    }
}

import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int[][] arr;
    public static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
   	Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    int M = sc.nextInt();
    
    
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
    
    bfs(1);
    
    System.out.print(list.size() - 1);
    
    
}
    
    public static void dfs(int start) {
    	check[start] = true;
    	list.add(start);
    	for(int i = 1 ; i < N + 1 ; i++) {
    		if(!check[i] && arr[start][i] == 1) {
    			dfs(i);
    		}
    	}
    }

    public static void bfs(int start) {
    	q.add(start);
    	check[start] = true;
    	
    	while(!q.isEmpty()) {
    		
    		start = q.poll();
    		list.add(start);
    		
    		for(int i = 1 ; i < N + 1 ; i++) {
    			if(!check[i] && arr[start][i] == 1) {
    				q.add(i);
    				check[i] = true;
    			}
    		}
    	}
    	
    }
}

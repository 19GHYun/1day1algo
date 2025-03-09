import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer>[] list;
    public static int[] arr;
    public static boolean[] check;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1];
        check = new boolean[N + 1];
        
        list = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	arr[a2]++;
        	list[a1].add(a2);
        }
        
        bfs();
        
        System.out.println(sb);
        
        
    }
    
    public static void bfs() {
    	Queue<Integer> que = new ArrayDeque<>();
    	for(int i = 1 ; i <= N ; i++) {
    		if(arr[i] == 0) {
    			que.add(i);
    		}
    	}
    	
    	while(!que.isEmpty()) {
    		int cur = que.poll();
			sb.append(cur).append(" ");
    		for(int a : list[cur]) {
				arr[a]--;
    				if(arr[a] == 0) {
    					que.add(a);
    			}
    		}
    	}
    	
    	   	
    }

}

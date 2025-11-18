import java.io.*;
import java.util.*;

public class Main {
	public static int N,M; // 정점, 간선
	public static ArrayList<ArrayList<Integer>> list;
	public static boolean[] check;
	public static int answer = 0;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        list = new ArrayList<>();
        
        for(int i = 0 ; i <= N ; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	
        	list.get(a1).add(a2);
        	list.get(a2).add(a1);
        }
        
        for(int i = 1 ; i < N + 1 ; i++) {
        	if(!check[i]) {
        		dfs(i);
        		answer++;
        	}
        }
        
        System.out.println(answer);
        
        
	}
    
    public static void dfs(int start) {
    	for(int a : list.get(start)) {
    		if(!check[a]) {
    			check[a] = true;
    			dfs(a);
    		}
    	}
    }

}

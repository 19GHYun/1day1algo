import java.util.*;
import java.io.*;

public class Main {
    public static int N,M; // 정점, 간선
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static boolean[] check;
    public static int answer = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        check = new boolean[N];
        
        for(int i = 0 ; i < N ; i++) {
        	list.add(new ArrayList<>());
        }
        
        int a1,a2;
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	a1 = Integer.parseInt(st.nextToken());
        	a2 = Integer.parseInt(st.nextToken());
        	
        	list.get(a1).add(a2);
        	list.get(a2).add(a1);
        	
        	
        }
        for (int i = 0; i < N; i++) {
            if (answer == 1) break; // 답을 찾으면 종료
            check[i] = true;
            dfs(i, 0);
            check[i] = false;
        }
        
        System.out.println(answer);
    	
    }
    
    public static void dfs(int start, int cnt) {
    	if(cnt == 4) {
    		answer = 1;
    		return;
    	}
    	for(int a : list.get(start)) {
    		if(!check[a]) {
    			check[a] = true;
    			dfs(a, cnt + 1);
    			check[a] = false;
    			if(answer == 1) {
    				return;
    			}
    		}
    	}
    }

}

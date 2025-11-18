import java.io.*;
import java.util.*;

public class Main {
	public static int V, E, R; // 정점 집합, 간선 집합, 시작 점.
	public static boolean[] check;
	public static ArrayList<ArrayList<Integer>> list;
	public static int[] enter;
	public static int enter_num = 0;

	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
        
        V = Integer.parseInt(st.nextToken()); // 노드 수
        E = Integer.parseInt(st.nextToken()); // 간선 수
        R = Integer.parseInt(st.nextToken()); // 시작 점
        
        check = new boolean[V + 1];
        enter = new int[V + 1];
       list = new ArrayList<>();
       
       for(int i = 0 ; i <= V ; i++) {
    	   list.add(new ArrayList<>());
       }
        
        for(int i = 0 ; i < E ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	
        	list.get(a1).add(a2);
        	list.get(a2).add(a1);
        	
        }
        
        for (int i = 1; i <= V; i++) {
            Collections.sort(list.get(i));
        }
        
        check[R] = true;
        dfs(R);
        
        for(int i = 1 ; i < V + 1 ; i++) {
        	sb.append(enter[i]);
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
    
    public static void dfs(int start) {
    	enter_num++;
    	enter[start] = enter_num;
    	for(int a : list.get(start)) {
    		if(!check[a]) {
    			check[a] = true;
    			dfs(a);
    		}
    	}
    	
    }


}

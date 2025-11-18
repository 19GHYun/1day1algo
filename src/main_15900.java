import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static ArrayList<Integer>[] list;
    public static boolean[] check;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        check = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < N - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken());
        	
        	list[a1].add(a2);
        	list[a2].add(a1);
        	
        }
        check[1] = true;
        dfs(1,0);
        
        if( answer % 2 == 0) {
        	System.out.println("No");
        }
        else {
        	System.out.println("Yes");
        }
    //짝수면 형석이가 이기고
    //홀수면 성원이가 이김
        
        
    }
    
    public static void dfs(int start, int cnt) {
    	boolean check2 = false;
    	for(int a : list[start]) {
    		if(!check[a]) {
    			check2 = true;
    			check[a] = true;
    			dfs(a, cnt + 1);
    		}
    	}
    	if(!check2) {
    		answer += cnt;
    	}
    }
    



    
}

import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static boolean[] check;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+26][N+26];
        check = new boolean[N+26];
        
        String a;
        
        for(int i = 1 ; i < N + 1;  i++) {
        	a = br.readLine();
        	
        	int a1 = a.charAt(0) - 'a' + 1;
        	int a2 = a.charAt(5) - 'a' + 1;
        	
        	arr[a1][a2] = 1;
        	
        }
        
        M = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < M ; i++) {
        	a = br.readLine();
        	
        	int a3 = a.charAt(0) - 'a' + 1;
        	int a4 = a.charAt(5) - 'a' + 1;
        	
        	check[a3] = true;
        	
        	if(dfs(a3,a4)) {
        		System.out.println("T");
        	}else {
        		System.out.println("F");
        	}
  
        	
        	check[a3] = false;
        	
        }

        
    }
    
    public static boolean dfs(int start, int end) {
        if (start == end) {
            return true;
        }
        
        for (int i = 1; i < N + 26; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                check[i] = true;
                if (dfs(i, end)) { // 여기서 재귀 확인해야한다.이렇게 하면 if도 돌리고 dfs도 돌아간다.
                    check[i] = false; // 백트래킹
                    return true; // 경로가 있으면 true 반환
                }
                check[i] = false; // 경로가 없으면 방문 해제
            }
        }
        return false; // 경로가 없으면 false 반환
    }


    
}

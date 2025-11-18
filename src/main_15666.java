import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	M = sc.nextInt();

        arr = new int[N];
        ans = new int[M];

        for(int i = 0 ; i < N ; i++) {
        	arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        dfs(0, 0);
    }
    public static void dfs(int depth, int index){
        if (depth == M){
            for (int x : ans){
                System.out.printf("%d ", x);
            }
            System.out.println();
            return;
        }
        int prev = -1;
        for (int i = index; i < N; i++){
        	if(arr[i] != prev) {
	            ans[depth] = arr[i];
	            prev = arr[i];
	            dfs(depth + 1, i);
        	}
        }
    }
}

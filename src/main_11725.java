import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            
            arr[a1].add(a2); 
            arr[a2].add(a1); 
        }
        
        int[] answer = new int[N + 1];
        
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] check = new boolean[N + 1];
        
        que.add(1);
        check[1] = true;
        while (!que.isEmpty()) {
            int now = que.poll();
            
            for (int i : arr[now]) {
                if (!check[i]) { 
                    check[i] = true;
                    answer[i] = now;
                    que.add(i);
                }
            }
        }
        
        for (int i = 2; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
}

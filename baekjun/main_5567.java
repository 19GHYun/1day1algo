import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static boolean[] check;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            arr[a1][a2] = 1;
            arr[a2][a1] = 1;
        }

        check[1] = true;
        bfs(1);

        for (int i = 2; i <= N; i++) {
            if (check[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int start) {
    	Queue<int[]> que = new ArrayDeque<>();
    	que.add(new int[] { start, 0});
    	while(!que.isEmpty()) {
    		int[] where = que.poll();
    		if(where[1] >= 2) {
    			return;
    		}
    		for(int i = 1 ; i <= N ; i++) {
    			if(!check[i] && arr[where[0]][i] == 1) {
    				check[i] = true;
    				que.add(new int[] {i, where[1] + 1});
    			}
    		}
    	}
    }
}

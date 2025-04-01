import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = a.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs(0, 0));
    }
    
    public static int bfs(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>(); 
        int[][] dist = new int[N][M]; 
        for (int[] row : dist) {
        	Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        deque.addFirst(new int[]{x, y, 0});
        dist[x][y] = 0;
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int currX = curr[0];
            int currY = curr[1];
            int cnt = curr[2];
            
            if (currX == N - 1 && currY == M - 1) {
                return cnt; 
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                
                if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                	int nextCnt = 0;
                	if(arr[newX][newY] == 1) {
                		nextCnt = cnt + 1;
                	}else {
                		nextCnt = cnt;
                	}
                    if (nextCnt < dist[newX][newY]) { 
                        dist[newX][newY] = nextCnt;
                        if (arr[newX][newY] == 0) {
                            deque.addFirst(new int[]{newX, newY, nextCnt});
                        } else {
                            deque.addLast(new int[]{newX, newY, nextCnt});  
                        }
                    }
                }
            }
        }
        return -1;
    }
}

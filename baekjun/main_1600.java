import java.util.*;
import java.io.*;

public class Main {
    public static int K, W, H; // 말처럼 뛰기 시도 횟수, 너비, 높이
    public static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    public static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
    public static int[] ddx = {1, -1, 0, 0};
    public static int[] ddy = {0, 0, 1, -1};
    public static boolean[][][] check;
    public static int[][] arr;
    public static int new_x, new_y, x, y, cnt, LOCAL_K;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        K = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        check = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
            }
        }

        System.out.println( bfs(0, 0, K, 0));

//        int total_answer = Integer.MAX_VALUE;
//        for (int i = 0; i <= K; i++) {
//            int answer = arr[H - 1][W - 1]; // 목표 좌표 변경
//            if (total_answer > answer) {
//                total_answer = answer;
//            }
//        }
//
//        for (int i = 0; i < H; i++) {
//            for (int j = 0; j < W; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        if (total_answer == 0) {
//            System.out.println(-1);
//        } else {
//            System.out.println(total_answer / 2);
//        }
    }

    public static int bfs(int start_x, int start_y, int L_K, int count) {
    	Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_x, start_y, L_K, count});
        check[start_x][start_y][L_K] = true;

        while (!q.isEmpty()) {
            int where[] = q.poll();
            x = where[0];
            y = where[1];
            LOCAL_K = where[2];
            cnt = where[3];
//            System.out.println(LOCAL_K);

            if(x == H - 1 && y == W - 1) {
            	return cnt;
            }
            
            if (LOCAL_K > 0) { // 8방향 이동 가능
                for (int i = 0; i < 8; i++) {
                    new_x = x + dx[i];
                    new_y = y + dy[i];

                    if (new_x >= 0 && new_x < H && new_y >= 0 && new_y < W) {
                    	if (arr[new_x][new_y] == 0 && !check[new_x][new_y][LOCAL_K - 1]) { // -1 추가
                    	    q.add(new int[]{new_x, new_y, LOCAL_K - 1, cnt + 1});
                    	    check[new_x][new_y][LOCAL_K - 1] = true;
                    	}

                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                new_x = x + ddx[i];
                new_y = y + ddy[i];
                if (new_x >= 0 && new_x < H && new_y >= 0 && new_y < W) {
                	if (arr[new_x][new_y] == 0 && !check[new_x][new_y][LOCAL_K]) {
                	    q.add(new int[]{new_x, new_y, LOCAL_K, cnt + 1});
                	    check[new_x][new_y][LOCAL_K] = true;
                	}

                }
            }
            


        }
        return -1;
    }
}

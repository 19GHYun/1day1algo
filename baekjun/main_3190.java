import java.io.*;
import java.util.*;

public class Main {
    public static int N, K, L;
    public static int[][] arr;
    public static int answer = 0;
    public static Queue<Integer> time_que = new ArrayDeque<>();
    public static Queue<Character> where_que = new ArrayDeque<>();
    public static Deque<int[]> snake = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            time_que.add(Integer.parseInt(st.nextToken()));
            where_que.add(st.nextToken().charAt(0));
        }

        snake.add(new int[] {1, 1});
        dfs(1, 1, 1);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int state) { // 0: 북, 1: 동, 2: 남, 3: 서
        answer++;


        int nextX = x;
        int nextY = y;
        switch (state) {
            case 0: nextX--; break;
            case 1: nextY++; break;
            case 2: nextX++; break;
            case 3: nextY--; break;
        }


        if (nextX < 1 || nextX > N || nextY < 1 || nextY > N) {
            return;
        }

        for (int[] pos : snake) {
            if (pos[0] == nextX && pos[1] == nextY) {
                return;
            }
        }


        snake.addLast(new int[] {nextX, nextY});
        if (arr[nextX][nextY] == 0) {
            snake.pollFirst(); 
        } else {
            arr[nextX][nextY] = 0; 
        }


        if (!time_que.isEmpty() && answer == time_que.peek()) {
            time_que.poll();
            char b = where_que.poll();
            if (b == 'L') {
                state = (state - 1 + 4) % 4;
            } else if (b == 'D') {
                state = (state + 1) % 4;
            }
        }

        dfs(nextX, nextY, state);
    }
}

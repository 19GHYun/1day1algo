import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, D;
    public static int good_kill = 0;
    public static int[][] arr2;
    public static int[][] arr;
    public static int kill = 0;
    public static boolean gameover = false;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        johab(0, 0);
        System.out.println(good_kill);
    }

    public static void mob_down() {
        boolean hasEnemy = false;
        for (int j = 0; j < M; j++) {
            if (arr[N-1][j] == 1) {
                arr[N-1][j] = 0;
            }
        }
        for (int i = N-2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    arr[i+1][j] = 1;
                    arr[i][j] = 0;
                    hasEnemy = true;
                }
            }
        }
        if (!hasEnemy) gameover = true;
    }

    public static void find_and_shoot(int x, int y, ArrayList<int[]> targets) {
        int minDist = D + 1;
        int targetX = -1, targetY = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    int dist = Math.abs(x - i) + Math.abs(y - j);
                    if (dist <= D) {
                        if (dist < minDist || (dist == minDist && j < targetY)) {
                            minDist = dist;
                            targetX = i;
                            targetY = j;
                        }
                    }
                }
            }
        }
        if (targetX != -1) {
            targets.add(new int[]{targetX, targetY});
        }
    }

    public static void johab(int start, int cnt) {
        if (cnt == 3) {
            gameover = false;
            kill = 0;
            arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                arr[i] = arr2[i].clone();
            }
            while (!gameover) {
                ArrayList<int[]> targets = new ArrayList<>();
                for (int archer : list) {
                    find_and_shoot(N, archer, targets);
                }
                for (int[] target : targets) {
                    if (arr[target[0]][target[1]] == 1) {
                        arr[target[0]][target[1]] = 0;
                        kill++;
                    }
                }
                mob_down();
            }
            good_kill = Math.max(good_kill, kill);
            return;
        }
        for (int i = start; i < M; i++) {
            list.add(i);
            johab(i + 1, cnt + 1);
            list.remove(list.size() - 1);
        }
    }
}

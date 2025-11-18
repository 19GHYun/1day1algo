import java.util.*;
import java.io.*;

public class Main {
    public static int H, W;
    public static int[][] arr;
    public static boolean[][] check;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static boolean bfs_check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = 0;

        H = sc.nextInt();
        W = sc.nextInt();
        arr = new int[H][W];
        check = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        while (!bfs_check) {
            bfs();
            if (two_ice()) {
                break;
            } else {
                meltsnow();
            }
            year++;
            for (int i = 0; i < H; i++) {
                Arrays.fill(check[i], false);
            }
        }

        if (bfs_check) {
            System.out.println(0);
        } else {
            System.out.println(year);
        }
    }

    public static boolean two_ice() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (!check[i][j] && arr[i][j] > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void bfs() {
        int start_x = 0;
        int start_y = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean check_start = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] != 0) {
                    start_x = i;
                    start_y = j;
                    check_start = true;
                    break;
                }
            }
            if (check_start) {
                break;
            }
        }

        if (check_start) {
            q.add(new int[]{start_x, start_y});
            check[start_x][start_y] = true;
            while (!q.isEmpty()) {
                int[] where = q.poll();
                int x = where[0];
                int y = where[1];
                for (int i = 0; i < 4; i++) {
                    int new_x = x + dx[i];
                    int new_y = y + dy[i];
                    if (new_x >= 0 && new_x < H && new_y >= 0 && new_y < W) {
                        if (arr[new_x][new_y] > 0 && !check[new_x][new_y]) {
                            check[new_x][new_y] = true;
                            q.add(new int[]{new_x, new_y});
                        }
                    }
                }
            }
        } else {
            bfs_check = true;
        }
    }

    public static void meltsnow() {
        int maxPossible = H * W;
        int[] dxList = new int[maxPossible];
        int[] dyList = new int[maxPossible];
        int count = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 0) {
                    dxList[count] = i;
                    dyList[count] = j;
                    count++;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            int x = dxList[i];
            int y = dyList[i];
            for (int p = 0; p < 4; p++) {
                int snow_x = x + dx[p];
                int snow_y = y + dy[p];
                if (snow_x >= 0 && snow_x < H && snow_y >= 0 && snow_y < W) {
                    if (arr[snow_x][snow_y] > 0) {
                        arr[snow_x][snow_y]--;
                    }
                }
            }
        }
    }
}

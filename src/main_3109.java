import java.util.*;
import java.io.*;

public class Main {
    public static int[][] arr;
    public static int R, C; // height, width
    public static int[] dx = {-1, 0, 1}; // 오른쪽 위, 오른쪽, 오른쪽 아래
    public static int[] dy = {1, 1, 1};
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new int[R][C];
        
        for(int i = 0; i < R; i++) {
            String a = br.readLine();
            for(int j = 0; j < C; j++) {
                char c = a.charAt(j);
                if(c == '.') arr[i][j] = 0; // 빈 칸
                else arr[i][j] = 1; // 건물
            }
        }
        
        for(int i = 0; i < R; i++) {
            if(dfs(i, 0)) { // 각 행의 첫 열에서 시작
                answer++;
            }
        }
        
        System.out.println(answer);
    }
    
    public static boolean dfs(int x, int y) {
        if(y == C - 1) { // 마지막 열에 도달하면 성공
            return true;
        }
        
        for(int j = 0; j < 3; j++) { // 오른쪽 위, 오른쪽, 오른쪽 아래 순서
            int new_x = x + dx[j];
            int new_y = y + dy[j];
            if(new_x >= 0 && new_x < R && new_y >= 0 && new_y < C) {
                if(arr[new_x][new_y] == 0) { // 빈 칸이면
                    arr[new_x][new_y] = 2; // 가스관 설치
                    if(dfs(new_x, new_y)) { // 경로를 찾으면 true 반환
                        return true;
                    }
                }
            }
        }
        return false; // 경로를 찾지 못함
    }
}

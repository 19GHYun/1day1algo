import java.util.*;
import java.io.*;

public class Main {
    static int H, W, answer;
    static char[][] map;
    static boolean[][] visited;
    
    // 4가지 모양 (기준점 포함)
    static int[][][] blocks = {
        {{0,0}, {1,0}, {0,1}},  // ┌-
        {{0,0}, {0,1}, {1,1}},  // ┐
        {{0,0}, {1,0}, {1,1}},  // └-
        {{0,0}, {1,0}, {1,-1}}  // ┘
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            
            if(H == 0 && W == 0) break;
            
            map = new char[H][W];
            visited = new boolean[H][W];
            answer = 0;
            
            int empty = 0;
            for(int i=0; i<H; i++) {
                String line = br.readLine();
                for(int j=0; j<W; j++) {
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == '.') empty++;
                }
            }
            
            if(empty%3 != 0) {
                System.out.println(0);
                continue;
            }
            
            backtrack();
            System.out.println(answer);
        }
    }
    
    static void backtrack() {
        int x = -1, y = -1;
        
        //첫칸찾기
        outer:
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if(map[i][j] == '.' && !visited[i][j]) {
                    x = i;
                    y = j;
                    break outer;
                }
            }
        }
        
        //다 채워져 있으면?
        if(x == -1 && y == -1) {
            answer++;
            return;
        }
        
        // Try all 4 block types
        for(int[][] block : blocks) {
            if(canPlace(x, y, block)) {
                place(x, y, block, true);
                backtrack();
                place(x, y, block, false);
            }
        }
    }
    
    static boolean canPlace(int x, int y, int[][] block) {
        for(int[] pos : block) {
            int nx = x + pos[0];
            int ny = y + pos[1];
            
            if(nx < 0 || nx >= H || ny < 0 || ny >= W) return false;
            if(map[nx][ny] != '.' || visited[nx][ny]) return false;
        }
        return true;
    }
    
    static void place(int x, int y, int[][] block, boolean flag) {
        for(int[] pos : block) {
            int nx = x + pos[0];
            int ny = y + pos[1];
            visited[nx][ny] = flag;
        }
    }
}

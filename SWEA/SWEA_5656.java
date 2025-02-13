package algo2021;

import java.util.*;
import java.io.*;

public class Main {
        public static int final_block = 9999999;
        public static int H;
        public static int W;
        public static int N;
        public static Queue<int[] > q = new LinkedList<>();
        public static int[] dx = { 1, -1, 0, 0};
        public static int[] dy = { 0, 0, 1, -1};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int T = Integer.parseInt(br.readLine());



            for(int i = 1 ; i < T + 1 ; i++) {
            	final_block = 9999999;
                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                W = Integer.parseInt(st.nextToken());
                H = Integer.parseInt(st.nextToken());

                int[][] arr = new int[H][W];


                for(int j = 0 ; j < H ; j++) {
                    st = new StringTokenizer(br.readLine());
                    for(int p = 0 ; p < W ; p++) {
                        arr[j][p] = Integer.parseInt(st.nextToken());
                    }
                }

                bfs(0, arr);

                System.out.println("#"+ i + " " +final_block);

//                System.out.println(check_block(arr));
//
//                down_arr(arr);
//
//
//                for(int j = 0 ; j < H ; j++) {
//                    for(int p = 0 ; p < W ; p++) {
//                        System.out.print(arr[j][p] + " ");
//                    }
//                    System.out.println();
//                }



            }

    }
    public static int check_block(int[][] arr1){ //블록 갯수 확인 메서드
        int cnt = 0;
        for(int i = 0 ; i < W ; i++) {
            for(int j = 0 ; j < H ; j++) {
                if(arr1[j][i] == 0) {
                    
                }else {
                    cnt++;
                }
            }
        }
        
        
        return cnt;
    }
    
    public static int[][] down_arr(int[][] arr1){ // 아래로 정렬하는 메서드
        int tmp;
        for(int p = 0 ; p < H ; p++) {
            for(int i = 0 ; i < W ; i++) {
                for(int j = H - 1 ; j >= 1 ; j--) {
                    if(arr1[j][i] == 0) {
                        tmp = arr1[j-1][i];
                        arr1[j-1][i] = arr1[j][i];
                        arr1[j][i] = tmp;
                    }
                }
            }
        }
        
        return arr1;
    }
    
    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
    
    public static void bfs(int cnt, int[][] arr) {

        if (cnt == N) {
            int blocks = check_block(arr);
            //System.out.println("block count : " + blocks);
            final_block = Math.min(final_block, blocks);
            //System.out.println("Final block count updated: " + final_block);
            return;
        }
        
        for (int i = 0; i < W; i++) {
            boolean calc = false;
            int[][] copy_arr = deepCopy(arr);
            for (int j = 0; j < H; j++) {	//맨 위부터 1 이상인 수 찾아서 뿌셔버림
                if (copy_arr[j][i] > 0 && !calc) {
                    calc = true;
                    if (copy_arr[j][i] == 1) {
                        copy_arr[j][i] = 0;
                    } else {
                        q.add(new int[]{j, i});
                        while (!q.isEmpty()) {
                            int[] where = q.poll();
                            int start_x = where[0], start_y = where[1];
                            int power = copy_arr[start_x][start_y];
                            copy_arr[start_x][start_y] = 0;

                            for (int p = 0; p < 4; p++) {
                                for (int step = 1; step < power; step++) {
                                    int new_x = start_x + dx[p] * step;
                                    int new_y = start_y + dy[p] * step;
                                    if (new_x >= 0 && new_y >= 0 && new_x < H && new_y < W) {
                                        if (copy_arr[new_x][new_y] > 1) {
                                            q.add(new int[]{new_x, new_y});
                                        }else {
                                        	copy_arr[new_x][new_y] = 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                  
                }
            }
            copy_arr = down_arr(copy_arr);
            bfs(cnt + 1, copy_arr);
        }
    }

    
    
    
    
}

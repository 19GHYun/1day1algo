import java.io.*;
import java.util.*;
 /*
  * 메모리 29320kb, 2855ms
  * 다익스트라를 모르고 모든 탐색 해도 된다고 하여서 백트래킹으로 탐색 해봤습니다.
  * 
  * 
  * 
  */
    public class Solution {
        public static int T,N;
        public static int answer;
        public static int[] x;
        public static int[] y;
        public static boolean[] check;
        public static ArrayList<Integer> list = new ArrayList<>();
         
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
             
            T = Integer.parseInt(br.readLine());
             
            for(int p = 1 ; p < T + 1 ; p++) {
                answer = Integer.MAX_VALUE;
                list.clear();
                 
                N = Integer.parseInt(br.readLine());
                 
                check = new boolean[N + 2];
                x = new int[N + 2]; // 0은 회사, 1은 집
                y = new int[N + 2]; 
                 
                st = new StringTokenizer(br.readLine());
                 
                for(int i = 0 ; i < N + 2 ; i++) {
                    x[i] = Integer.parseInt(st.nextToken());
                    y[i] = Integer.parseInt(st.nextToken());
                }
                 
                backt(0);
                 
                 
                System.out.println("#" + p + " " + answer);
            }
             
 
     }
         
        public static void backt(int cnt) {
            if(cnt == N) {
                int local_answer = 0;
                //처음
                local_answer += Math.abs(x[0] - x[list.get(0)]) + Math.abs( y[0] - y[list.get(0)]);
     
                for(int i = 0 ; i < N - 1 ; i++) {
                    local_answer += Math.abs(x[list.get(i)] - x[list.get(i+1)]) + Math.abs(y[list.get(i)] - y[list.get(i+1)]);
                }//들러야 하는 곳의 경우의수 싹다 더했습니다.
                 
                 
                //끝
                local_answer += Math.abs(x[list.get(list.size()-1)] - x[1]) + Math.abs(y[list.get(list.size()-1)] - y[1]);
                 
                answer = Math.min(answer, local_answer);
                 
                return;
            }
            for(int i = 2 ; i < N + 2 ; i++) { // 백투래킹.
                if(!check[i]) {
                    check[i] = true;
                    list.add(i);
                    backt(cnt + 1);
                    check[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }
}

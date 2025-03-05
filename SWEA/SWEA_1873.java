import java.io.*;
import java.util.*;
  /*
   * 메모리 26496KB, 111ms
   * 악으로 깡으로 구현만 했음
   */
    public class Solution {
        public static int T,N,M,A; // 테스트케이스, 높이, 가로, 행동횟수
        public static int[][] arr;
        public static int where; // 바라보는 방향. 동1 서2 남3 북4 // 이제 생각해보니 이게 있을 이유가 없음. 탱크 모양이 달라서
        public static int x,y; // 탱크의 위치.
          
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            T = Integer.parseInt(br.readLine());
              
            for(int p = 1 ; p < T + 1 ; p++) {
                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                 
                arr = new int[N][M];
                 
                sb.setLength(0); // 스트링빌더 초기화
                 
                String a;
                 
                /*
                 * . -> 4
                 * * -> 0
                 * # -> -7
                 * - -> 3
                 * ^ -> 52
                 * v -> 76
                 * < -> 18
                 * > -> 20 // 귀찮아서 int 배열로 풀었습니다.
                 */
                for(int i = 0 ; i < N ; i++) {
                    a = br.readLine();
                    for(int j = 0 ; j < M ; j++) {
                        arr[i][j] = a.charAt(j) - '*'; // crack
                        switch(arr[i][j]) {
                        case(52) :  // 이 switch는 탱크일때 걸러지는데, 어딜 바라보는지랑 x y 좌표를 알수 있습니다.
                            where = 4;
                            x = i;
                            y = j;
                            break;
                        case(76) :
                            where = 3;
                            x = i;
                            y = j;
                            break;
                        case(18) :
                            where = 2;
                            x = i;
                            y = j;
                            break;
                        case(20) :
                            where = 1;
                            x = i;
                            y = j;
                            break;
                        }
                    }
                }
                 
//              for(int i = 0 ; i < N ; i++) { 디버깅용
//                  for(int j = 0 ; j < M ; j++) {
//                      System.out.print(arr[i][j] + " ");
//                  }
//                  System.out.println();
//              }
                 
//              System.out.println(x + " " + y + " " + where);
                 
                A = Integer.parseInt(br.readLine()); // 명령어 받아서
                 
                String b = br.readLine();
                  
                for(int j = 0 ; j < A ; j++) { // 화려한 Switch가 명령을 감싸네
                    char c = b.charAt(j);
                    switch(c) {
                    case('U'):
                        up();
                        break;
                    case('D'):
                        down();
                        break;
                    case('L'):
                        left();
                        break;
                    case('R'):
                        right();
                        break;
                    case('S'):
                        shoot();
                        break;
                    }
                     
//                  for(int i = 0 ; i < N ; i++) { // 디버깅용
//                      for(int o = 0 ; o < M ; o++) {
//                          System.out.print((char)(arr[i][o] + '*'));
//                      }
//                      System.out.println();
//                      
//                  }
//                  System.out.println(j);
//                  System.out.println(j);
                }
                 
                System.out.print("#" + p + " ");
                 
                for(int i = 0 ; i < N ; i++) {
                    for(int j = 0 ; j < M ; j++) {
                        sb.append((char)(arr[i][j] + '*'));
                    }
                    sb.append("\n");
                }
                 
                System.out.print(sb.toString()); // 출력
                 
            }
              
  
     }
         
         
        public static void up() { // 이동함수. 아래쪽 다 로직은 같으니 여기서 설명
            int new_x = x -1; // 이동 할 좌표를 선언하고
            if(new_x < 0) { // 범위 넘어서면 방향만 바꾸고 리턴
                where = 4;
                arr[x][y] = 52;
                return;
            }
            if(arr[new_x][y] == -7 || arr[new_x][y] == 3 || arr[new_x][y] == 0 ) { // 갈려는 곳에 벽이나 호수가 있으면 컷
                where = 4;
                arr[x][y] = 52;
                return;
            }
             //위에 2 경우가 아니면 이동하고 전에 있던곳은 평지로 바꾸고 x좌표 갱신
            arr[new_x][y] = 52;
            where = 4;
            arr[x][y] = 4;
            x = new_x;
             
        }
        /*
         * . -> 4
         * * -> 0
         * # -> -7
         * - -> 3
         * ^ -> 52
         * v -> 76
         * < -> 18
         * > -> 20
         */
        public static void down() {
            int new_x = x + 1;
            if(new_x >= N) {
                where = 3;
                arr[x][y] = 76;
                return;
            }
            if(arr[new_x][y] == -7 || arr[new_x][y] == 3 || arr[new_x][y] == 0) {
                where = 3;
                arr[x][y] = 76;
                return;
            }
             
            arr[new_x][y] = 76;
            where = 3;
            arr[x][y] = 4;
            x = new_x;
        }
         
        public static void left() {
            int new_y = y - 1;
            if(new_y < 0) {
                where = 2;
                arr[x][y] = 18;
                return;
            }
            if(arr[x][new_y] == -7 || arr[x][new_y] == 3 || arr[x][new_y] == 0) {
                where = 2;
                arr[x][y] = 18;
                return;
            }
             
            arr[x][new_y] = 18;
            where = 2;
            arr[x][y] = 4;
            y = new_y;
        }
        public static void right() {
            int new_y = y + 1;
            if(new_y >= M) {
                where = 1;
                arr[x][y] = 20;
                return;
            }
            if(arr[x][new_y] == -7 || arr[x][new_y] == 3 || arr[x][new_y] == 0) {
                where = 1;
                arr[x][y] = 20;
                return;
            }
             
            arr[x][new_y] = 20;
            where = 1;
            arr[x][y] = 4;
            y = new_y;
        }
         
        public static void shoot() {
            if(where == 1) { // 1 즉 동쪽을 바라보고 있으면
                int new_y = y; // 동쪽으로 갑니다잉
                while(true) {
                    new_y = new_y + 1; // 1씩 계속 늘리는데, 범위를 넘어 서거나, 벽 만나면 끝납니다
                    if(new_y < M) { // 맵 안 이면 브레이크 안함.
                        if(arr[x][new_y] == 0) { // 뿌셔지는 벽이면 
                            arr[x][new_y] = 4; // 평지로 바꿈
                            break;
                        }
                        else if(arr[x][new_y] == -7) { // 못 뿌수는 벽이면
                            break; // 그냥 끝냄
                        }
                    }else { // 맵 밖이면 브레이크
                        break;
                    }
                     
                }
            }
            else if(where == 2) {
                int new_y = y;
                while(true) {
                    new_y = new_y - 1;
                    if(new_y >=0) {
                        if(arr[x][new_y] == 0) {
                            arr[x][new_y] = 4;
                            break;
                        }
                        else if(arr[x][new_y] == -7) {
                            break;
                        }
                    }else {
                        break;
                    }
                     
                }
            }
            else if(where == 3) {
                int new_x = x;
                while(true) {
                    new_x = new_x + 1;
                    if(new_x < N) {
                        if(arr[new_x][y] == 0) {
                            arr[new_x][y] = 4;
                            break;
                        }
                        else if(arr[new_x][y] == -7) {
                            break;
                        }
                    }else {
                        break;
                    }
                     
                }
            }
            else if(where == 4) {
                int new_x = x;
                while(true) {
                    new_x = new_x - 1;
                    if(new_x >= 0) {
                        if(arr[new_x][y] == 0) {
                            arr[new_x][y] = 4;
                            break;
                        }
                        else if(arr[new_x][y] == -7) {
                            break;
                        }
                    }else {
                        break;
                    }
                     
                }
            }
        }
          
  
          
}
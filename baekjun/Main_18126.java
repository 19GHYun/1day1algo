import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18126 {

    public static int[][] map;
    public static boolean[] check;
    public static int N = 0;

    static class Node{
        int where;
        Long size;

        Node(int a, long b){
            where = a;
            size = b;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        check = new boolean[N+1];

        for(int i = 0 ; i < N-1 ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
            map[b][a] = c;

        }

        bfs();

    }

    public static void bfs(){
        long answer = -2100000;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1,0));
        check[1] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            int start = node.where;
            Long size = node.size;
//            System.out.println(node.where + " " + node.size);
            answer = Math.max(answer, size);
            for(int i = 0 ; i < N+1 ; i++){
                if((map[start][i] != 0) && !check[i]){
                    q.add(new Node(i, size + (long)map[start][i]));
                    check[i] = true;
                }
            }

        }

        System.out.println(answer);

    }

}

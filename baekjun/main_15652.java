import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int a = 100;
    static int[] arr;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        
        dfs(new int[M], 0);
        System.out.print(result);
        br.close();
    }

    public static void dfs(int[] comb, int depth) {
        if (depth == M) {
            for (int num : comb) {
                result.append(num).append(' ');
            }
            result.append('\n');
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (depth == 0 || arr[i] >= comb[depth - 1]) {
                comb[depth] = arr[i];
                dfs(comb, depth + 1);
            }
        }
    }
}

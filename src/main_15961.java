import java.util.*;
import java.io.*;

public class Main {
    public static int N, d, k, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] a = new int[N + k];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if (i < k) {
                a[i + N] = a[i];
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;


        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        if(map.containsKey(c)) {
        	ans = map.size();
        }
        else {
        	ans = map.size() + 1;
        }


        for (int i = 1; i <= N; i++) {

            int prev = a[i - 1];
            map.put(prev, map.get(prev) - 1);
            if (map.get(prev) == 0) {
                map.remove(prev);
            }


            int next = a[i + k - 1];
            map.put(next, map.getOrDefault(next, 0) + 1);

            int localans = 0;
            if(map.containsKey(c)) {
            	localans = map.size();
            }
            else {
            	localans = map.size() + 1;
            }
            ans = Math.max(ans, localans);
        }

        System.out.println(ans);
    }
}

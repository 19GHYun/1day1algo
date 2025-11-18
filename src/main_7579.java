import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 개수
		int M = Integer.parseInt(st.nextToken()); // 목표바이트

		int[] app_size = new int[N + 1];
		int[] app_value = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			app_value[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			app_size[i] = Integer.parseInt(st.nextToken());
		}

		int[] DP = new int[10001];

        for (int i = 1; i <= N; i++) {
            if (app_size[i] == 0) {

                for (int cost = 0; cost <= 10000; cost++) {
                    DP[cost] += app_value[i];
                }
            } else {

                for (int cost = 10000; cost >= app_size[i]; cost--) {
                    DP[cost] = Math.max(DP[cost], DP[cost - app_size[i]] + app_value[i]);
                }
            }
        }
		
        for (int cost = 0; cost <= 10000; cost++) {
            if (DP[cost] >= M) {
                System.out.println(cost);
                return;
            }
        }
	}

}

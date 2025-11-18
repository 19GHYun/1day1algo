import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        long[] arr = new long[N];

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long start = 1;
        long mid = 0;
        long namu = 0;
        long result = 0; // 최종 결과를 저장할 변수

        while (start <= max) {
            namu = 0;
            mid = (start + max) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    namu += arr[i] - mid;
                }
            }
            if (namu >= M) {
                // 톱의 높이를 높여도 됨 (더 큰 값을 찾기 위해)
                result = mid; // 현재 mid 값을 저장
                start = mid + 1;
            } else {
                // 톱의 높이를 낮춰야 함
                max = mid - 1;
            }
        }

        System.out.println(result);
    }
}

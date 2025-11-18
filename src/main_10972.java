import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        if (nextPermutation(arr)) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static boolean nextPermutation(int[] arr) {
        // 1. 뒤에서부터 arr[i] < arr[i+1]인 i 찾기
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false; // 다음 순열 없음
        }

        // 2. 뒤에서부터 arr[i] < arr[j]인 j 찾기
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        // 3. Swap
        swap(arr, i, j);

        // 4. i+1부터 끝까지 reverse
        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}

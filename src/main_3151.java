import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr;
    public static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); 


        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right]; 

                if (sum == 0) {
                    if (arr[left] == arr[right]) { //정렬되어있으니 사이에 있는 값들이 같으면 조합으로 빠르게 넘김
                     
                        int count = right - left + 1;
                        answer += (long) count * (count - 1) / 2;
                        break; 
                    } else {
                      
                        int left_val = arr[left];
                        int left_count = 0;
                        while (left < right && arr[left] == left_val) { // 오른쪽으로 같은 값들 계산 그만큼 체크
                            left_count++;
                            left++;
                        }
                        int right_val = arr[right];
                        int right_count = 0;
                        while (left <= right && arr[right] == right_val) { // 이번엔 왼쪽으로
                            right_count++;
                            right--;
                        }
                        answer += (long) left_count * right_count; // 곱해서 더해줘야겠죠?
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(answer); 
    }
}

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        
        long k = Long.parseLong(st.nextToken());
        
        long start = 0; //가로 짜르기
        long end = n;   //세로 짜르기
        
        while (start <= end) {
            long x = start + (end - start) / 2; // 가로 짜르면서 늘어난 만큼
            long y = n - x;                     // 세로는 줄어야함
            long pieces = (x + 1) * (y + 1);   // +1 씩 더하고 곱해야 조각갯수
            
            if (pieces == k) {
                System.out.println("YES"); // 성공
                return;
            } else if (pieces < k) {
                start = x + 1; // 조각이 부족하면 start 늘리고
            } else {
                end = x - 1;   // 조각이 많으면 end를 줄임
            }
        }
        
        System.out.println("NO"); // 실패

    	

        
    }
}

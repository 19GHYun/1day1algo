import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static String[] str;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        str = new String[N];
        for(int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        for(int i = 0; i < N; i++) {
            int result = checkPalin(str[i]);
            System.out.println(result);
        }
    }
    
    public static int checkPalin(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean chance = true;
        
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                if (chance) {
                    chance = false;
                    // 왼쪽을 건너뛴 경우
                    if (isPalin(s, start + 1, end)) {
                        return 1;
                    }
                    // 오른쪽을 건너뛴 경우
                    else if (isPalin(s, start, end - 1)) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    return 2;
                }
            }
        }
        return chance ? 0 : 1;
    }
    
    public static boolean isPalin(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

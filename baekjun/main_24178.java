import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("#")) {
            String s = line;
            int n = s.length();
            int mid = n / 2;
            String firstHalf = s.substring(0, mid);
            String latterHalf;
            if (n % 2 == 0) {
                latterHalf = s.substring(mid);
            } else {
                latterHalf = s.substring(mid + 1);
            }
            String R = new StringBuilder(firstHalf).reverse().toString();
            if (latterHalf.length() != R.length()) {
                System.out.println(-1);
                continue;
            }
            if (latterHalf.equals(R)) {
                System.out.println(0);
                continue;
            }
            char[] T = latterHalf.toCharArray();
            char[] r = R.toCharArray();
            int m = T.length;
            int sum = 0;
            boolean possible = true;
            for (int i = 0; i < m; ) {
                if (T[i] == r[i]) {
                    i++;
                    continue;
                }
                boolean found = false;

                for (int j = i + 1; j <= m; j++) {
                    int len = j - i;
                    boolean ok = true;
                    for (int k = 0; k < len; k++) {
                        if (T[i + k] != r[j - 1 - k]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        sum += len * len;
                        i = j;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    possible = false;
                    break;
                }
            }
            System.out.println(possible ? sum : -1);
        }
    }
}

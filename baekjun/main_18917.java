import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        HashMap<Long, Long> map = new HashMap<>();
        long sum = 0;
        long xor = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) { // 1
              
                long x = Long.parseLong(st.nextToken());
                sum += x;
                xor ^= x;
                long count = map.getOrDefault(x, 0L);
                map.put(x, count + 1);
            } else if (type == 2) { // 2
                
                long x = Long.parseLong(st.nextToken());
                long count = map.getOrDefault(x, 0L);
                if (count > 0) { 
                    sum -= x;
                    xor ^= x;
                    map.put(x, count - 1);
                }
            } else if (type == 3) { // 3
              
                sb.append(sum).append('\n');
            } else if (type == 4) { //4
            
                sb.append(xor).append('\n');
            }
        }

        System.out.println(sb.toString());//출력
    }
}

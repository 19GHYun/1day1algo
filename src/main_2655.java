import java.io.*;
import java.util.*;

class Square implements Comparable<Square> {
    int size;
    int height;
    int weight;
    int num;

    Square(int x, int y, int z, int w) {
        this.size = x;
        this.height = y;
        this.weight = z;
        this.num = w;
    }

    public int compareTo(Square square) {
        return Integer.compare(square.size, this.size);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Square[] squares = new Square[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            squares[i] = new Square(size, height, weight, i + 1); 
        }

        Arrays.sort(squares);

        int[] dp = new int[N];
        int[] prev = new int[N];


        for (int i = 0; i < N; i++) {
            dp[i] = squares[i].height;
            prev[i] = -1; 
            for (int j = 0; j < i; j++) {

                if (squares[j].size > squares[i].size && squares[j].weight > squares[i].weight) {
                    if (dp[j] + squares[i].height > dp[i]) {
                        dp[i] = dp[j] + squares[i].height; 
                        prev[i] = j;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < N; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }


        List<Integer> result = new ArrayList<>();
        int current = maxIndex;
        while (current != -1) {
            result.add(squares[current].num);
            current = prev[current];
        }


        System.out.println(result.size()); 
        for (int i = 0; i < result.size(); i++) { 
            System.out.println(result.get(i));
        }
    }
}

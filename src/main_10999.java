import java.io.*;
import java.util.*;

class sgTree {
    long[] tree;
    long[] lazy;
    int n;

    sgTree(long[] arr) {
        n = arr.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        tree = new long[1 << (height + 1)];
        lazy = new long[1 << (height + 1)];
        build(arr, 1, 0, n - 1);
    }

    void build(long[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, node * 2, start, mid);
        build(arr, node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    void update(int left, int right, long val) {
        update(1, 0, n - 1, left, right, val);
    }

    void update(int node, int start, int end, int left, int right, long val) {
        propagate(node, start, end);
        if (right < start || left > end) return;
        if (left <= start && right >= end) {
            lazy[node] += val;
            propagate(node, start, end);
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right, val);
        update(node * 2 + 1, mid + 1, end, left, right, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    long query(int left, int right) {
        return query(1, 0, n - 1, left, right);
    }

    long query(int node, int start, int end, int left, int right) {
        propagate(node, start, end);
        if (right < start || left > end) return 0;
        if (left <= start && right >= end) return tree[node];
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) +
               query(node * 2 + 1, mid + 1, end, left, right);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        sgTree tree = new sgTree(arr);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                tree.update(b - 1, c - 1, d);
            } else {
                sb.append(tree.query(b - 1, c - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}

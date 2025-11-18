import java.io.*;
import java.util.*;

class SegmentTree {
    private long[] minTree; // 최솟값 저장 트리
    private int n;

    // 세그먼트 트리 초기화
    public SegmentTree(int[] arr) {
        n = arr.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        minTree = new long[1 << (height + 1)];
        build(arr, 0, 0, n - 1);
    }

    // 트리 구축
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            minTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);
        minTree[node] = Math.min(minTree[2 * node + 1], minTree[2 * node + 2]);
    }

    // 최솟값 쿼리
    public long queryMin(int left, int right) {
        return queryMin(0, 0, n - 1, left, right);
    }

    private long queryMin(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return Long.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;
        long leftMin = queryMin(2 * node + 1, start, mid, left, right);
        long rightMin = queryMin(2 * node + 2, mid + 1, end, left, right);
        return Math.min(leftMin, rightMin);
    }
    
    void update(int idx, long val) {
        update(0, 0, n - 1, idx, val); // 루트 노드부터 시작
    }
    
    void update(int node, int start, int end, int idx, long val) {
        if (start == end) {
            minTree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node + 1, start, mid, idx, val); // 왼쪽 자식
        } else {
            update(2 * node + 2, mid + 1, end, idx, val); // 오른쪽 자식
        }
        minTree[node] = Math.min(minTree[2 * node + 1], minTree[2 * node + 2]);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        
        SegmentTree tree = new SegmentTree(arr);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken()) - 1; 
            int end = Integer.parseInt(st.nextToken());
            
            if (a == 1) {
                tree.update(start, end);
            } else {
                sb.append(tree.queryMin(start, end - 1)).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}

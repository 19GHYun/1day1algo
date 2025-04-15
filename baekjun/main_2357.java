import java.io.*;
import java.util.*;

class SegmentTree {
    private long[] minTree; // 최솟값 저장 트리
    private long[] maxTree; // 최댓값 저장 트리
    private int n;

    // 세그먼트 트리 초기화
    public SegmentTree(int[] arr) {
        n = arr.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        minTree = new long[1 << (height + 1)];
        maxTree = new long[1 << (height + 1)];
        build(arr, 0, 0, n - 1);
    }

    // 트리 구축
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            minTree[node] = maxTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);
        minTree[node] = Math.min(minTree[2 * node + 1], minTree[2 * node + 2]);
        maxTree[node] = Math.max(maxTree[2 * node + 1], maxTree[2 * node + 2]);
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

    // 최댓값 쿼리
    public long queryMax(int left, int right) {
        return queryMax(0, 0, n - 1, left, right);
    }

    private long queryMax(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return Long.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;
        long leftMax = queryMax(2 * node + 1, start, mid, left, right);
        long rightMax = queryMax(2 * node + 2, mid + 1, end, left, right);
        return Math.max(leftMax, rightMax);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        SegmentTree tree = new SegmentTree(arr);
        
        
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int start = Integer.parseInt(st.nextToken()) - 1;
        	int end = Integer.parseInt(st.nextToken()) - 1;
        	
        	sb.append(tree.queryMin(start, end)).append(" ").append(tree.queryMax(start, end)).append("\n");
        	
        }
        
        System.out.println(sb);
        
    }
}

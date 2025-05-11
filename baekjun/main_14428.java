import java.io.*;
import java.util.*;

class SegmentTree {
    private long[] minTree; // 최솟값 저장 트리
    private int[] indexTree; // 최솟값의 인덱스 저장 트리
    private int n;
    private int[] originalArr; // 원본 배열 저장

    // 세그먼트 트리 초기화
    public SegmentTree(int[] arr) {
        n = arr.length;
        originalArr = arr.clone(); // 원본 배열 복사
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        minTree = new long[1 << (height + 1)];
        indexTree = new int[1 << (height + 1)];
        build(arr, 0, 0, n - 1);
    }

    // 트리 구축
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            minTree[node] = arr[start];
            indexTree[node] = start;
            return;
        }

        int mid = (start + end) / 2;
        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);
        if (minTree[2 * node + 1] <= minTree[2 * node + 2]) {
            minTree[node] = minTree[2 * node + 1];
            indexTree[node] = indexTree[2 * node + 1];
        } else {
            minTree[node] = minTree[2 * node + 2];
            indexTree[node] = indexTree[2 * node + 2];
        }
    }

    // 업데이트
    public void update(int idx, long val) {
        originalArr[idx] = (int) val; // 원본 배열도 업데이트
        update(0, 0, n - 1, idx, val);
    }

    private void update(int node, int start, int end, int idx, long val) {
        if (start == end) {
            minTree[node] = val;
            indexTree[node] = start;
            return;
        }

        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node + 1, start, mid, idx, val);
        } else {
            update(2 * node + 2, mid + 1, end, idx, val);
        }

        // 최소값과 인덱스 업데이트
        if (minTree[2 * node + 1] <= minTree[2 * node + 2]) {
            minTree[node] = minTree[2 * node + 1];
            indexTree[node] = indexTree[2 * node + 1];
        } else {
            minTree[node] = minTree[2 * node + 2];
            indexTree[node] = indexTree[2 * node + 2];
        }
    }

    // 최솟값 인덱스 쿼리
    public int queryMinIndex(int left, int right) {
        return queryMinIndex(0, 0, n - 1, left, right);
    }

    private int queryMinIndex(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return -1; // 유효하지 않은 범위
        }
        if (left <= start && end <= right) {
            return indexTree[node];
        }

        int mid = (start + end) / 2;
        int leftIndex = queryMinIndex(2 * node + 1, start, mid, left, right);
        int rightIndex = queryMinIndex(2 * node + 2, mid + 1, end, left, right);

        if (leftIndex == -1 && rightIndex == -1) {
            return -1;
        }
        if (leftIndex != -1 && rightIndex == -1) {
            return leftIndex;
        }
        if (leftIndex == -1 && rightIndex != -1) {
            return rightIndex;
        }

        // 최소값 비교
        long leftValue = leftIndex == -1 ? Long.MAX_VALUE : originalArr[leftIndex];
        long rightValue = rightIndex == -1 ? Long.MAX_VALUE : originalArr[rightIndex];
        if (leftValue < rightValue) {
            return leftIndex;
        } else if (leftValue > rightValue) {
            return rightIndex;
        } else {
            return Math.min(leftIndex, rightIndex); // 동일한 경우 작은 인덱스
        }
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
                tree.update(start, end); // end는 값으로 사용
            } else {
                sb.append(tree.queryMinIndex(start, end - 1) + 1).append("\n"); // 1-based 인덱스 출력
            }
        }
        
        System.out.println(sb);
    }
}

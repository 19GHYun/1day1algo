import java.io.*;
import java.util.*;

class sgTree{
	long[] tree;
	int n;
	
	sgTree(long[] arr){
		n = arr.length;
		int height = (int) Math.ceil(Math.log(n) / Math.log(2));
		tree = new long[1 << (height + 1)];
		build(arr,1,0,n-1);
	}
	
	void build(long[] arr, int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		build(arr, node * 2, start , mid);
		build(arr, node * 2 + 1 , mid + 1, end);
		tree[node] = tree[node *  2] + tree[node * 2 + 1];
		
	}
	
	long query(int left, int right) {
		return query(1,0,n-1,left,right);
	}
	long query(int node, int start, int end, int left, int right) {
		if(right < start || left > end) return 0;
		if(left <= start && right >= end) return tree[node];
		int mid = (start + end) / 2;
		return query(node * 2 , start, mid, left, right) + query(node * 2 + 1, mid + 1,  end, left, right);
		
	}
	
	void update(int idx, long val) {
		update(1,0,n-1,idx,val);
	}
	
	void update(int node, int start, int end, int idx, long val) {
		if(start == end) {
			tree[node] = val;
			return;
		}
		int mid = (start + end) / 2;
		if(idx <= mid) {
			update(node * 2 , start, mid, idx, val);
		}
		else {
			update(node * 2 + 1, mid + 1 , end , idx, val);
		}
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
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
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Long.parseLong(br.readLine());
        }
        
        sgTree tree = new sgTree(arr);
        
        for(int i = 0 ; i < M + K ; i++) {
        	st= new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	long c = Long.parseLong(st.nextToken());
        	
        	if(a == 1) {
        		tree.update(b-1,c);
        	}
        	else {
        		sb.append(tree.query(b-1, (int) c-1)).append("\n");
        	}
        	
        }
        System.out.println(sb);
    }
}

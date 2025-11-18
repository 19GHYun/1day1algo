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
		tree[node] = Math.min(tree[node*2], tree[node*2 + 1]);
		
	}
	
	long query(int left, int right) {
		return query(1,0,n-1,left-1,right-1);
	}
	
	long query(int node, int start, int end, int left, int right) {
		if(right < start || left > end) return Integer.MAX_VALUE;
		if(left <= start && right >= end) return tree[node];
		int mid = (start + end) / 2;
		long lR = query(node * 2, start, mid, left, right);
        long rR = query(node * 2 + 1, mid + 1, end, left, right);
        return Math.min(lR, rR);
		
	}
	
	
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[N];
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Long.parseLong(br.readLine());
        }
        
        sgTree tree = new sgTree(arr);
        
        for(int i = 0 ; i < M ; i++) {
        	st= new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());

        	sb.append(tree.query(a,b)).append("\n");

        	
        }
        System.out.println(sb);
    }
}

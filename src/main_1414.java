import java.util.*;
import java.io.*;

class Com implements Comparable<Com> {
	int left;
	int right;
	int weight;

	public Com(int left, int right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}

	public int compareTo(Com com) {
		return Integer.compare(this.weight, com.weight);
	}

}

public class Main {
	public static int N;
	public static int[] parent;

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);

		if (rootx != rooty) {
			parent[rooty] = rootx;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int total_num = 0;

		PriorityQueue<Com> que = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			String a = br.readLine();
			for (int ii = 1; ii <= N; ii++) {

				int a1 = a.charAt(ii - 1) - 'a' + 1;

				if(a1 == -48) {
					continue;
				}
				
				if (a1 < 0) {
					a1 += 58;
				}
				
				total_num += a1;
				
				if(i != ii ) {
					que.add(new Com(i, ii, a1));
				}

			}
		}

		int total_com = 0;
		int ans = 0;

		while (!que.isEmpty() && total_com < N - 1) {
			Com where = que.poll();

			int LE = where.left;
			int RI = where.right;
			int WE = where.weight;

			if (find(LE) != find(RI)) {
				union(LE, RI);
				total_com++;
				ans += WE;
			}

		}

		if (total_com == N - 1) {
			System.out.println(total_num - ans);
		} else {
			System.out.println(-1);
		}

	}

}

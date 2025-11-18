import java.util.*;
import java.io.*;

class graph{
	int v;
	int[][] arr;
	
	class Node implements Comparable<Node>{
		int x;
		int y;
		int weight;
		
		Node(int x,int y, int weight){
			this.x = x;
			this.y = y;
			this.weight= weight;
		}
		
		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
		}
	}
	
	graph(int v, int[][] map){
		this.v = v;
		this.arr = map;
	}
	
	public int[][] stra() {
		int[][] length = new int[v+1][v+1];
		boolean[][] checked = new boolean[v+1][v+1];
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		for(int i = 0 ; i <= v ; i++) {
			Arrays.fill(length[i], Integer.MAX_VALUE);
		}

		length[1][1] = arr[1][1];
		que.add(new Node(1,1, arr[1][1]));
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		while(!que.isEmpty()) {
			Node where = que.poll();
			int now_x = where.x;
			int now_y = where.y;
			if(now_x == v && now_y == v) {
				return length;
			}
			
			if(checked[now_x][now_y]) continue;
			checked[now_x][now_y] = true;
			
			for(int i = 0 ; i < 4 ; i++) {
				int next_x = now_x + dx[i];
				int next_y = now_y + dy[i];
				
				if(next_x <1 || next_x > v || next_y < 1 || next_y > v ) continue;
				
				if(!checked[next_x][next_y] && length[now_x][now_y] != Integer.MAX_VALUE &&
						length[now_x][now_y] + arr[next_x][next_y] < length[next_x][next_y]) {
					
					length[next_x][next_y] = length[now_x][now_y] + arr[next_x][next_y];
					que.add(new Node(next_x, next_y, length[next_x][next_y]));
				}
				
			}
			
		}

		return length;
	}
	
}


public class Main {
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int p = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			p++;
			if(N == 0) {
				break;
			}
			
			int[][] arr = new int[N+1][N+1];
			
			for(int i = 1 ; i <= N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int ii = 1 ; ii <= N ; ii++) {
					arr[i][ii] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			graph graph = new graph(N, arr);
			
			int[][] ans = new int[N+1][N+1];
			
			
			ans = graph.stra();
			
			sb.append("Problem " + p + ": ").append(ans[N][N]).append("\n");
		}

		System.out.println(sb);


	}

}

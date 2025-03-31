# 1day1algo

```
다익스트라 잠시 저장

import java.util.*;
import java.io.*;

class graph{
	
	private int v;	//정점의 개수
	private List<List<Node>> arr; // 그래프
	
	class Node implements Comparable<Node>{
		int dest;
		int weight;
		
		public Node(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
		}
		
	}
	
	// 다익스트라 구현하는 법.
	// 더 큰 클래스로 다익스트라 클래스 만들어주고, 늘 했던것처럼 노드 클래스를 만들어준다
	// 단 노드 클래스는 left, right 가 아닌, 목적지와 가중치만. 양방향이면 뭐 두번 넣으면 되니까
	
	//그 후 그래프 초기화를 해준다.
	public graph(int v) {
		this.v = v;
		arr = new ArrayList<>(v);
		for(int i = 0 ; i < v ; i++) {
			arr.add(new ArrayList<>());
		}
	}
	
	//그리고 입력에 따른 간선을 추가해준다.
	public void addEdge(int start, int end, int weight) {
		arr.get(start).add(new Node(end, weight));
	}
	
	//그리고 다익스트라 구현
	//시작에 따른 각 정점까지 거리의 최솟값을 가진 배열을 리턴함.
	public int[] dijkstra(int start) {
		int[] length = new int[v]; // start에서 시작하는 짧은 거리 알려주는 배열
		boolean[] checked = new boolean[v]; // 들렀던 곳 체크
		PriorityQueue<Node> que = new PriorityQueue<>(); // 이걸 써야지
		
		Arrays.fill(length, Integer.MAX_VALUE); // 일단 초기 거리값 다 초기화
		length[start] = 0;	// 자기 자신은 0이고
		que.add(new Node(start, 0)); // 큐에 넣음
		
		while(!que.isEmpty()) {
			Node where = que.poll(); // 뽑아서
			int u = where.dest; // 목적지 세팅
			
			if(checked[u]) continue; // 목적지가 방문
			checked[u] = true;
			
			for(Node neighbor : arr.get(u)) { // u와 인접한 노드들 찾음.
				int v = neighbor.dest;
				int weight = neighbor.weight; // 찾은 노드의 이웃과 가중치를 가져오고
				//v -> 갈 노드, u -> 현재 노드
				//만약 갔던곳이 아니고, 길이가 최대 길이가 아니고,더 짧은 경로라면?
				//1-> 갔던곳이라면 다시 갈 필요가 없음. 흐름상 간 곳이 최단이기 때문
				//2-> u에 도달 못했는데 가버리면 길이가 max에서 이동해봣자 의미가 없음
				//3-> 지금 찾은 길이 더 짧으면 거기로 가겠다.
				if(!checked[v] && length[u] != Integer.MAX_VALUE && length[u] + weight < length[v]) {
					length[v] = length[u] + weight;
					que.add(new Node(v, length[v])); // 그 다음 이동한 노드에서 큐를 넣는다.
				}
				
				
			}
			
			
		}
		
		return length;
		
	}
	
	
}

public class Main {
	public static int N, M, T;
	public static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//정점 개수를 받고
		int V = 5;
		
		// 정점 개수만큼 그래프 할당 받고
		graph graph = new graph(V);
		
		//간선을 추가함.
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
		
		//그리고
		int[] distances = graph.dijkstra(0);

        // 결과 출력
        System.out.println("0번 노드에서 각 노드까지의 최단 거리:");
        for (int i = 0; i < V; i++) {
            System.out.println("노드 " + i + ": " + (distances[i] == Integer.MAX_VALUE ? "무한대" : distances[i]));
        }
	}	

}






```

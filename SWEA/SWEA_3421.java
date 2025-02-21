import java.util.*;
import java.io.*;
/*
* 30334kb, 1545ms
* 부분집합이 뭔지 모르겠고, 조합 다 구해서 안될때 조건 넣어서 구했습니다.
*
*/
public class Solution {
	public static int N,M; // 재료 개수, 안어울리는 조합ㄱ ㅐ수
	public static List<Integer> burger = new ArrayList<>(); // 현재 버거에 뭐 들어갓는지 리스트로 구현
	public static List<int[]> nomat = new ArrayList<>(); // 맛없는거 int[] 리스트 써버림
	public static boolean[] check; // 조합쓸려고 선언
	public static int answer; // 답
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int T = Integer.parseInt(br.readLine());
    	
    	for(int i = 1 ; i < T + 1 ; i++) {
    		answer = 1;
    		burger.clear(); // 다시 쓸 땐 항시 초기화 해줘야합니다.
    		nomat.clear();
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		N = Integer.parseInt(st.nextToken()); // 재료 개수
    		M = Integer.parseInt(st.nextToken()); // 노맛 개수
    		
    		
    		check = new boolean[N + 1]; // 체크도 선언
    		
    		
    		
    		for(int p = 0 ; p < M ; p++) {
    			st = new StringTokenizer(br.readLine()); 
    			int q = Integer.parseInt(st.nextToken()); // 노맛인게 2개씩 들어오니까 하나씩 받아서
    			int q2 = Integer.parseInt(st.nextToken());
    			nomat.add(new int[] {q,q2});  // 이런식으로 리스트에 넣어버림
    		}

    		for(int p = 1 ; p <= N ; p++) {
    			combi(1,p,0);  // 0일땐 무조건 되니까 answer를 1로 초기화했고, 1부터 조합을 찾음
    		}

    		
    		System.out.println("#" + i + " " + answer);
    	}
    	
    	
    	
    	
    }
    
    public static void combi(int start, int end, int cnt) {
    	if(cnt == end) {  // 버거를 다 찾았다면?
    		boolean check2 = true; // 이게 트루여야 정답 + 1
//    		for(int a : burger) { // 디버깅용
//    			System.out.print(a + " ");
//    		}
    		for(int q = 0 ; q < M ; q++) { // 노맛이라고 한거 배열 돌려서 그 2개씩 들어가있는지 다 체크해보는데
    			
    			int[] where = nomat.get(q); // 노맛 첫번째꺼 빼서
    			int b1 = where[0]; // b1 b2 에 넣어두고
    			int b2 = where[1];
    			if(burger.contains(b1) && burger.contains(b2)) { // 만약 버거 리스트에 들어가있으면?
//    				System.out.println(b1 + " " + b2); 
    				check2 = false;  // false라 정답 +1이 안됨
    				break; // 가지치기?
    			}
    		}
    		if(check2) { // 아무튼 위에를 잘 버티고 넘겼으면?
    			answer++; // 답 + 1
    		}
//    		System.out.println();
    		return;
    	}
    	
    	for(int i = start ; i <= N ; i++) { 아주 전형적인 조합
    		if(!check[i]) {
    			check[i] = true;
    			burger.add(i);
    			combi(i + 1 , end , cnt + 1);
    			check[i] = false;
    			burger.remove(burger.size() - 1);
    		}
    	}
    		
    		
    }
    
}

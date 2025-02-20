import java.util.*;
import java.io.*;
/*
 * 사용메모리 28012kb 1456ms
 * 스캐너 사용햇을때 2000ms 까지 올라갔던걸 br로 바꿔서 1450까지 내렸습니다.
 * 중간에 가지치기 하니까 오히려 시간이 올라버려서 잘못된 가지치기 였나 봐요..
 * 조합으로 풀었고 단순하게, 조합 다 뽑아서 그에 대한 칼로리와 맛 더해서 비교.
 * 
 */
public class Solution {
	public static int T,N,L; // 테스트케이스, 재료 개수, 제한 칼로리
	public static int[][] arr2;
	public static int answer;
	public static boolean[] check;

    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	
    	T = Integer.parseInt(br.readLine());
    	
    	for(int i = 1 ; i < T + 1; i++) {
    		answer = 0;
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken()); // 재료갯수, 칼로리 받고
    		L = Integer.parseInt(st.nextToken());
    		
    		arr2 = new int[N][2]; // 맛 , 칼로리
    		check = new boolean[N]; // 조합 쓰기 위한 것
    		
    		for(int j = 0 ; j < N ; j++) {
    			st = new StringTokenizer(br.readLine());
    			arr2[j][0] = Integer.parseInt(st.nextToken()); // 맛
    			arr2[j][1] = Integer.parseInt(st.nextToken()); // 칼로리
    		}
    		
    		for(int p = 1 ; p < N + 1 ; p++) {
    			combi(0,0,new ArrayList<>(), p);
    		}
    		
    		System.out.println("#" + i + " " + answer);
    	} 	
    	
    }
    
    public static void combi(int start, int cnt , List<Integer> arr, int limit) {
    	if(cnt == limit) { // 전 1개부터 5개까지 다 뽑을때 생각했습니다.
    		int kcal = 0;
    		int taste = 0;
    		for(int j = 0 ; j < arr.size() ; j++) {
    			kcal += arr2[arr.get(j)][1]; // 칼로리랑 맛 다 더하고
    			taste += arr2[arr.get(j)][0];
    		}
    		if(kcal <= L && answer < taste) {
    			answer = taste; // 조건에 맞으면 맛에 대한 답을 갱신.
    		}
    		return;
    	}
    	for(int i = start ; i < N ; i++) {
    		if(!check[i]) { // 뽑은거면 안뽑습니다.
    			arr.add(i); // 안뽑은거면 넣어요
    			check[i] = true;
    			combi(i + 1, cnt + 1 , arr, limit);
    			check[i] = false;
    			arr.remove(arr.size()-1);
    		}
    	}
    }
    
    
}

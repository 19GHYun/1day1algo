import java.util.*;
import java.io.*;
/* 메모리 54,168, 177ms
 * 최근에 dp를 재밌게 풀고있어서 dp로 구현 해보았습니다.
 * 남들보다 메모리랑 시간이 더 걸리긴 했네요
 * 
 * 
 */

public class Solution {
	public static int T,N,B,answer; // 테스트케이스, 점원의 수, 탑의 높이, 최종답
	public static int[] arr; // 점원 키 넣는 배열

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	T = Integer.parseInt(br.readLine());
    	
    	for(int j = 1 ; j <= T ; j++) {
    		answer = Integer.MAX_VALUE;
    		
    		st = new StringTokenizer(br.readLine());
    		
    		N = Integer.parseInt(st.nextToken());
    		
    		B = Integer.parseInt(st.nextToken());
    		
    		arr = new int[N];
    		
    		st = new StringTokenizer(br.readLine());
    		
    		for(int i = 0 ; i < N ; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		HashSet<Integer> dp = new HashSet<>();
    		dp.add(0); // 초기 합 0
    		for (int i = 0; i < N; i++) {
    		    HashSet<Integer> next = new HashSet<>(dp); // 복사해서 쓰는거 아주 중요합니다.
    		    for (int sum : dp) { 
    		        next.add(sum + arr[i]);// 점원 키가 1 3 3 5 라면 각각일때 더해짐.
    		    }
    		    dp = next;
    		}
/*
 * 위 코드 예시를 들어보자.
 * 일단 키가 0일때 넣어주고 (필수)
 * 직원들 키가 1 2 3 이라면
 * 첫 직원 들어가고 가능한 키는 0 1.
 * 두번째 직원(2) 들어가고 가능한 키는 0 1 (0 + 2 ) (1 + 2) 로 0 1 2 3
 * 세번째 직원(3) 들어가고 가능한 키는 0 1 2 3 (0 + 3) (1 + 3) ( 2 + 3)( 3 + 3) 
 * 해쉬셋이니 중복은 사라지고 0 1 2 3 4 5 6 이 된다.
 * 가능한 키를 다 모음.
 */
    		int minDiff = Integer.MAX_VALUE;
    		for (int sum : dp) {
    		    if (sum >= B) {
    		        minDiff = Math.min(minDiff, sum - B);
    		    }
    		}
    		answer = minDiff;
    		
    		
    		System.out.println("#" + j + " " + answer);
    	}
    	
    	
    	
    }
    
}



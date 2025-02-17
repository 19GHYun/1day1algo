import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = Integer.MAX_VALUE;	//구역갯수, 정답
    static int[] person;	//그 구역에 있는 사람의 수
    static int [][] arr;	// dfs쓰기 위한 배열
    static boolean[] checked; // dfs 쓰기 위한 checked

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());	// 지역수 받고
    	arr = new int[N + 1][N + 1];			// 그만큼 배열 생성하고
    	person = new int[N + 1];				// 그만큼 사람 수 넣을 배열 생성하고
    	checked = new boolean[N + 1];			// checked 도 생성
    	
    	st = new StringTokenizer(br.readLine());
    	
    	for(int i = 1 ; i < N + 1 ; i++) {
    		person[i] = Integer.parseInt(st.nextToken()); // 각 지역에 사람수 넣어줌.
    	}
    	
    	for(int i = 1 ; i < N + 1 ; i++) {
    		st = new StringTokenizer(br.readLine()); 	// 줄넘김 받고
    		
    		int cnt = Integer.parseInt(st.nextToken()); // 몇개 받을지 받고
    		
    		for(int j = 1 ; j < cnt + 1 ; j++) {
    			int size = Integer.parseInt(st.nextToken()); // 그 i번째가 누구랑 이어져 있는지 배열로 저장
    			
    			arr[i][size] = 1;
    			arr[size][i] = 1;
    			
    		}
    		

    		
    	}
    	
    	find_all_sit(1);			// 이번 코드의 AtoZ 아래에서 설명
    	if(answer == Integer.MAX_VALUE) {	//답
    		System.out.println(-1);
    	}else {
    		System.out.println(answer);
    	}
    	
    	
    	
    	
    }
    
    public static void find_all_sit(int start) {		// 구현한게 뭔가 백트래킹 비슷한 느낌이 납니다.
    	if(start == N + 1) {	// checked를 이용해서 선거구에 누가 누가 들어갈지 나눴습니다. checked가 N+1에 도달하면,
    		List<Integer> seongaegu_A = new ArrayList<>();	//A 선거구 B 선거구를 만듭니다.
    		List<Integer> seongaegu_B = new ArrayList<>();
    		
    		for(int i = 1 ; i < N + 1 ; i++) {	// True 면 A, false 면 B로 넣었습니다.
    			if(checked[i]) {
    				seongaegu_A.add(i);
    			}else {
    				seongaegu_B.add(i);
    			}
    		}
    		
    		if(Connected(seongaegu_A) && Connected(seongaegu_B)) {	// A랑 B 선거구가 잘 연결되어 있는지 확인합니다.
    			int ans = Math.abs(sum(seongaegu_A) - sum(seongaegu_B));	// 둘중 작은걸 최종 답안으로 설정합니다.
    			answer = Math.min(answer, ans);
    		}
    		return;  // 이걸 안해서 오류(스택 오버플로우)가 떳습니다. 실수가 참 많습니다.
    		
    	}
    	
    	checked[start] = true;	//트리구조 느낌으로 들어갑니다. 처음엔 이해를 못했는데(static 인데 이래도 괜찮나?) 직접 그려보니까 이해가 되더라구요
    	find_all_sit(start + 1);
    	
    	checked[start] = false;
    	find_all_sit(start + 1);
    }
    
    public static void dfs(int jiyeok, List<Integer> seongaegu, boolean[] localcheck) {	//dfs. 여기서는 선거구 끼리 연결되어있는지 확인하는 용도로 쓰인다.
    	localcheck[jiyeok] = true;
    	for(int i = 1 ; i < N + 1 ; i++) {
    		if(arr[jiyeok][i] == 1 && seongaegu.contains(i) && !localcheck[i] ) {	
    			dfs(i, seongaegu, localcheck);
    		}
    	}
    	
    	
    }
        
    
    public static boolean Connected(List<Integer> seongaegu) {	// 그 선거구에 있는 지역이 연결되어있는지 확인합니다.
    	
    	if(seongaegu.isEmpty()) {  // 비어있으면 안됩니다.
    		return false;
    	}
    	
    	boolean[] localcheck = new boolean[N + 1]; // 객체로 만들어서 사용
    	dfs(seongaegu.get(0), seongaegu, localcheck);	// 이걸 이용해서 서로 이어져 있는지 확인하고
    	
    	
    	for(int i : seongaegu) {
    		if(!localcheck[i]) {	//안 이어져 있으면 false, 이어져있으면 true 줍니다.
    			return false;
    		}
    	}
    	
    	return true;
    	
    }
    
    public static int sum(List<Integer> seongaegu) {	// person 배열 사용해서 그 선거구의 사람 수를 구하고 return 해줍니다.
    	int sum = 0;
    	for(int i : seongaegu) {
    		sum += person[i] ;
    	}
    	
    	
    	return sum;
    }
    
}

import java.util.*;
import java.io.*;


/*
 * 아이디어
 * card를 boolean으로 만들어서 인영이가 뽑은 카드를 true로 하고 나머지를 규영이한테 줌
 * 
 * 그 후 T받고 배열과 cnt를 인자값으로 줘서 perm은 아니지만 perm 함수를 재귀하여 경우의 수를 구함
 * 그 후 for문 돌려서 각 각 카드 비교해서 포인트를 올리고 내리고 해 준 다음, 포인트 높은 친구 ++ 해줌.
 * 
 */

public class Solution {
	public static int T; 
	public static int arr[], gy_card[], iy_card[];
	public static int gy_point, iy_point,gy_ans, iy_ans ;
	public static boolean check[];

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();	// 테스트케이스 받고
		

		
		for(int i = 1 ; i < T  +1 ; i++) {	
			gy_ans = 0;	//값 초기화들 해줍니다.
			iy_ans = 0;
			int check_num = 0; // 규영이 카드 넣을때 쓰는 용도
			
			boolean[] card = new boolean[19]; // 카드 생성
			check = new boolean[9]; // 뽑은거 또 뽑으면 안되니까 check 초기화

			
			gy_card = new int[9]; // 규영이랑 인영이 카드 넣을곳 만들어주고
			iy_card = new int[9];
			int[] gy_new_card = new int[9]; // 새롭게 담을곳을 하나 더 만들어서 백트래킹으로 쓸 예정.
			
			for(int j = 0 ; j < 9 ; j++) { // 인영이 카드 넣어주고
				int q = sc.nextInt();
				iy_card[j] = q;
				card[q] = true;
			}
			
			for(int j = 1 ; j < 19 ; j++) { // card에서 false인거만 규영이 카드에 넣었습니다.
				if(!card[j]) {
					gy_card[check_num] = j;
					check_num++;
				}
			}
			
			perm(0, gy_new_card); // arr를 매개변수로 줬습니다.
					
			
			System.out.println("#" + i + " " + iy_ans + " " + gy_ans);
		}
		
	}
	
	public static void perm(int cnt, int[] arr) {
		if(cnt == 9) {	// 9개 다 뽑았으면
			gy_point = 0; // 포인트 초기화 해 주고
			iy_point = 0;
			for(int i = 0 ; i < 9 ; i++) { // 서로 9장 뽑고 듀얼 합니다
				if(arr[i] > iy_card[i]) {
					gy_point = gy_point + arr[i] + iy_card[i];
				}
				else if(arr[i] < iy_card[i]) {
					iy_point = iy_point + arr[i] + iy_card[i];
				}
				else {
					
				}
			}
			if(gy_point > iy_point) { // 아무튼 포인트 더 많은애 ++ 해줬습니다.
				gy_ans++;
			}
			else if(gy_point < iy_point) {
				iy_ans++;
			}
			return;
		}
		for(int i = 0 ; i < 9  ; i++) {	// 백?트래킹 느낌으로 했다고 칩시다
			if(!check[i]) {
				arr[cnt] = gy_card[i]; // 카드 받았던 배열에 넣고
				check[i] = true; // check 해주고
				perm(cnt + 1, arr); // 다시 넣어버림
				check[i] = false; // 그리고 check[i] 는 false로
				
			}
			
		}
		
	}
	

}

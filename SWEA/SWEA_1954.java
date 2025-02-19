import java.util.*;
import java.io.*;
/*
 * 풀이과정따윈 없다.
 * 대신 잘 보면 보험을 든 구간이 있는데, 이를 이용해서 달팽이를 잘 몰라도 쉽게 구현했다.
 * 대신 실행시간이 좀 오래걸렸다.
 * 
 */

public class Solution {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in); // 남자의 상징 스캐너를 썼습니다.
		
		int T = sc.nextInt();
		
		
		for(int p = 1 ; p < T + 1 ; p++) {
			
			int a = sc.nextInt();
			
			int num = 1;
			
			int[][] arr = new int[a][a];
			
			for(int i = 0 ; i < a / 2 ; i++) {
				for(int j = i ; j < a - i ; j++) {
					if(arr[i][j] != 0) {
						continue;
					}
					arr[i][j] = num; // 오른쪽
					num++;
					if(j == a - 1 - i) {
						for(int x = i + 1 ; x < a - i ; x++) {
							if(arr[j][x] != 0) {
								continue;
							}
							arr[x][j] = num; // 아래
							num++;
						}
					}
				}
				
				for(int j = a -1 -i ; j >= i ; j--) {
					if(arr[a-1-i][j] != 0) {
						continue;
					}
					arr[a-1-i][j] = num; // 왼쪽
					num++;
					if(j == i) {
						for(int x = a - 1 - i ; x >= i ; x--) {
							if(arr[x][j] != 0) {
								continue; 
							}
							arr[x][j] = num; // 위로
							num++;
						}
					}
				}
				
				
			}
			if(a %2 == 1) {
				arr[a/2][a/2] = num;	// 홀수면 가운대가 비게되는데, 이걸 채워줍니다.
			}
			
			
			
			
			System.out.println("#" + p );
			for(int i = 0 ; i < a ; i++) {
				for(int j = 0 ; j < a ; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
			
		}

		
		
	}
	
}

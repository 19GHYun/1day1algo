import java.util.*;

/*
*사실 처음 입력받는 숫자가 몇개 입력받는지 알려주는거라 이걸 먼저 알았다면 더 쉽게 풀었을텐데
*모른 상태에서 풀어서 좀 이상하긴 합니다만, 답은 맞긴 했습니다.
*
*
*
*
*/


public class Main {
	
	static String[] a;	//전역으로 선언합니다.
	static String[] b;
	
	public static void main(String arg[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int round = Integer.parseInt(sc.nextLine()); // 개행문자때문에 이렇게 
		
		int a_star = 0;	//a와 b 카드들 구분하기 위해 다 선언 했습니다.
		int b_star = 0;
		int a_circle = 0;
		int b_circle = 0;
		int a_tri = 0;
		int b_tri = 0;
		int a_rect = 0;
		int b_rect = 0;
		
		
		String a_enter;	//처음 a b 가 입력받는걸 구하고 빈칸으로 나눠서 switch를 통해 각 a와 b의 별 동그라미 삼각형 사각형 수를 구했습니다.
		String b_enter;
		
		for(int i = 0 ; i < round ; i++) {
			
			a_enter = sc.nextLine();
			b_enter = sc.nextLine();
			
			a = a_enter.split(" ");
			b = b_enter.split(" ");
			
			a[0] = "0";	//처음 수는 몇개 받을건지 내용인데, 이걸 모르고 풀다가 필요없는 정보인걸 알아내서.. 처음 들어오는건 0으로 바꿨습니다.(5일때도 있어가지고..)
			b[0] = "0";
			
			for(int j = 0 ; j < a.length ; j++) {	//여기서부터 각 숫자를 확인해서 맞는 변수에 1씩 더해줬습니다.
				switch(a[j]) {
					case"4":
						a_star++;
						break;
					case"3":
						a_circle++;
						break;					
					case"1":
						a_tri++;
						break;
					case"2":
						a_rect++;
						break;
				
				}
			}
			
			for(int j = 0 ; j < b.length ; j++) {	//b도 더해줍니다.
				switch(b[j]) {
					case"4":
						b_star++;
						break;
					case"3":
						b_circle++;
						break;					
					case"1":
						b_tri++;
						break;
					case"2":
						b_rect++;
						break;
				
				}
			}
			
			if(a_star > b_star) {	//조건이 단순 구현이라.. 이렇게 짰습니다다
				System.out.println("A");
			}
			else if(a_star < b_star) {
				System.out.println("B");
			}else {
				if(a_circle > b_circle) {
					System.out.println("A");
				}
				else if(a_circle < b_circle) {
					System.out.println("B");
				}else {
					if(a_rect > b_rect) {
						System.out.println("A");
					}
					else if(a_rect < b_rect) {
						System.out.println("B");
					}else {
						if(a_tri > b_tri) {
							System.out.println("A");
						}
						else if(a_tri < b_tri) {
							System.out.println("B");
						}else {
							System.out.println("D");
						}
					}
				}
			}
			Arrays.fill(a, "0");	//하고나선 잘 초기화 해줘야합니다.
			Arrays.fill(b, "0");
			a_star = 0;
			b_star = 0;
			a_circle = 0;
			b_circle = 0;
			a_tri = 0;
			b_tri = 0;
			a_rect = 0;
			b_rect = 0;
		}
		
//		for(int i = 0 ; i < a.length ; i++) {	//잘 split 된지 확인하는 곳이였습니다.
//			System.out.print(a[i]);
//		}
//		
//		System.out.println();
//		
//		for(int i = 0 ; i < b.length ; i++) {
//			System.out.print(b[i]);
//		}
		
	}
}

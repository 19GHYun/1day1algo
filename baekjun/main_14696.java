import java.util.*;

public class Main {
	
	static String[] a;
	static String[] b;
	
	public static void main(String arg[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int round = Integer.parseInt(sc.nextLine()); // 개행문자때문에 이렇게 
		
		int a_star = 0;
		int b_star = 0;
		int a_circle = 0;
		int b_circle = 0;
		int a_tri = 0;
		int b_tri = 0;
		int a_rect = 0;
		int b_rect = 0;
		
		
		String a_enter;
		String b_enter;
		
		for(int i = 0 ; i < round ; i++) {
			
			a_enter = sc.nextLine();
			b_enter = sc.nextLine();
			
			a = a_enter.split(" ");
			b = b_enter.split(" ");
			
			a[0] = "0";
			b[0] = "0";
			
			for(int j = 0 ; j < a.length ; j++) {
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
			
			for(int j = 0 ; j < b.length ; j++) {
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
			
			if(a_star > b_star) {
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
			Arrays.fill(a, "0");
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
		
//		for(int i = 0 ; i < a.length ; i++) {
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

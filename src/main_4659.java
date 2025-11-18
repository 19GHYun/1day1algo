import java.util.*;

public class Main {
	
	static int[] alpha = new int[26];
	static boolean ok = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean end = false;
		
		Scanner sc = new Scanner(System.in);
		
		while(end == false) {
			String b;
			String a = sc.next();
			
			a.toLowerCase();
			
			if(a.equals("end")) {
				end = true;
				break;
			}
			
			check_moum(a);
			check_threego(a);
			check_doublego(a);
			

				
			
			if(!ok) {
				System.out.println("<" + a + "> is not acceptable.");
			}else {
				System.out.println("<" + a + "> is acceptable.");
			}

			
			for(int i = 0 ; i < 26 ; i++) { // 초기화
				alpha[i] = 0;
			}
			ok = false;
			
		}
		
	}
	
	public static void check_doublego(String a) {
		int last_num = 999;
		
		for(int i = 0 ; i < a.length(); i++) {
			if(last_num == 999) {
				last_num = a.charAt(i)-97;
			}
			else if(last_num == a.charAt(i)-97) {
				if(a.charAt(i)-97 == 4 || a.charAt(i)-97 == 14 ) {
					continue;
				}
				else {
					ok = false;
					//System.out.println(a +" 2개 체크에서 터짐");
					break;
				}
			}
			else {
				last_num = a.charAt(i)-97;
			}
		}
		
		
	}
	
	public static void check_moum(String a) {
		for(int i = 0 ; i < a.length(); i++) {
			alpha[a.charAt(i) - 97]++;
		}
		if((alpha[0] >= 1) || (alpha[4] >= 1) || (alpha[8] >= 1) || (alpha[14] >= 1) || (alpha[20] >= 1)) {
			ok = true;

		}
		else {
			ok = false;
			//System.out.println(a +" 체크 모음에서 터짐");

		}
	}
	public static void check_threego(String a) {
		int jaum = 0;
		int moum = 0;
		
		for(int i = 0 ; i < a.length(); i++) {
			if((a.charAt(i) - 97 == 0) || (a.charAt(i) - 97 == 4) || (a.charAt(i) - 97 == 8) || (a.charAt(i) - 97 == 14) || (a.charAt(i) - 97 == 20)) {
				//모음이면
				jaum = 0;
				moum++;
			}else {
				//자음이면
				moum = 0;
				jaum++;
			}
			if(moum == 3 || jaum == 3) {
				ok = false;
				//System.out.println(a +" 3개 체크에서 터짐");
				break;
			}
			
		}
		
	}

}

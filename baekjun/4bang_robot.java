
import java.util.*;
import java.io.*;


public class main_13300 {
	static int answer = 0;
	static String yard[][];
	static int ax;
	static int ay;
	static int size;
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		
		int times = sc.nextInt();

		int test_num;
		
		
		
		
		for(int i =1 ; i < times+1 ; i++) {
			answer = 0;
			size = sc.nextInt();
			
			yard = new String[size][size];
			
			for(int j = 0 ; j < size ; j++) {
				for(int k = 0 ; k < size ; k++) {
					yard[j][k] = sc.next();
				}
			}
			
			for(int j = 0 ; j < size ; j++) {
				for(int k = 0 ; k < size ; k++) {
					if(yard[j][k].equals("A")) {
						ax = k;
						ay = j;
						check_right(yard);
					}
					if(yard[j][k].equals("B")) {
						ax = k;
						ay = j;
						check_right(yard);
						ax = k;
						ay = j;
						check_left(yard);
					}
					if(yard[j][k].equals("C")) {
						ax = k;
						ay = j;
						check_right(yard);
						ax = k;
						ay = j;
						check_left(yard);
						ax = k;
						ay = j;
						check_high(yard);
						ax = k;
						ay = j;
						check_low(yard);
					}

					
				}
			}
			
			
			System.out.println("#" + i + " " + answer);
		}
		
	}
	
	public static void check_right(String[][] yard) {
		if(ax == size - 1) {
			return;
		}

		while(true) {
			ax++;
			if(yard[ay][ax].equals("S")) {
				//System.out.println(ay + " " + ax);
				answer++;
			}
			if(ax == size-1) {
				break;
			}
			if(yard[ay][ax].equals("W") || yard[ay][ax].equals("A") || yard[ay][ax].equals("B") || yard[ay][ax].equals("C")) {
				break;
			}
		}
	}
	public static void check_left(String[][] yard) {
		if(ax == 0) {
			return;
		}
		
		while(true) {
			ax--;
			if(yard[ay][ax].equals("S")) {
				//System.out.println(ay + " " + ax);
				answer++;
			}
			if(ax == 0) {
				break;
			}
			if(yard[ay][ax].equals("W") || yard[ay][ax].equals("A") || yard[ay][ax].equals("B") || yard[ay][ax].equals("C")) {
				break;
			}
		}
	}
	
	public static void check_low(String[][] yard) {
		if(ay == size-1) {
			return;
		}

		while(true) {
			ay++;
			if(yard[ay][ax].equals("S")) {
				//System.out.println(ay + " " + ax);
				answer++;
			}
			if(ay == size-1) {
				break;
			}
			if(yard[ay][ax].equals("W") || yard[ay][ax].equals("A") || yard[ay][ax].equals("B") || yard[ay][ax].equals("C")) {
				break;
			}
		}
	}
	
	public static void check_high(String[][] yard) {
		if(ay == 0) {
			return;
		}
		
		while(true) {
			ay--;
			if(yard[ay][ax].equals("S")) {
				//System.out.println(ay + " " + ax);
				answer++;
			}
			if(ay == 0) {
				break;
			}
			if(yard[ay][ax].equals("W") || yard[ay][ax].equals("A") || yard[ay][ax].equals("B") || yard[ay][ax].equals("C")) {
				break;
			}
		}
	}
}

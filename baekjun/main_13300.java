import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		
		int human = sc.nextInt();
		int room = sc.nextInt();
		
		int[] girl = new int[7];
		int[] man = new int[7];
		
		int total_room = 0;
		int check_mg;
		int check_grade;
		
		for(int i = 0 ; i < human ; i++) {
			check_mg = sc.nextInt();
			check_grade = sc.nextInt();
			
			if(check_mg == 0) {
				girl[check_grade]++;
			}
			else if(check_mg == 1) {
				man[check_grade]++;
			}
			
		}
		
//		for(int i = 1 ; i < 7 ; i++) {
//			System.out.print(girl[i] + " ");
//		}
//		System.out.println();
//		for(int i = 1 ; i < 7 ; i++) {
//			System.out.print(man[i] + " ");
//		}
		
		for(int i = 1 ; i < 7 ; i++) {
			while(true) {
				if(girl[i] > 0) {
					girl[i] -= room;
					total_room++;
				}
				if(man[i]>0) {
					man[i] -= room;
					total_room++;
				}
				
				if(man[i] <= 0 && girl[i] <= 0) {
					break;
				}
			}

		}
		
		System.out.println(total_room);
		
	}
}

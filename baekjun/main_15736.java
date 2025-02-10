import java.util.*;
import java.io.*;

public class Main {
	public static int answer;
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		answer = 0;
		
		check(num);
		
		System.out.print(answer);
		
		

	}
	
	public static void check(int flag) {
		int start = 2;
		
		flag--;
		answer++;
		
		while(true) {
			flag = flag - answer * 2;
			
			if(flag <= 0) {
				break;
			}
			answer++;
			flag--;
		}
		
		
		
	}
	

}

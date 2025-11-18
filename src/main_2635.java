import java.io.*;
import java.util.*;

public class Main {

	static int answer = 2;
	static int real_answer = 1;
	static int num_answer = 0;
	static int good_second_num;
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int a = sc.nextInt(); // 시작 수
    	
    	for(int i = 0 ; i <= a ; i++) {
    		calc(a,i,i);
    	}
    	System.out.println(real_answer);
    	//System.out.println(good_second_num);
    	
    	System.out.print(a + " " + good_second_num + " ");
    	calc_print(a,good_second_num);
    	
    	

    	
    	
    }
    public static void calc(int first_num, int second_num, int check) {
    	int end_num = first_num - second_num;
    	if(end_num < 0) {
    		if(real_answer < answer) {
    			real_answer = answer;
    			answer = 2;
    			good_second_num = check;
    			
    		}
    		else {
    			answer = 2;
    		}
    	}
    	else {
    		answer++;
    		calc(second_num, end_num, check);
    	}
    	
    }
    public static void calc_print(int first_num, int second_num) {
    	int end_num = first_num - second_num;
    	
    	if(end_num < 0) {

    	}
    	else {
    		System.out.print(end_num+" ");
    		calc_print(second_num, end_num);
    	}
    }
    


}

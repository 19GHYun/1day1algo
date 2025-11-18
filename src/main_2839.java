import java.util.*;
import java.io.*;

public class Main {

	static int time = 0;
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	
    	int bongji = 0;
    	
    	int N = sc.nextInt();
    	
    	if(N == 1) {
    		System.out.print("-1");
    		return;
    	}
    	if(N == 2) {
    		System.out.print("-1");
    		return;
    	}
    	if(N == 3) {
    		System.out.print("1");
    		return;
    	}
    	if(N == 4) {
    		System.out.print("-1");
    		return;
    	}
    	if(N == 5) {
    		System.out.print("1");
    		return;
    	}
    	if(N == 6) {
    		System.out.print("2");
    		return;
    	}
    	if(N == 7) {
    		System.out.print("-1");
    		return;
    	}
    	if(N == 8) {
    		System.out.print("2");
    		return;
    	}
    	if(N == 9) {
    		System.out.print("3");
    		return;
    	}
    	if(N == 10) {
    		System.out.print("2");
    		return;
    	}
    	

    	
    	if(N % 10 == 2 ) {
    		N = N - 3 * 4; 
    		bongji += 4;
    		
    		bongji += N / 5; 
    	}
    	else if(N % 10 == 1 ) {
    		N = N - 3 * 2; 
    		bongji += 2;
    		
    		bongji += N / 5; 
    	}
    	else if(N % 10 == 3) {
    		N = N - 3;
    		bongji++;
    		bongji += N/5;
    	}
    	else if(N % 10 == 4) {
    		N = N - 9;
    		bongji +=3;
    		bongji += N/5;
    	}
    	else if(N % 10 == 5) {
    		bongji = N/5;
    	}
    	else if(N % 10 == 6) {
    		N = N - 6;
    		bongji +=2;
    		bongji += N/5;
    	}
    	else if(N % 10 == 7) {
    		N = N - 12;
    		bongji +=4;
    		bongji += N/5;
    	}
    	else if(N % 10 == 8) {
    		N = N - 3;
    		bongji++;
    		bongji += N/5;
    	}
    	else if(N % 10 == 9) {
    		N = N - 9;
    		bongji += 3;
    		bongji += N/5;
    	}
    	else if(N % 10 == 0) {
    		bongji = N/5;
    	}
    	
    	System.out.print(bongji);
    	
    	
    	sc.close();
        
    	
        
    }
    
}

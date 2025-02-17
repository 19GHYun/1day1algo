import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int K = sc.nextInt(); // 랜선 개수
        int N = sc.nextInt(); // 필요한 개수
        
        int max = 0;
        
        int[] ransun = new int[K];
        
        for(int i = 0 ; i < K ; i++) {
        	ransun[i] = sc.nextInt();
        	if(max < ransun[i]) {
        		max = ransun[i];
        	}
        }
        
        long start = 0;
        long end = max;
        
        while(start <= end) {
        	long mid = (start+end) / 2;
        	if(mid == 0) {
        		break;
        	}
        	long smallransun = 0;
        	
        	for(int cat4 : ransun) {
        		smallransun += cat4 / mid ;
        		
        	}
        	if(smallransun >= N) {
        		start = mid + 1;
        	}else {
        		end = mid - 1;
        	}
        	
        }
        System.out.println(end);
        
        
    }
}

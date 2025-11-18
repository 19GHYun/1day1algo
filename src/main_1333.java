import java.util.*;
import java.io.*;

public class Main {
	public static int L, N, D; // 노래길이, 총노래갯수, 전화벨 울리는 레이턴시
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 노래갯수
        L = sc.nextInt(); // 노래길이
        D = sc.nextInt(); // 레이턴시 
        
        boolean phone_ok = false; // 전화벨 받을수 있을 때를 알림
        boolean norae = false;  // 노래 다 들엇으면true
        boolean jeonhwa = false; // 전화받을수있으면 true
        int i = 0 ; // 시간초
        int j = 0 ; // 노래갯수
        
        while(true) {
        	j = i / (L + 5);
        	
        	if( j >= N) {
        		//System.out.println("노래다들어서 ok " + i);
        		phone_ok = true;
        	}else {
            	if( (i % (L + 5)) >= L && (i % L + 5 ) < ( L + 5) ) {
            		phone_ok = true;
            		//System.out.println("노래 ok " + i);
            	}else {
            		phone_ok = false;
            	}
        	}

        	

        	if(i % D == 0) {
        		jeonhwa = true;
        		//System.out.println("핸드폰 ok " + i);
        	}
        	else {
        		jeonhwa = false;
        	}
        	
        	

        	
        	
        	if(phone_ok && jeonhwa) {
        		System.out.println(i);
        		break;
        	}
        	
        	i++;
        	
        	
        	
        }
    }
}

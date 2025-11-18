import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String find_st = br.readLine();
        
        int T = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for(int i = 0 ; i < T ; i++) {
        	String st = br.readLine();
//        	System.out.println(st);
        	for(int j = 0 ; j < 10 ; j++) {
            	if(st.contains(find_st)) {
            		answer++;
            		break;
            	}else {
            		st = back_to_front(st);
            		
//            		System.out.println(st);
            	}
        	}

        	
        }
        System.out.println(answer);

        
    }
    
    public static String back_to_front(String str) {
    	//어차피 10개. 맨뒤 때서 개 노가다로 만들어도 될듯?
    	StringBuilder sb2 = new StringBuilder();
    	
    	char back_char = str.charAt(9);
    	
    	String str2 = str.substring(0,9);
    	
    	sb2.append(back_char);
    	sb2.append(str2);

    	
    	
    	return sb2.toString();
    }
}

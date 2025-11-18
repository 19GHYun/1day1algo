import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        
        String kill = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        
        Character c = kill.charAt(kill.length() - 1);
        
        for(int i = 0 ; i < a.length() ; i++) {
        	char b = a.charAt(i);
        	 stack.push(b);
        	
        	if( b == c) { // 같은거 나오면 kill 길이만큼 뒤로 가서 체크
        		boolean check = false;
        		for(int j =1 ; j <= kill.length() ; j++ ) {
        			if(stack.search(kill.charAt(kill.length()-j )) == j) {
        				
        			}else {
        				check = true;
        				break;
        			}
        		}
        		if(!check) {
        			for(int j = 0 ; j < kill.length() ; j++) {
        				stack.pop();
        			}
        		}
        		
        	}
        	
        }
      
        if(stack.isEmpty()) {
        	System.out.println("FRULA");
        }
        else {
        	StringBuilder sb = new StringBuilder();
        	while (!stack.isEmpty()) {
        	    sb.append(stack.pop()); // 5 4 3 2 1 순으로 들어감
        	}
        	sb.reverse(); // 1 2 3 4 5로 뒤집음
        	System.out.println(sb);
        }
        

        
    }
    
    
    
}

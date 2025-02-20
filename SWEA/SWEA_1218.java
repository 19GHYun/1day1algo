import java.util.*;

/*
 * 27136kb, 113ms
 * 아이디어
 * 비어있는데 > } ) ] 들어가면 끝냄.(가지치기)
 * ( < { [ 는 일단 하이패스로 스택에 넣음.
 * ) } > ] 일때, peek과 같으면 pop.
 */

public class Solution {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);	// 얘떄문에 시간 좀 늘어난듯
    	Stack<Character> stack = new Stack<>(); // 괄호 넣을 곳
    	int answer = 0; // 일단 답 선언
    	
    	for(int i = 1 ; i < 11 ; i++) { // 10번반복
    		answer = 1; //일단 1로주고, 틀리면 0으로 바꾼다음 break
    		stack.clear(); // 깔끔하게 써야하지 않겠습니까?
    		int a = sc.nextInt(); // 갯수 받고
    		
    		String b = sc.next(); // 문자열로 받아서 charat 씀.
    		
    		for(int j = 0 ; j < a ; j++) {
    			if(stack.isEmpty()){ // 가지치기
    				if(b.charAt(j) == ')' || b.charAt(j) == '}' || b.charAt(j) == ']' || b.charAt(j) == '>') {
    					answer = 0;
    					break;
    		
    				}else {
    					stack.push(b.charAt(j));
    				}
    			}
    			else if(b.charAt(j) == '(' || b.charAt(j) == '{' || b.charAt(j) == '[' || b.charAt(j) == '<' ) {
    				stack.push(b.charAt(j)); // ( < { [ 하이패스로 넣기
    			}
    			else if(b.charAt(j) == ')' || b.charAt(j) == '}' || b.charAt(j) == ']' || b.charAt(j) == '>') {
    				if(stack.peek() == '(' && b.charAt(j) == ')') { // peek과 다르면 컷
    					stack.pop();
    				}
    				else if(stack.peek() == '{' && b.charAt(j) == '}') {
    					stack.pop();
    				}
    				else if(stack.peek() == '[' && b.charAt(j) == ']') {
    					stack.pop();
    				}
    				else if(stack.peek() == '<' && b.charAt(j) == '>') {
    					stack.pop();
    				}
    				else {
    					//System.out.println(j+"일떄 브레이크");
    					answer = 0;
    					break;
    				}

    			}
    		}
    		System.out.println("#"+i + " " + answer);

        }
    }
    
}

import java.util.*;
import java.io.*;

public class Main {

	static int time = 0;
	
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        
        int potab = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[potab];
        Stack<Integer> stack = new Stack<>();
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < potab ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[potab];
        
        for(int i = 0 ; i < potab ; i++) {
        	while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
        		stack.pop();
        	}
        	
        	if(stack.isEmpty()) {
        		answer[i] = 0;
        		stack.push(i);
        	}
        	else {
        		answer[i] = stack.peek() + 1;
        		stack.push(i);
        	}
        }

        

        
        for(int i = 0 ; i < potab ; i++) {
        	sb.append(answer[i]+ " ");
        }
        
        System.out.print(sb);

        
    }
    
}

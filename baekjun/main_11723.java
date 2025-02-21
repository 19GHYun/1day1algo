import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] asd;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int num = Integer.parseInt(br.readLine());
    	
    	int cur = 0;
    	
    	for(int i = 0 ; i < num ; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int b = 0;
    		String a = st.nextToken();
    		if(a.equals("all") || a.equals("empty")) {
    			
    		}else {
    			b = Integer.parseInt(st.nextToken());
    		}
    		
    		
    		switch(a){
    		case"add":
    			cur = cur | (1 << b);
    			break;
    		
    		case"remove":
    			cur &=~(1<<b) ;
    			break;
    			
    		case"check":
    			if ((cur & (1 << b)) != 0) {
    			    sb.append(1);
    			    sb.append("\n");
    			}else {
    				sb.append(0);
    				sb.append("\n");
    			}
    			break;
    			
    		case"toggle":
    			cur^=(1<<b);
    			break;
    			
    		case"all":
    			cur = cur | ( 1 << 21) - 1;
    			break;
    			
    		case"empty":
    			cur = 0;
    			break;
    		}
    		
    	}
    	
    	System.out.println(sb.toString());
    	
    }

}

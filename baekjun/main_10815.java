import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
        	set.add(Integer.parseInt(st.nextToken()));
        }
        
        M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < M ; i++) {
        	if(set.contains(Integer.parseInt(st.nextToken()))) {
        		sb.append(1).append(" ");
        	}else {
        		sb.append(0).append(" ");
        	}
        	
        }
        System.out.println(sb.toString());
        
    }

}

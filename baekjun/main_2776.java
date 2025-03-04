import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int j = 0 ; j < T ; j++) {
        	sb.setLength(0);
            int sucheop1 = Integer.parseInt(br.readLine());
            Set<Integer> arr_1 = new HashSet<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 0 ; i < sucheop1 ; i++) {
            	arr_1.add(Integer.parseInt(st.nextToken()));
            }
            
            int sucheop2 = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());

            for(int i = 0 ; i < sucheop2 ; i++) {
            	if(arr_1.contains(Integer.parseInt(st.nextToken()))) {
            		sb.append(1);
            		sb.append("\n");
            	}
            	else {
            		sb.append(0);
            		sb.append("\n");
            	}
            }
            
            System.out.print(sb.toString());
        }
        

        
        
    }
}

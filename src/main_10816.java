import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        
        for(int i = 0 ; i < N ; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < M ; i++) {
        	int a = Integer.parseInt(st.nextToken());
        	if(map.get(a) == null) {
        		sb.append(0).append(" ");
        	}else {
        		sb.append(map.get(a)).append(" ");
        	}
        	
        	
        }
        System.out.println(sb.toString());
        
    }

}

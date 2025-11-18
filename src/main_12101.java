import java.util.*;
import java.io.*;

public class Main {
	public static int N,K;
	public static int cnt = 0;
	public static List<Integer> list = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	bact(0);
    	
    	
    	if(cnt < K) {
    		System.out.println(-1);
    	}
    	
    }
    
    public static void bact(int num) {
    	if(num == N) {
    		cnt++;
    		if(cnt == K) {
    			for(int i = 0 ; i < list.size() ; i++) {
    				System.out.print(list.get(i));
    				if(i == list.size() - 1) {
    					
    				}else {
    					System.out.print("+");
    				}
    				
    			}
    		}
    	}
    	if(num > N) {
    		return;
    	}
    	for(int i = 1 ; i <= 3 ; i++) {
    		list.add(i);
    		bact(num + i);
    		list.remove(list.size()-1);
    	}
    }
}

import java.util.*;
import java.io.*;


public class Main {
	public static int N,M;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	int answer[] = new int[M + 1];
    	
    	answer[0] = 0;
    	
    	for(int i = 1 ; i < M + 1 ; i++) {
    		answer[i] = 10000000;
    	}
    	
    	int coin[] = new int[N];
    	
    	for(int i = 0 ; i < N ; i++) {
    		coin[i] = Integer.parseInt(br.readLine());
    	}
    	
    	for(int i = 0 ; i < N ; i++) {
    		int use_coin = coin[i];
    		for(int j = use_coin ; j <= M  ; j ++) {
    			answer[j] = Math.min(answer[j], answer[j-use_coin] + 1);
    		}
    	}
    	
    	
    	if(answer[M] == 10000000) {
    		System.out.println(-1);
    	}else {
    		System.out.println(answer[M]);
    	}
    	
    	
    }
    
}



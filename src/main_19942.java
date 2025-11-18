import java.io.*;
import java.util.*;


public class Main {
    public static int N,N_dan,N_fat,N_tan,N_vita;
    public static int[] dan, fat, tan, vita, price;
    public static int answer = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        dan = new int[N];
        fat = new int[N];
        tan = new int[N];
        vita = new int[N];
        price = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        N_dan = Integer.parseInt(st.nextToken());
        N_fat = Integer.parseInt(st.nextToken());
        N_tan = Integer.parseInt(st.nextToken());
        N_vita = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	dan[i] = Integer.parseInt(st.nextToken());
        	fat[i] = Integer.parseInt(st.nextToken());
        	tan[i] = Integer.parseInt(st.nextToken());
        	vita[i] = Integer.parseInt(st.nextToken());
        	price[i] = Integer.parseInt(st.nextToken());
        }
        
        backt(0,0,0,0,0,0);
        
        if(answer == Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(answer);
        	System.out.println(sb);
        }
        
    }
    public static void backt(int cnt,int b_dan, int b_fat, int b_tan, int b_vita, int b_price) {
    	if(b_dan >= N_dan && b_fat >= N_fat && b_tan >= N_tan && b_vita >= N_vita) {
    		if(answer > b_price) {
    			answer = b_price;
    			sb.setLength(0);
    			for(int a : list) {
    				sb.append(a).append(" ");
    			}
    		}
    		return;
    	}
    	for(int i = cnt ; i < N ; i++) {
    		list.add(i+1);
    		backt(i + 1,b_dan + dan[i], b_fat + fat[i], b_tan + tan[i], b_vita + vita[i], b_price + price[i]);
    		list.remove(list.size()-1);
    	}
    	
    }
    
}

import java.util.*;
import java.io.*;

public class Main {
    public static int N ; // 배열크기
    public static int[][] arr;
    public static ArrayList<Integer> a_list = new ArrayList<>();
    public static ArrayList<Integer> b_list = new ArrayList<>();
    public static int a_answer = 0;
    public static int b_answer = 0;
    public static int answer = Integer.MAX_VALUE;
    public static int[] checkarr;
    public static int worldcnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        checkarr = new int[N];
        
        for(int i = 0 ; i < N ; i++) {
        	checkarr[i] = i;
        }
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < N ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        johab(0,0);
        
        System.out.println(answer);
        
        
    }
    
    public static void johab(int start, int cnt) {
    	if(cnt == N/2 ) {
    		b_list.clear();
    		a_answer = 0;
    		b_answer = 0;
    		for(int i = 0 ; i < N ; i++) {
    			if(a_list.contains(i)) {
    				continue;
    			}else {
    				b_list.add(i);
    			}
    		}
    		
    		for(int i = 0 ; i < a_list.size() ; i++) {
    			for(int j = 0 ; j < a_list.size() ; j++) {
    				a_answer += arr[a_list.get(i)][a_list.get(j)];
    			}
    			
    		}

    		for(int i = 0 ; i < b_list.size() ; i++) {
    			for(int j = 0 ; j < b_list.size() ; j++) {
    				b_answer += arr[b_list.get(i)][b_list.get(j)];
    			}
    			
    		}

    		
//    		System.out.println(a_answer + " " + b_answer);
    		int local_answer = Math.max(a_answer, b_answer) - Math.min(a_answer, b_answer);
//    		System.out.println(local_answer);
    		answer = Math.min(answer,local_answer);
    		return;
    	}
    	
    	for(int i = start ; i < N ; i++) {
    		a_list.add(i);
    		johab(i+1,cnt+1);
    		a_list.remove(a_list.size() - 1);
    	}
    	
    	
    }

}

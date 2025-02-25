import java.util.*;
import java.io.*;

public class Solution {
    public static int N, answer;
    public static int[][] arr;
    public static int[] check_arr;
    public static List<Integer> list = new ArrayList<>();
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for(int i = 1 ; i < T + 1 ; i++) {
        	answer = Integer.MAX_VALUE;
        	list.clear();
        	
        	N = Integer.parseInt(br.readLine());
        	check_arr = new int[N];
        	for(int j = 0 ; j < N ; j++) {
        		check_arr[j] = j;
        	}
        	
        	
        	arr = new int[N][N];
        	
        	for(int j = 0 ; j < N ; j++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int p = 0 ; p < N ; p++) {
        			arr[j][p] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	
        	johab(0, 0);        	
        	
        	System.out.println("#" + i + " " + answer);
        }
        

    }
    
    public static void johab(int cnt, int start) {
    	if(cnt == N / 2) {
    		List<Integer> anotherlist = new ArrayList<>();
    		for(int j = 0 ; j < N ; j++) {
    			if(list.contains(j)) {
    				
    			}else {
    				anotherlist.add(j);
    			}
    		}

    		int a_taste = 0;
    		int b_taste = 0;
    		
    		for(int j = 0 ; j < list.size()  ; j++) {
    			for(int p = 0 ; p < list.size() ; p++) {
        			a_taste += arr[list.get(j)][list.get(p)];
    			}
    		}
    		for(int j = 0 ; j < anotherlist.size() ; j++) {
    			for(int p = 0 ; p < anotherlist.size() ; p++) {
        			b_taste += arr[anotherlist.get(j)][anotherlist.get(p)];
    			}
    		}


    		
    		int check_answer = Math.max(a_taste, b_taste) - Math.min(a_taste, b_taste);
    		answer = Math.min(check_answer, answer);

    		return;
    		
    	}
    	for(int i = start ; i < N ; i++) {
    		list.add(i);
    		johab(cnt + 1 , i + 1);
    		list.remove(list.size()-1);
    		
    	}
    }
}

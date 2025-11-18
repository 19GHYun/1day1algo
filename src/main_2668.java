import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] arr;
    public static boolean[] check;
    public static int num = 0;
    public static int num2 = 0;
    public static int a_side = 0;
    public static int b_side = 0;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<Integer> list3 = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        
        for(int i = 1 ; i <= N ; i++) {
        	int a = Integer.parseInt(br.readLine());
        	arr[i][a] = a;
        }
        
//        for(int i = 1 ; i < N + 1 ; i++) {
//        	for(int j = 1 ; j < N + 1 ; j++) {
//        		System.out.print(arr[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        ArrayList<Integer> list2 = new ArrayList<>();
        
        for(int i = 1 ; i < N + 1 ; i++) {
        	if(!check[i]) {
        		num2 = 0;
        		a_side = 0;
        		b_side = 0;
        		list.clear();
        		list3.clear();
        		dfs(i);
        		if(a_side != 0 && b_side != 0 && a_side == b_side) {
        			num += num2;
        			for(int p = 0 ; p < list.size() ; p++) {
        				list2.add(list.get(p));
        			}
        			for(int p = 0 ; p < list3.size(); p++) {
        				check[list3.get(p)] = true;
        			}
        		}
        		else {
        			
        		}
        	}
        	
        }
        
        sb.append(num).append("\n");
      


        Collections.sort(list2);
    
        for(int i = 0 ; i < list2.size() ; i++) {
        	sb.append(list2.get(i)).append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
    
    public static void dfs(int start) {
		list3.add(start);
    	for(int i = 1 ; i < N + 1 ; i++) {
    		if(arr[start][i] != 0 && !check[i]) {
    			a_side += start;
    			b_side += arr[start][i];
    			check[i] = true;
    			num2++;
    			if(arr[i][start] == 0) {
    				list.add(arr[start][i]);
    			}
    			else {
        			list.add(arr[i][start]);
    			}
    			dfs(i);
    			check[i] = false;
    		}
    		
    	}
    }
}

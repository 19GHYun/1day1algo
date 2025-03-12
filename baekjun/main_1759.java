import java.util.*;
import java.io.*;

public class Main {
    public static int N,M;
    public static char[] arr;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new char[M];
        
        String a = br.readLine();
        for(int i = 0 ; i < M ; i ++) {
        	arr[i] = a.charAt(i * 2);
        }
        
        Arrays.sort(arr);
        
        
        johab(0,0);
        
        System.out.println(sb);

    }
    
    public static void johab(int start, int cnt) {
    	if(cnt == N) {

    		boolean check = false;
    		int check2 = 0;
    		for(int i = 0 ; i < N ; i++) {
        		if(arr[(list.get(i))] == 'a' || arr[(list.get(i))] == 'e' || arr[(list.get(i))] == 'i' || arr[(list.get(i))] == 'o' ||arr[(list.get(i))] == 'u' ) {
        				check = true;
        		}
        		else {
        			check2++;

    		}

    	}
    		
    		if(check && check2 >= 2) {
        		for(int i = 0 ; i < N; i++) {
        			sb.append(arr[(list.get(i))]);
        		}
        		sb.append("\n");
    		}
    		else {
    			
    		}

    		return;
    	}
    	
    	for(int i = start ; i < M ; i++) {
        		list.add(i);
        		johab(i + 1, cnt+1);
        		list.remove(list.size()-1);
    		}

    	}
    	
    }

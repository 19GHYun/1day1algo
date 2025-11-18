import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Long> numbers = new ArrayList<>();

        for(int i = 1 ; i <= 10 ; i++) {
        	combi(0, i, new ArrayList<>() , numbers);
        }
        
        Collections.sort(numbers);
        
        if(N < numbers.size() + 1) {
        	System.out.println(numbers.get(N  - 1));
        }else {
        	System.out.println(-1);
        }
        
    }

    private static void combi(int start, int k, List<Integer> current, List<Long> result) {
    	if(k == 0) {
    		StringBuilder sb = new StringBuilder();
    		for(int i = current.size() - 1; i >= 0 ;  i--) {
    			sb.append(current.get(i));
    		}
    		result.add(Long.parseLong(sb.toString()));
    		return;
    	}
        for(int i = start ; i <= 9 ; i++) {
        	current.add(i);
        	combi(i + 1, k - 1, current, result);
        	current.remove(current.size() - 1);
        }
    }

}

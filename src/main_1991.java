import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static TreeMap<Character, char[]> tree = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++) {
        	String a = br.readLine();
        	
        	char parent = a.charAt(0);
        	char left = a.charAt(2);
        	char right = a.charAt(4);
        	
        	tree.put(parent, new char[] {left, right});
        	
        	
        }
        
        jeon('A');
        System.out.println();
        jung('A');
        System.out.println();
        hu('A');
        
        
    }
    
    public static void jeon(char start) {
    	if(start == '.') {
    		return;
    	}
    	System.out.print(start);
    	jeon(tree.get(start)[0]);
    	jeon(tree.get(start)[1]);
    	
    }
    public static void jung(char start) {
    	if(start == '.') {
    		return;
    	}
    	jung(tree.get(start)[0]);
    	System.out.print(start);
    	jung(tree.get(start)[1]);
    	
    }
    public static void hu(char start) {
    	if(start == '.') {
    		return;
    	}
    	hu(tree.get(start)[0]);
    	hu(tree.get(start)[1]);
    	System.out.print(start);
    }

    
}

import java.io.*;
import java.util.*;




public class Main {
	
	public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();
	
	public static void kmpsearch(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		
		int[] ips = findips(pattern);
		
		int i = 0;
		int ii = 0;
		
		while(i < n) {
			if(pattern.charAt(ii) == text.charAt(i)) {
				i++;
				ii++;
			}
			if(ii == m) {
				//패턴 발견 위치는 i - ii
				answer++;
				ii = ips[ii-1];
			}
			else if(i < n && pattern.charAt(ii) != text.charAt(i)) {
				if(ii != 0) {
					ii = ips[ii - 1];
				}
				else {
					i++;
				}
			}
			
		}
		
		
		
	}
	
	public static int[] findips(String pattern) {
		int m = pattern.length();
		int[] ips = new int[m];
		
		int i = 1;
		int len = 0;
		
		while(i < m) {
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				ips[i] = len;
				i++;
			}
			else {
				if(len != 0) {
					len = ips[len - 1];
				}
				else {
					ips[i] = 0;
					i++;
				}
			}
		}
		
		return ips;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
        	String a = br.readLine();
        	String aa = a.concat(a);
        	
        	answer =  0;
        	
        	if(a.equals(".")) {
        		break;
        	}
        	
        	kmpsearch(aa, a);
        	
        	System.out.println(answer - 1);
        	
        }
        

    }

}


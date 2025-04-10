import java.io.*;
import java.util.*;

public class Main {
	
	public static int answer;
    public static StringBuilder sb = new StringBuilder();
	
	public static void kmpsearch(String text, String pattern, int N) {
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
				if(i-ii<N) answer++;
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
	
	public static int gcd(int a, int b) {
	    while (b != 0) {
	        int r = a % b;
	        a = b;
	        b = r;
	    }
	    return a;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        answer = 0;
        
        String a = br.readLine().replace(" ", "");
        String aa = a.concat(a);
        String b = br.readLine().replace(" ", "");
        
//        System.out.println(aa);
//        System.out.println(b);
        
        kmpsearch(aa, b, N);
        
        
        if(answer > N) {
        	answer = N;
        }
        
        int divide_num = gcd(N, answer);
        
        N = N / divide_num;
        answer = answer / divide_num;
        
        System.out.println(answer + "/" + N);


    }

}


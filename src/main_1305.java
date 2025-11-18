import java.io.*;
import java.util.*;




public class Main {
	
	public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();
	
	public static void kmpsearch(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		
		int[] ips = ipsfind(pattern);
		
		int i = 0;
		int ii = 0;
		
		while(i < n) { // text길이만큼 돌림
			if(text.charAt(i) == pattern.charAt(ii)) {
				i++;
				ii++;
			}
			if(ii == m) {
				//패턴발견했음 
				ii = ips[ii-1]; // 이게 중요
				answer = i - ii;
			}
			
			else if( i < n && text.charAt(i) != pattern.charAt(ii)) {
				if( ii != 0) {
					ii = ips[ii - 1];
				}
				else {
					i++;
				}
				
			}
		}
		
		
		
	}
	
	public static int[] ipsfind(String pattern) {
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
        
        int size = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String aa = a.concat(a);
        
        kmpsearch(aa,a);
        
        System.out.println(answer - size);

    }

}


import java.io.*;
import java.util.*;




public class Main {
	
	public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();
	
	public static void kmpsearch(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		
		int[] ips = ipsfind(pattern);
		
		int i = 0; // 텍스트의 인덱스
		int ii = 0; // 패턴의 인덱스
		
		while(i < n) { // 텍스트 처음부터 끝까지 순회
			if(text.charAt(i) == pattern.charAt(ii)) {
				i++;
				ii++;
			}
			if(ii == m) { // 패턴 끝까지 다 맞아 떨어졋다면
//				System.out.println("패턴발견 위치는 i - ii : " + (i - ii) );
				answer++;
				sb.append(i-ii + 1).append(" ");
				
				ii = ips[ii - 1]; // 이걸 뺴먹었네
				
			}
			else if(i < n && pattern.charAt(ii) != text.charAt(i)) { // 보면 아래랑 똑같은데, i < n 중요
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
		int len = 0;
		int i = 1;
		
		while(i < m) {
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				ips[i] = len;
				i++;
			}
			else {
				if(len != 0) {
					len = ips[len-1];
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
        
        String a = br.readLine(); // 텍스트
        String b = br.readLine(); // 패턴

        kmpsearch(a , b); 
        
        System.out.println(answer);
        System.out.print(sb);

    }

}


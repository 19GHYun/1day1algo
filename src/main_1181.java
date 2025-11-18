import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		StringBuffer sb = new StringBuffer();
		
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length()); // 길이 순 정렬
                }
                return s1.compareTo(s2); // 길이가 같으면 사전순 정렬
            }
        });

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 0 ; i < N ; i++) {
			set.add(sc.next());
		}
		
		
		
		for(String i : set) {
			sb.append(i);
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}

}

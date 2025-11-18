import java.util.*;
import java.io.*;

/*
 * 메모리 262972KB, 시간 1044ms
 * 
 * 메모리와 시간이 터진 이유
 * 무분별한 LinkedList의 사용 -> 배열로 바꿔서 쓰면 good
 * 스트링빌더도 MAX랑 MIN 나눠서 쓰자. 그럼 아래 코드처럼 짧아짐. 24288KB 480ms
 * 
 */

public class Main {
	public static String max_num = "0";	// 최대 점수 넣을 곳
	public static String min_num = "9999999999"; // 최소 점수 넣을 곳
	public static int N;	// 2부터 9이하 부등호 갯수 나오는곳
	public static int[] arr; // 0 1 2 3 4 5 .. 쓸 곳
	public static List<Integer> arr2 = new LinkedList<>(); // 메모리 터진 이유중 하나. 백트레킹쓸때 쓰는 곳
	public static boolean[] check; // 중복 안되니까 넣엇읍니다.
	public static char[] budeungho; // 부등호 넣는 곳 ㅋㅋ 상자 이름이 부등호
	public static StringBuilder sb = new StringBuilder(); // 왜 하필 String으로 받는지.. 잘 몰라서 이걸로 씀.

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);	//사나이는 bufferedreader 안쓰고 scanner 씁니다.
		
		N = sc.nextInt(); // 2 부터 9 이하.
		sc.nextLine();	// 공백문자 제거
		arr = new int[10]; // 
		check = new boolean[10];
		budeungho = new char[N];
		
		String a = sc.nextLine();
		for(int i = 0 ; i < N ; i++) {
			budeungho[i] = a.charAt(i*2); // 사이사이 공백 잇으니 이렇게 ..
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			arr[i] = i;
		}
		

		
//		for(char b : budeungho) { 디버깅용
//			System.out.println(b);
//		}
		dfs(0); // "그거" 실행
		
		System.out.println(max_num);
		System.out.println(min_num);
		
	}
	
	public static void dfs(int cnt) {
		if(cnt == N + 1) {	// 부등호보다 하나 더 뽑아야 하니까 N + 1
			for(int i = 0 ; i < N ; i++) { // 다 비교 해버립니다잉.
				if(budeungho[i] == '>') {
					if(arr2.get(i) > arr2.get(i+1)) {
						
					}else {
						return;
					}
				}else {
					if(arr2.get(i) < arr2.get(i+1)) {
						
					}else {
						return;
					}
					
				} // 이 if들을 통과한다면 너는 비교당할 조건이 된다.
			}
			sb.setLength(0);	//초기화 함 조져주고
			for(int num : arr2) { // arr2에 있는거
				sb.append(num); // sb에 쌓습니다.
			}
			String p = sb.toString(); // 이 string을
			
			if(max_num.compareTo(p) < 0) { // 맥스 값이 p보다 작으면
				max_num = p; // 요렇게
			}
			if(min_num.compareTo(p) > 0) { // 반대로
				min_num = p;
			}
			
			
		}
		
		for(int i = 0 ; i < 10 ; i++) { //흔하고 흔한 백트래킹
			if(!check[i]) {
				arr2.add(arr[i]);
				check[i] = true;
				dfs(cnt + 1);
				check[i] = false;
				arr2.remove(arr2.size()-1);
			}
		}
	}
	
}

/* 
package algo_0218;

import java.util.*;
import java.io.*;

public class Main {
    public static String max_num;
    public static String min_num;
    public static int N;
    public static int[] arr = new int[10];
    public static int[] arr2 = new int[10];
    public static boolean[] check = new boolean[10];
    public static char[] budeungho;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        budeungho = new char[N];

        String a = sc.nextLine();
        for (int i = 0; i < N; i++) {
            budeungho[i] = a.charAt(i * 2);
        }

        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        StringBuilder maxInit = new StringBuilder();
        StringBuilder minInit = new StringBuilder();
        for (int i = 0; i <= N; i++) {
            maxInit.append("0");
            minInit.append("9");
        }
        max_num = maxInit.toString();
        min_num = minInit.toString();

        dfs(0);

        System.out.println(max_num);
        System.out.println(min_num);
    }

    public static void dfs(int cnt) {
        if (cnt == N + 1) {
            for (int i = 0; i < N; i++) {
                if (budeungho[i] == '>') {
                    if (arr2[i] <= arr2[i + 1]) return;
                } else {
                    if (arr2[i] >= arr2[i + 1]) return;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N + 1; i++) {
                sb.append(arr2[i]);
            }
            String p = sb.toString();
            if (max_num.compareTo(p) < 0) max_num = p;
            if (min_num.compareTo(p) > 0) min_num = p;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                arr2[cnt] = arr[i];
                check[i] = true;
                dfs(cnt + 1);
                check[i] = false;
            }
        }
    }
}
*/

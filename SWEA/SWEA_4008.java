import java.util.*;
import java.io.*;

public class Solution {
    public static int N, highanswer,lowanswer;
    public static Deque<Integer> q = new ArrayDeque<>();
    public static List<Integer> arr2 = new ArrayList<>();
    public static boolean[] check;
    public static int[] arr3;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 1;  i < T + 1 ; i++) {
        	highanswer = Integer.MIN_VALUE;
        	lowanswer = Integer.MAX_VALUE;
        	
        	N = Integer.parseInt(br.readLine());
        	q.clear();

        	check = new boolean[N-1];
        	
            List<Integer> arr = new ArrayList<>();
            
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < 4 ; j++) {
        		if(j == 0) {
        			int q = Integer.parseInt(st.nextToken());
        			for(int w = 0 ; w < q ; w++) {
        				arr.add(1);
        			}
        		}
        		else if(j == 1) {
        			int q = Integer.parseInt(st.nextToken());
        			for(int w = 0 ; w < q ; w++) {
        				arr.add(2);
        			}
        		}
        		else if(j == 2) {
        			int q = Integer.parseInt(st.nextToken());
        			for(int w = 0 ; w < q ; w++) {
        				arr.add(3);
        			}
        		}
        		else if(j == 3) {
        			int q = Integer.parseInt(st.nextToken());
        			for(int w = 0 ; w < q ; w++) {
        				arr.add(4);
        			}
        		}
        	}
        	
        	arr3 = new int[arr.size()];
        	for(int j = 0 ; j < arr.size(); j++) {
        		arr3[j] = arr.get(j);
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0 ; j < N ; j++) {
        		q.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	
//        	for(int p : q) {
//        		System.out.print(p + " ");
//        	}
//        	System.out.println();
//        	
//        	for(int o : arr3) {
//        		System.out.print(o + " ");
//        	}
//        	System.out.println();
        	sonyeol(0);
        	
        	
        	int answer = highanswer - lowanswer;
        	System.out.println("#" + i  + " " + answer);
        }

    }
    
    public static void sonyeol(int cnt) {
        if(cnt == N - 1) {
        	
        	
        	calc();
        	
            return;
        }
        
        int prev = -1;
        for(int i = 0 ; i < N - 1 ; i++) {
            if(!check[i] && arr3[i] != prev) {
                arr2.add(arr3[i]);
                check[i] = true;
                sonyeol(cnt + 1);
                check[i] = false;
                arr2.remove(arr2.size() - 1);
                prev = arr3[i];
            }
        }
    }
    
    public static void calc() {
        Deque<Integer> tempQ = new ArrayDeque<>(q); // 원본 q 복사 이거 중요 .
        for (int i = 0; i < N - 1; i++) {
            int start = tempQ.poll();         // 첫 번째 숫자
            int sacikyeonsan = arr2.get(i);   // 연산자
            int next = tempQ.poll();          // 두 번째 숫자
            int total = 0;
            switch (sacikyeonsan) {
                case 1:
                    total = start + next;
                    break;
                case 2:
                    total = start - next;
                    break;
                case 3:
                    total = start * next;
                    break;
                case 4:
                    total = start / next;
                    break;
            }
            tempQ.addFirst(total);            // 결과 추가
        }
        // 최종 결과로 highanswer, lowanswer 갱신
        highanswer = Math.max(highanswer, tempQ.peek());
        lowanswer = Math.min(lowanswer, tempQ.peek());
    }
    
}

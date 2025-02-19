import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int N = sc.nextInt();
        int[] A = new int[N];	// 카드 갯수
        for (int i = 0; i < N; i++) { // 스킬을 담는 곳
            A[i] = sc.nextInt();
        }
        
       
        ArrayDeque<Integer> card = new ArrayDeque<>();	//카드 초기화
        
        for (int i = 1; i <= N; i++) {
            int op = A[N - i]; // //역순으로 해야됨
            if (op == 1) {
                card.addFirst(i); // 맨 위에 추가
            } else if (op == 2) {
                // 두 번째 위치에 삽입
                int top = card.pollFirst(); // 맨 앞 요소 제거
                card.addFirst(i);           // 새로운 카드 삽입
                card.addFirst(top);         // 원래 맨 앞 요소 다시 추가
            } else if (op == 3) {
                card.addLast(i); // 맨 아래(뒤)에 추가
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        while (!card.isEmpty()) {
            sb.append(card.pollFirst());
            if (!card.isEmpty()) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
        
        sc.close();
    }
}

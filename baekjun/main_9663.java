import java.io.*;
import java.util.*;


public class Main {
    static int N;        // 체스판 크기 및 퀸의 개수
    static int[] arr;    // 퀸의 위치를 저장하는 배열
    static int count = 0; // 가능한 해의 개수

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());       // N 입력받기
        arr = new int[N];       // 배열 초기화
        backtracking(0);        // 백트래킹 시작
        System.out.println(count); // 결과 출력
    }

    // 백트래킹 함수: 현재 행(row)에 퀸을 배치
    static void backtracking(int row) {
        // 모든 행에 퀸을 배치한 경우
        if (row == N) {
            count++; // 해의 개수 증가
            return;
        }

        // 현재 행에서 가능한 모든 열을 시도
        for (int col = 0; col < N; col++) {
            if (isPossible(row, col)) { // 퀸을 놓을 수 있다면
                arr[row] = col;         // 현재 행에 퀸 배치
                backtracking(row + 1);  // 다음 행으로 이동
            }
        }
    }

    // 퀸을 놓을 수 있는지 확인하는 함수
    static boolean isPossible(int row, int col) {
        // 이전 행들을 확인
        for (int i = 0; i < row; i++) {
            // 같은 열이거나 같은 대각선에 있는 경우.
            if (arr[i] == col || Math.abs(i - row) == Math.abs(arr[i] - col)) {
                return false; // 퀸 못놓는다
            }
        }
        return true; // 퀸을 놓을 수 있음
    }
}

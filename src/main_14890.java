import java.util.*;
import java.io.*;

public class Main {

	        static int N, X; // 높이와너비, 경사로길이
	    static int[][] arr;
	    static boolean[] rowP, colP; // 가능한지 체크해서 true면 최종결과 ++
	     
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	            N = sc.nextInt();
	            X = sc.nextInt();
	            arr = new int[N][N];
	            rowP = new boolean[N];
	            colP = new boolean[N];
	 
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < N; j++) {
	                    arr[i][j] = sc.nextInt(); //배열에 집어넣고
	                }
	                rowP[i] = true;  //일단 다 된다고 침
	                colP[i] = true;
	            }
	 
	            checkRows();
	            checkCols();
	 
	            int count = 0;
	            for (int i = 0; i < N; i++) {
	                if (rowP[i]) count++; //되는거만 찾아서 카운트 ++
	                if (colP[i]) count++;
	            }
	 
	            System.out.println(count);
	        
	        sc.close();
	    }
	     
	    private static void checkRows() {
	        for (int i = 0; i < N; i++) {
	            boolean[] slope = new boolean[N]; // 경사로가 설치 됐는지 확인하는 것
	             
	            for (int j = 0; j < N - 1; j++) {
	                int chaii = arr[i][j] - arr[i][j + 1]; // 지금 위치랑 다음 위치 위치의 차이를 체크
	                 
	                if (chaii == 0) continue; // 왼쪽부터 진행 하는데, 높이 차이가 없으면 그대로 진행
	                 
	                if (Math.abs(chaii) > 1) { // 높이차이가 2 이상이면 경사로 설치 불가
	                     
	                    rowP[i] = false;   // out
	                     
	                    break;
	                }
	                if (chaii == 1) { // 내리막 경사로 일때
	                     
	                    if (j + X >= N) { // 이떄 앞은 경사로 길이만큼 최소한 있어야 함. 
	                        rowP[i] = false;  //길이만큼 없으면 out
	                        break;
	                    }
	                    for (int k = j + 1; k <= j + X; k++) {
	                         
	                        if (arr[i][k] != arr[i][j + 1] || slope[k]) { // 앞에 경사로 높이가 동일해야함. + 설치 안되어 잇어야 함
	                            rowP[i] = false;      //높이 동일 안하면 당연히 out
	                            break;
	                        }
	                    }
	                    if (!rowP[i])
	                        break;      // 내리막 못까는걸 확인했으니 끝냄. 그 아래는 경사로 설치
	                    for (int k = j + 1; k <= j + X; k++) { // 경사로 깔린 곳을 true로 줌.
	                        slope[k] = true;
	                    }
	                    j += X - 1; // 경사로를 설치 한 다음 위치로 이동
	                }
	                 
	                 
	                else if (chaii == -1) { // 오르막 경사로가 필요할때
	                    if (j - X + 1 < 0) { // 당연히 뒤쪽 설치 할 공간 부족하면 out
	                        rowP[i] = false;  //컷
	                        break;
	                    }
	                    for (int k = j; k >= j - X + 1; k--) {  
	                        if (arr[i][k] != arr[i][j] || slope[k]) { // 경사로 깔 곳 길이가 동일하지 않거나, 깔려있으면 컷
	                            rowP[i] = false;
	                            break;
	                        }
	                    }
	                    if (!rowP[i]) break;    // 불가능 하다고 판단됏으면 컷
	                    for (int k = j; k >= j - X + 1; k--) { // 가능하다고 판단 됐으니 경사로 깔고 true
	                        slope[k] = true;
	                    }
	                }
	            }
	        }
	    }
	 
	    private static void checkCols() {   //가로에서 한걸 세로로.
	        for (int j = 0; j < N; j++) {
	            boolean[] slope = new boolean[N];
	            for (int i = 0; i < N - 1; i++) {
	                int diff = arr[i][j] - arr[i + 1][j];
	                if (diff == 0)
	                    continue;
	                if (Math.abs(diff) > 1) {
	                    colP[j] = false;
	                    break;
	                }
	                if (diff == 1) { // 내리막
	                    if (i + X >= N) {
	                        colP[j] = false;
	                        break;
	                    }
	                    for (int k = i + 1; k <= i + X; k++) {
	                        if (arr[k][j] != arr[i + 1][j] || slope[k]) {
	                            colP[j] = false;
	                            break;
	                        }
	                    }
	                    if (!colP[j])
	                            break;
	                    for (int k = i + 1; k <= i + X; k++) {
	                        slope[k] = true;
	                    }
	                    i += X - 1;
	                }
	                 
	                 
	                 
	                else if (diff == -1) { // 오르막
	                    if (i - X + 1 < 0) {
	                        colP[j] = false;
	                        break;
	                    }
	                    for (int k = i; k >= i - X + 1; k--) {
	                        if (arr[k][j] != arr[i][j] || slope[k]) {
	                            colP[j] = false;
	                            break;
	                        }
	                    }
	                    if (!colP[j])
	                        break;
	                    for (int k = i; k >= i - X + 1; k--) {
	                        slope[k] = true;
	                    }
	                }
	            }
	        }
	    }
	     
	
}

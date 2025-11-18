import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int chamwe = sc.nextInt(); // 1m²당 참외 개수

        int[] dir = new int[6]; // 방향
        int[] len = new int[6]; // 길이
        
        for (int i = 0; i < 6; i++) {
            dir[i] = sc.nextInt();
            len[i] = sc.nextInt();
        }

        // 가장 긴 변 찾기
        int maxWidth = 0, maxHeight = 0;
        int maxWidthIndex = 0, maxHeightIndex = 0;

        for (int i = 0; i < 6; i++) {
            if (dir[i] == 1 || dir[i] == 2) { // 동(1), 서(2)
                if (len[i] > maxWidth) {
                    maxWidth = len[i];
                    maxWidthIndex = i;
                }
            } else { // 남(3), 북(4)
                if (len[i] > maxHeight) {
                    maxHeight = len[i];
                    maxHeightIndex = i;
                }
            }
        }

        // 작은 사각형의 변 찾기 (큰 변 기준 양 옆 변 차이)
        int smallWidth = Math.abs(len[(maxWidthIndex + 5) % 6] - len[(maxWidthIndex + 1) % 6]);
        int smallHeight = Math.abs(len[(maxHeightIndex + 5) % 6] - len[(maxHeightIndex + 1) % 6]);

        // 전체 면적에서 작은 사각형 빼기
        int totalArea = (maxWidth * maxHeight) - (smallWidth * smallHeight);

        // 참외 개수 계산
        System.out.println(totalArea * chamwe);
    }
}

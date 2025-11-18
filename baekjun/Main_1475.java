import java.util.*;
import java.io.*;

/*
0~9 숫자 하나씩 들어간 세트
다솜이 방 -> 필요한 세트의 개수
6은 뒤집어서 9 가능
9도 뒤집어서 6 가능

-->>>
9가 2개 또는 6을 2개로 카운트 가능할듯.
즉 a[6] + a[9] == 2 만 아니면 6이나 9 써도 된다 이거지.

 */

public class Main_1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int answer = 0;

        String N = br.readLine();

        int [] numbers = new int[10];

        for(int i = 0 ; i < N.length(); i++){
            int a = Integer.parseInt(N.substring(i, i+1));
            numbers[a]++;
        }
//        for(int i = 0 ; i < 10 ; i++){
//            System.out.print(numbers[i] + " ");
//        }

        for(int i = 0 ; i < 10 ; i++){
            if(answer < numbers[i]){
                if(i == 6 || i == 9){
                    answer = (numbers[6] + numbers[9]) / 2; // 6969 면 2세트, 0 0 0 0 0 0 2 0 0 2..
                    if((numbers[6] + numbers[9]) % 2 == 1 ){
                        answer++;
                    }
                }
                else{
                    answer = numbers[i];
                }
            }
        }

        System.out.println(answer);
    }

}

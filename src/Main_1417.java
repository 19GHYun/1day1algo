import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/*
일단 N이 작아서 걍 브루트포스 해도 시간은 초과 안날듯
근데 시간을 더 줄일수 잇을까

 */

public class Main_1417 {

    public static int[] persons;
    public static int N;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        persons = new int[N + 1];
        for(int i = 1 ; i < N + 1 ; i++){
            persons[i] =  Integer.parseInt(br.readLine());
        }
        while(is_dasom_win()){
            maesu();
//            for(int i = 1 ; i < N + 1 ; i++){
//                System.out.print(persons[i] + " ");
//            }
        }
//        System.out.println();
        System.out.println(answer);


    }

    public static boolean is_dasom_win(){
        boolean yes = true;
        if( N == 1){
            return false;
        }
        for(int i = 2 ; i < N + 1 ; i++){
            if(persons[1] <= persons[i]){
                yes = false;
            }

        }
        return !yes;

    }
    public static void maesu(){
        int high_man = persons[1];
        int high_man_num = 1;
        for(int i = 2 ; i < N + 1 ; i++){
            if(high_man <= persons[i]){
                high_man = persons[i];
                high_man_num = i;
            }
        }

        persons[1]++;
        persons[high_man_num]--;
        answer++;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1652 {

    public static int N;
    public static char[][] map;
    public static int garo = 0;
    public static int sero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for(int i = 0 ; i < N ; i++){
            String a = br.readLine();
            for(int ii = 0 ; ii < N ; ii++){
                map[i][ii] = a.charAt(ii);
            }

        }

        for(int i = 0 ; i < N ; i++){
            garo_check(i);
            sero_check(i);
        }

        System.out.println(garo + " " + sero);


    }

    public static void garo_check(int a){
        int check = 0;
        for(int i = 0 ; i < N ; i++){
            if(map[a][i] == '.'){
                check++;
            }
            else{
                if(check >= 2){
                    garo++;
                }
                check = 0;

            }
            if( i == N - 1){
                if(check >= 2){
                    garo++;
                }
            }
        }

    }

    public static void sero_check(int a){
        int check = 0;
        for(int i = 0 ; i < N ; i++){
            if(map[i][a] == '.'){
                check++;
            }
            else{
                if(check >= 2){
                    sero++;
                }
                check = 0;
            }
            if( i == N - 1){
                if(check >= 2){
                    sero++;
                }
            }
        }
    }


}

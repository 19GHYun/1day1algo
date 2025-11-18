import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1543 {

    public static int answer = 0;
    public static String docu;
    public static String find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        docu =  br.readLine();
        find =  br.readLine();

        int temp = find.length();

        for(int i = 0 ; i < docu.length() ; i++){
            if(i + find.length() > docu.length()){
                break;
            }
            if(progress(i)){
                answer++;
                i += find.length() - 1;
            }
        }

        System.out.println(answer);

    }

    public static boolean progress(int start){
        int f_start = 0;
        boolean check = true;
        for(int i = start ; i < find.length() + start ; i++){
            if(find.charAt(f_start) == docu.charAt(i)){
                f_start ++;
            }
            else{
                check = false;
            }

        }
        return check;


    }

}

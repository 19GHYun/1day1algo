import java.io.*;
import java.util.*;

public class Main {
    static int student;
    static int[] eat_num;
    static int[] line_num;
    static int dth = 0;



    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
        
        student = sc.nextInt();
        
        eat_num = new int[student];
        line_num = new int[student];
        
        for(int i = 0 ; i < eat_num.length; i++) {
        	eat_num[i] = sc.nextInt();
        }
        
        
        for(int i = 0 ; i < student; i++) {
        	int check = -1;
        	if( i == 0 ) {
        		line_num[i] = i+1;
        	}else {
        		if((i == eat_num[i])) {
        			line_num[i] = i+1;
        		}
        		else {
        			for(int j = student-1 ; j > eat_num[i] ; j--) {
        				line_num[j] = line_num[j-1];
        			}
        			line_num[eat_num[i]] = i + 1;
        		}
        	}
        	
        }
        
        for(int i = student- 1 ; i >= 0 ; i--) {
        	System.out.print(line_num[i]+ " ");
        }
        


        
//        for(int i = 0 ; i < 9 ; i++) {
//        	System.out.print(arr[i]);
//        }

    }
    


}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
    	Scanner sc = new Scanner(System.in);
    	
    	int[][] bingo = new int[5][5];
    	int say_num;
    	int check_num = 0;
    	int check_sum = 0;
    	int cnt = 0 ;
    	
    	for(int i = 0 ; i < 5 ; i++) {
    		for(int j = 0 ; j < 5 ; j++) {
    			bingo[i][j] = sc.nextInt();
    		}
    	}
    	
    	for(int i = 0 ; i < 25 ; i++) {
    		say_num = sc.nextInt();
    		check_sum = 0;
    		cnt++;
    		
    		for(int j = 0 ; j < 5 ; j++) {
    			for(int k = 0 ; k < 5 ; k++) {
    				if(bingo[j][k] == say_num) {
    					bingo[j][k] = 0;
    				}
    			}
    		}
    		
    		//가로
    		for(int j = 0 ; j < 5 ; j++) {
    			for(int k = 0 ; k < 5 ; k++) {
    				check_sum += bingo[j][k];
    				
    			}
				if(check_sum == 0) {
					check_num++;
				}
    			check_sum = 0;
    		}
    		//세로
    		for(int j = 0 ; j < 5 ; j++) {
    			for(int k = 0 ; k < 5 ; k++) {
    				check_sum += bingo[k][j];
    			}
   				if(check_sum == 0) {
					check_num++;
				}
   				
    			check_sum = 0;
    		}
    		
    		//대각선
    		if((bingo[0][0] + bingo[1][1] + bingo[2][2] + bingo[3][3] + bingo[4][4] )== 0) {
    			check_num++;
    		}
    		check_sum = 0;
    		if((bingo[0][4] + bingo[1][3] + bingo[2][2] + bingo[3][1] + bingo[4][0] )== 0) {
    			check_num++;
    		}
    		
    		if(check_num >= 3) {
    			System.out.println(cnt);
    			break;
    		}
    		check_num = 0;
    		
    	}
    	
    }
}

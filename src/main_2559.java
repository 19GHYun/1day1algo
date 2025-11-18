import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int size = sc.nextInt();
    	int score = 0;
    	int high_score =-99999999;
    	
    	int[] temp = new int[size];
    	
    	int height = sc.nextInt();
    	
    	for(int i = 0 ; i < temp.length ; i++) {
    		temp[i] = sc.nextInt();
    	}
    	
    	for(int i = 0 ; i < temp.length ; i++) {
    		try {
    			for(int k = 0 ; k < height ; k++) {
    				score += temp[i + k];
    			}
    			if(high_score < score) {
    				high_score = score;
    			}
    		}catch(ArrayIndexOutOfBoundsException e) {
    			break;
    		}
    		score = 0;
    		
    	}
    	
    	System.out.println(high_score);
    	
    	
    }
}

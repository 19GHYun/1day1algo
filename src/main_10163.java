import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int jongyi = sc.nextInt();
    	int total = 0;
    	int checksum = 1;
    	
    	int[][] dohwaji = new int[1002][1002];
    	
    	
    	for(int i = 1 ; i <= jongyi ; i++) {
	    	int x1 = sc.nextInt();
	    	int y1 = sc.nextInt();
	    	int x2 = sc.nextInt() + x1;
	    	int y2 = sc.nextInt() + y1;
    	
	    	for(int j = x1 ; j < x2 ; j++) {
	    		for(int k = y1 ; k < y2 ; k++) {
	    			dohwaji[j][k] = i;
	    		}
	    	}
    	
    	}
    	for(int p = 0 ; p < jongyi ; p++) {
	    	for(int i = 0 ; i < 1002 ; i++) {
	    		for(int j = 0 ; j < 1002 ; j++) {
	    			if(dohwaji[i][j] == checksum) {
	    				total++;
	    			}
	    		}
	    	}
	    	System.out.println(total);
	    	total = 0;
	    	checksum++;
    	}
    }
}

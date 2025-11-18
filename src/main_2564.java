import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
    	Scanner sc = new Scanner(System.in);

    	int x = sc.nextInt();
    	int y = sc.nextInt();
    	   	
    	int shop_num = sc.nextInt();
    	
    	int[] shop_where = new int[shop_num];
    	int[] shop_long = new int[shop_num];
    	
    	for(int i = 0 ; i < shop_num ; i++) {
    		shop_where[i] = sc.nextInt();
    		shop_long[i] = sc.nextInt();
    		
    	}
    	
    	int man_where = sc.nextInt();
    	int man_long = sc.nextInt();
    	
    	int total_move = 0;
    	int move1 = 0;
    	int move2 = 0;
    	
    	for(int i = 0 ; i < shop_num ; i++) {
    		if(man_where == 2) {
    			if(shop_where[i] == 2) {
    				move1 = man_long - shop_long[i];
    				if(move1 < 0) {
    					move1 = move1 * -1;
    				}
    				move2 = y + y + x + man_long + x - shop_long[i];

    			}
    			else if(shop_where[i] == 1) {
    				move1 = y + man_long + shop_long[i];
    				move2 = y + x - man_long + x - shop_long[i];
    			}
    			else if(shop_where[i] == 3) {
    				move1 = man_long + (y - shop_long[i]);
    				move2 = x + y + 2;
    			}
    			else if(shop_where[i] == 4) {
    				move1 = x - man_long + y - shop_long[i];
    				move2 = x + y  + 2;
    			}
    		}
    		else if(man_where == 1) {
    			if(shop_where[i] == 2) {
    				move1 = y + man_long + shop_long[i];
    				move2 = y + x - man_long + x - shop_long[i];
    			}
    			else if(shop_where[i] == 1) {
    				move1 = man_long - shop_long[i];
    				if(move1 < 0) {
    					move1 = move1 * -1;
    				}
    				move2 = y + y + x + man_long + x - shop_long[i];

    			}
    			else if(shop_where[i] == 3) {
    				move1 = man_long + shop_long[i];
    				move2 = x + y + 2;
    			}
    			else if(shop_where[i] == 4) {
    				move1 = x - man_long + shop_long[i];
    				move2 = x + y + 2;
    			}
    		}
    		else if(man_where == 3) {
    			if(shop_where[i] == 1) {
    				move1 = man_long + shop_long[i];
    				move2 = x + y + 2;
    			}
    			else if(shop_where[i] == 2) {
    				move1 = y - man_long + shop_long[i];
    				move2 = x + y + 2;
    			}
    			else if(shop_where[i] == 3) {
    				move1 = shop_long[i] - man_long;
    				if(move1 < 0 ) {
    					move1 = move1 * -1;
    				}
    				move2 = x + x + y ;
    			}
    			else if(shop_where[i] == 4) {
    				move1 = x + shop_long[i] + man_long;
    				move2 = x + y - shop_long[i] + y - man_long;
    			}
    		}
    		else if(man_where == 4) {
    			if(shop_where[i] == 1) {
    				move1 = man_long + x - shop_long[i];
    				move2 = x + y + 2;
    			}
    			else if(shop_where[i] == 2) {
    				move1 = x - shop_long[i] + y - man_long;
    				move2 = x + y + 2;
    			}
    			else if(shop_where[i] == 3) {
    				move1 = x + shop_long[i] + man_long;
    				move2 = x + y - shop_long[i] + y - man_long;
    			}
    			else if(shop_where[i] == 4) {
    				move1 = shop_long[i] - man_long;
    				if(move1 < 0 ) {
    					move1 = move1 * -1;
    				}
    				move2 = x + x + y ;
    			}
    		}
    		//여기서 무브 짧은거 total에 더하고 0으로 초기화들 해야함.
    		if(move1 <= move2) {
    			total_move += move1;
    		}
    		else {
    			total_move += move2;
    		}
    		move1 = 0;
    		move2 = 0;
    		
    		
    	}
    	System.out.println(total_move);
    }
}

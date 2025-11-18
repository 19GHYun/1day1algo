import java.io.*;
import java.util.*;

public class Main {

	static boolean check = false;
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int size = sc.nextInt();
    	int humans;
    	int sex;
    	int where;
    	int where_s;
    	
    	int[] switches = new int[size];
    	
    	for(int i = 0 ; i < switches.length ; i++) {
    		switches[i] = sc.nextInt();
    	}
    		
    	humans = sc.nextInt();
    	
    	for(int i = 0 ; i < humans ;  i++) {
    		check = false;
    		sex = sc.nextInt();
    		where = sc.nextInt();
    		where_s = where;
    		where--;
    		if(sex == 1) {
    			for(int j = where  ; j < switches.length ; j += where_s ) {
    				if(switches[j] == 1) {
    					switches[j] = 0;
    				}else {
    					switches[j] = 1;
    				}
    			}
    		}
    		else {
    			for(int k = 0 ; k < switches.length ; k++) {
    				if(switches[where] == 1 && check == false) {
    					switches[where] = 0;
    					check = true;
    				}else if(switches[where] == 0 && check == false) {
    					switches[where] = 1;
    					check = true; 
    				}
    				else {
    				try {
        				if(switches[where - k] != switches[where + k]) {
        					break;
        				}
    					if(switches[where - k] == switches[where + k]) {
    						if(switches[where - k ] == 1) {
    							switches[where - k] = 0;
    							switches[where + k] = 0;
    						}
    						else if(switches[where - k] == 0) {
    							switches[where - k] = 1;
    							switches[where + k] = 1;
    						}
    					}
    				}catch (ArrayIndexOutOfBoundsException e) {
    					break;
    				}
    			}
    			}
    			
    		}

 
    	}
    	
    	if(switches.length > 0 &&switches.length <= 20) {
	    	for(int p = 0 ; p < switches.length ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
    	}
    	else if(switches.length > 20 && switches.length <= 40) {
	    	for(int p = 0 ; p < 20 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 20 ; p < switches.length ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
    	}
    	else if(switches.length > 40 && switches.length <= 60) {
	    	for(int p = 0 ; p < 20 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 20 ; p < 40 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 40 ; p < switches.length ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
    	}
    	else if(switches.length > 60 && switches.length <= 80) {
	    	for(int p = 0 ; p < 20 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 20 ; p < 40 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 40 ; p < 60 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 60 ; p < switches.length ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
    	}
    	else if(switches.length > 80 && switches.length <= 100) {
	    	for(int p = 0 ; p < 20 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 20 ; p < 40 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 40 ; p < 60 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 60 ; p < 80 ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
	    	System.out.println();
	    	for(int p = 80 ; p < switches.length ; p++) {
	    		System.out.print(switches[p] + " ");
	    	}
    	}
    	
    }
    
    
    


}

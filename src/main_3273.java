import java.util.*;
import java.io.*;


public class Main {

	public static int count = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int[] arr =new int[N];
    	
    	for(int i = 0 ; i < N ; i++) {
    		arr[i]=sc.nextInt();
    	}
    	Arrays.sort(arr);
    	
    	int X = sc.nextInt();
    	
    	twoPoint(arr, X);
    	
    	System.out.print(count);
    	
	}
	
    public static void twoPoint(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                count++;
                left++;
            } else if (sum < target) {
                left++;  
            } else {
                right--; 
            }
        }

      
    }
	
}

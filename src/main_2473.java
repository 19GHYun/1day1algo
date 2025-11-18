import java.io.*;
import java.util.*;

	public class Main {
		public static ArrayList<Integer> list = new ArrayList<>();
		public static int N;
		public static int[] answer = new int[3];
		public static long check_num = Long.MAX_VALUE;
		
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        
	        N = Integer.parseInt(br.readLine());
	        
	        st = new StringTokenizer(br.readLine());
	        
	        for(int i = 0 ; i < N ; i++) {
	        	list.add(Integer.parseInt(st.nextToken()));
	        }
	        
	        Collections.sort(list);
	        
	        for(int i = 0 ; i < N ; i++) {
	        	pt3(0,N-1,i);
	        	if(check_num == 0) {
	        		break;
	        	}
	        }

	        Arrays.sort(answer);
		        
	        
	        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	        
	    }
	    
	    public static void pt3(int start, int end, int gojung) {
	        if (start >= end) {
	            return;
	        }
	        if (gojung == start) {
	            pt3(start + 1, end, gojung);
	            return;
	        }
	        if (gojung == end) {
	            pt3(start, end - 1, gojung);
	            return;
	        }

	        long a = (long) list.get(start) + list.get(end) + list.get(gojung);

	        // 기존 check_num보다 작은 경우 갱신
	        if (Math.abs(a) < check_num || (Math.abs(a) == check_num && 
	            (list.get(start) > answer[0] || list.get(end) > answer[1] || list.get(gojung) > answer[2]))) {
	            check_num = Math.abs(a);
	            answer[0] = list.get(start);
	            answer[1] = list.get(end);
	            answer[2] = list.get(gojung);
	        }

	        if (a < 0) {
	            pt3(start + 1, end, gojung);
	        } else {
	            pt3(start, end - 1, gojung);
	        }
	    }


	    
	}

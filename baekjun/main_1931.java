import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting> { // 미팅 클래스 생성
    int start, end;
    
    Meeting(int start, int end) { // 시작과 끝 시간을 가지고 있음.
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end != o.end) { // 끝 시간이 다르면?
        	return Integer.compare(this.end, o.end); // 끝 시간으로 정렬
        }
        return Integer.compare(this.start, o.start); // 끝 시간이 같으면 시작시작으로 정렬
    }
}

public class Main {
    
    static int N, max_time, time[];
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); // 회의 개수
        ArrayList<Meeting> meeting_list = new ArrayList<>(N); 
        
        for(int i = 0 ; i < N ; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	meeting_list.add(new Meeting(start, end)); // 미팅 리스트란 곳에 회의 시작 끝 넣음.
        }
        
        
        Collections.sort(meeting_list); // 정렬
        
        int count = 0;
        int lasttime = -1;
        
        for(Meeting cur_meet : meeting_list) { // 다 돌리는데,
        	if(cur_meet.start >= lasttime) { // 끝나는 시간 기준으로 시작시간이 >= 즉 같거나 크면
        		count++;
        		lasttime = cur_meet.end; // 회의 했다고 칩니다.
        	}
        }
        
        System.out.println(count);
    }
}

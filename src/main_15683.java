import java.util.*;
import java.io.*;

class CCTV{
	int x;
	int y;
	int mode;
	int where = 0; // cctv 방향 0이면 북쪽, 1이면 동쪽, 2면 남쪽, 3이면 서쪽
	
	public CCTV(int x,int y,int mode, int where){
		this.x = x;
		this.y = y;
		this.mode = mode;
		this.where = where;
	}
}

public class Main {
	public static int[][] arr;
	public static boolean[][] check;
	public static int N,M,size,localanswer;
	public static ArrayList<CCTV> actionlist = new ArrayList<>();
	public static ArrayList<CCTV> list = new ArrayList<>();
	public static int answer = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1][M + 1];
        check = new boolean[N+1][M+1];        
        
        for(int i = 1 ; i <= N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1 ; j <= M ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		
        		if(arr[i][j]>0 && arr[i][j] <6) {
        			list.add(new CCTV(i,j,arr[i][j], 0));
        			size++;
        		}
        		if(arr[i][j] == 6) {
        			check[i][j] = true;
        		}
        	}
        }
        backt(0);
        
        System.out.println(answer);
        
        
    }

	public static void backt(int cnt) {
    	if(actionlist.size() == list.size()) {
    		bfs();
    		
//    		answer = Math.min(answer, localanswer);
    		return;
    	}
    	CCTV cctv = list.get(cnt);
    	cctv.where = 0;
    	actionlist.add(cctv);
    	backt(cnt+1);
    	actionlist.remove(actionlist.size()-1);
    	cctv.where = 1;
    	actionlist.add(cctv);
    	backt(cnt+1);
    	actionlist.remove(actionlist.size()-1);
    	cctv.where = 2;
    	actionlist.add(cctv);
    	backt(cnt+1);
    	actionlist.remove(actionlist.size()-1);
    	cctv.where = 3;
    	actionlist.add(cctv);
    	backt(cnt+1);
    	actionlist.remove(actionlist.size()-1);
    	
    }
	
	public static void bfs() {
		boolean[][] newcheck = new boolean[N+1][M+1];
		Queue<int[]> que = new ArrayDeque<>();
		for (int i = 0; i <= N; i++) {
		    newcheck[i] = Arrays.copyOf(check[i], M + 1);
		}
		for(int i = 0 ; i < actionlist.size() ; i++) {
			localanswer = 0;
			CCTV cctv = actionlist.get(i);
			newcheck[cctv.x][cctv.y]= true; 
			que.add(new int[] {cctv.x, cctv.y, cctv.mode, cctv.where, 0});
			while(!que.isEmpty()) {
				int[] where = que.poll();
				int x = where[0];
				int y = where[1];
				int mode = where[2];
				int whereing = where[3];
				int jikjin = where[4];
				switch(mode) {
				case(1):
					switch(whereing) {
					case(0):
						if(x - 1 > 0 && arr[x - 1][y] != 6) {
							newcheck[x - 1][y] = true;
							que.add(new int[] {x - 1,y,mode,whereing,1});
						}
						break;
					
					case(1):
						if(y + 1 <= M && arr[x][y + 1] != 6 ) {
							newcheck[x][y+1] = true;
							que.add(new int[] {x,y+1,mode,whereing,2});
						}
						break;
					
					case(2):
						if(x + 1 <= N && arr[x + 1][y] != 6) {
							newcheck[x + 1][y] = true;
							que.add(new int[] {x + 1,y,mode,whereing,3});
						}
						break;
					
					case(3):
						if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
							newcheck[x][y-1] = true;
							que.add(new int[] {x,y-1,mode,whereing,4});
						}
						break;
					}
					break;
				
				case(2):
					switch(whereing) {
					case(0):
						if(jikjin == 0) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}
						else if(jikjin == 1) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
						}
						else if(jikjin == 3) {
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}

						break;
					
					case(1):
						if(jikjin == 0) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}
						else if(jikjin == 2) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
						}
						else if(jikjin == 4) {
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}
						break;
					
					case(2):
						if(jikjin == 0) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}
						else if(jikjin == 1) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
						}
						else if(jikjin == 3) {
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}
						break;
					
					case(3):
						if(jikjin == 0) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}
						else if(jikjin == 2) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
						}
						else if(jikjin == 4) {
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}
						break;
					}
					break;
				
				case(3):
					switch(whereing) {
					case(0):
						if(jikjin == 0) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
						}
						else if(jikjin == 1) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
						}
						else if(jikjin == 2) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
						}


						break;
					
					case(1):
						if(jikjin == 0) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}
						else if(jikjin == 2) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
						}
						else if(jikjin == 3) {
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}


						break;
					
					case(2):
						if(jikjin == 0) {
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}
						else if(jikjin == 3) {
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}
						else if(jikjin == 4) {
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}


						break;
					
					case(3):
						if(jikjin == 0) {
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
						}
						else if(jikjin == 4) {
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}
						else if(jikjin == 1) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
						}
						break;
					}
					break;
				
				case(4):
					switch(whereing) {
					case(0):
						if(jikjin == 0) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}
						else if(jikjin == 1) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
						}
						else if(jikjin == 2) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
						}
						else if(jikjin == 3) {
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}



						break;
					
					case(1):
						if(jikjin == 0) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}
						else if(jikjin == 1) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
						}
						else if(jikjin == 2) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
						}
						else if(jikjin == 4) {
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}

						break;
					
					case(2):
						if(jikjin == 0) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}
						else if(jikjin == 1) {
							if(x - 1 > 0 && arr[x - 1][y] != 6) {
								newcheck[x - 1][y] = true;
								que.add(new int[] {x - 1,y,mode,whereing,1});
							}
						}
						else if(jikjin == 3) {
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}
						else if(jikjin == 4) {
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}

						break;
					
					case(3):
						if(jikjin == 0) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}
						else if(jikjin == 2) {
							if(y + 1 <= M && arr[x][y + 1] != 6 ) {
								newcheck[x][y+1] = true;
								que.add(new int[] {x,y+1,mode,whereing,2});
							}
						}
						else if(jikjin == 3) {
							if(x + 1 <= N && arr[x + 1][y] != 6) {
								newcheck[x + 1][y] = true;
								que.add(new int[] {x + 1,y,mode,whereing,3});
							}
						}
						else if(jikjin == 4) {
							if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
								newcheck[x][y-1] = true;
								que.add(new int[] {x,y-1,mode,whereing,4});
							}
						}

						break;
					}
					break;
				
				case(5):
					
					if(jikjin == 0) {
						if(x - 1 > 0 && arr[x - 1][y] != 6) {
							newcheck[x - 1][y] = true;
							que.add(new int[] {x - 1,y,mode,whereing,1});
						}
						if(y + 1 <= M && arr[x][y + 1] != 6 ) {
							newcheck[x][y+1] = true;
							que.add(new int[] {x,y+1,mode,whereing,2});
						}
						if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
							newcheck[x][y-1] = true;
							que.add(new int[] {x,y-1,mode,whereing,3});
						}
						if(x + 1 <= N && arr[x + 1][y] != 6) {
							newcheck[x + 1][y] = true;
							que.add(new int[] {x + 1,y,mode,whereing,4});
						}
					}
					else if(jikjin == 1) {
						if(x - 1 > 0 && arr[x - 1][y] != 6) {
							newcheck[x - 1][y] = true;
							que.add(new int[] {x - 1,y,mode,whereing,1});
						}
					}
					else if(jikjin == 2) {
						if(y + 1 <= M && arr[x][y + 1] != 6 ) {
							newcheck[x][y+1] = true;
							que.add(new int[] {x,y+1,mode,whereing,2});
						}
					}
					else if(jikjin == 3) {
						if(y - 1 > 0 && arr[x][y - 1] != 6 ) {
							newcheck[x][y-1] = true;
							que.add(new int[] {x,y-1,mode,whereing,3});
						}
					}
					else if(jikjin == 4) {
						if(x + 1 <= N && arr[x + 1][y] != 6) {
							newcheck[x + 1][y] = true;
							que.add(new int[] {x + 1,y,mode,whereing,4});
						}
					}

					break;
				}
				
			}
			
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int ii = 1 ; ii <= M ; ii++) {
				if(!newcheck[i][ii]) {
					localanswer++;
				}
			}
			
		}
		answer = Math.min(answer, localanswer);
	}

}

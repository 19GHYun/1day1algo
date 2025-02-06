import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int nosee_num = sc.nextInt();
		int noheard_num = sc.nextInt();
		
		HashSet<String> a = new HashSet<>();
		
		HashSet<String> nosee = new HashSet<>();
		
		HashSet<String> noheard = new HashSet<>();
		
		

		
		for(int i = 0 ; i < nosee_num ; i++) {
			nosee.add(sc.next());
		}
		for(int i = 0 ; i < noheard_num ; i++) {
			noheard.add(sc.next());
		}
		
		List<String> tempSet2 = new ArrayList<>(noheard);
		Collections.sort(tempSet2);
		
		for(int i = 0 ; i < tempSet2.size() ; i++) {
			String abc = tempSet2.get(i);
			if(nosee.contains(abc)){
				a.add(abc);
			}
		}
		
		
		List<String> tempSet = new ArrayList<>(a);
		Collections.sort(tempSet);
		
		System.out.println(tempSet.size());
		for(String m : tempSet) {
			System.out.println(m);
		}
		
	}
	

}

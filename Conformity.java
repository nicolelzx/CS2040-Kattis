import java.util.*;

public class Conformity {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<ArrayList<Integer>,Integer> map = new HashMap<ArrayList<Integer>,Integer>();

		for (int i=0; i<n; i++) {
			ArrayList<Integer> combi = new ArrayList<Integer>();
			for (int j=0; j<5; j++) {
				int course = sc.nextInt();
				combi.add(course);
			}
			Collections.sort(combi);
			if (map.containsKey(combi)==true) {
				map.put(combi, map.get(combi) +1);
			}
			else {
				map.put(combi, 1);
			}
		}

		int total = 0;
		int max = 0;
		for ( Integer value : map.values() ) {
			if (value>max) {
				total = value;
				max = value;
			}
			else {
				if (value==max){
					total += value;
				}
			}
		}

		System.out.println(total);

	}
}
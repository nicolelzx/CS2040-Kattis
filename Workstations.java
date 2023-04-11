import java.util.*;
import java.lang.*;

class Researcher {
    public int arr;
    public int stay; 
    Researcher(int arr, int stayingTime) {
        this.arr = arr; 
        this.stay = stay; 
    }
}

class SortbyArr implements Comparator<Researcher> {
    public int compare(Researcher a, Researcher b) {
    	return a.arr - b.arr;
    }
}

public class Workstations {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int buffer = sc.nextInt();
		int unlocks = 0;

		//make sorted arraylist of researchers
		ArrayList<Researcher> list = new ArrayList<Researcher>();
		for (int i=0; i<n; i++) {
    		list.add(new Researcher(sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(list, new SortbyArr() {
    		@Override
    		public int compare(final Researcher a, final Researcher b) {
        		return a.arr - b.arr;
    		}
		} );

		//make 2 heaps "in_use" and "unused_unlocked"
		PriorityQueue<Integer> in_use = new PriorityQueue<Integer>();
		PriorityQueue<Integer> unused_unlocked = new PriorityQueue<Integer>();

		for (int i=0; i<list.size(); i++) {
			Researcher person = list.get(i);
			int arrtime = person.arr;
			int staytime = person.stay;

			//Step 1
			Iterator<Integer> itr = in_use.iterator();
			while (itr.hasNext()) { 
				int value = itr.next();
				if (value<=arrtime) {
					in_use.remove(value);
					int new_value = value + buffer;
					unused_unlocked.add(new_value);
				}
			}

			//Step 2
			Iterator<Integer> itr2 = unused_unlocked.iterator();
			while (itr2.hasNext()) { 
				int value2 = itr2.next();
				if (value2<arrtime) {
					unused_unlocked.remove(value2);
				}
			}

			//Step 3
			if (unused_unlocked.size()!=0) {
				int smallest = unused_unlocked.peek();
				unused_unlocked.remove(smallest);
				unlocks++;
			}

			//Step 4
			in_use.add(arrtime+staytime);
		}

		System.out.println(unlocks);
	}
}
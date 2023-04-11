import java.util.*;

class Quest {
	public long energy;
	public long gold;
	public int num;

	Quest(long energy, long gold, int num){
		this.energy = energy;
		this.gold = gold;
		this.num = num;
	}
}

class Comp implements Comparator<Quest> {
	@Override
	public int compare(Quest a, Quest b) {
		Long energy_a = new Long(a.energy);
		Long energy_b = new Long(b.energy);
		int eComp = energy_a.compareTo(energy_b);

		Long gold_a = new Long(a.gold);
		Long gold_b = new Long(b.gold);
		int gComp = gold_a.compareTo(gold_b);

		Integer num_a = new Integer(a.num);
		Integer num_b = new Integer(b.num);
		int nComp = Integer.compare(num_a, num_b);

		return (eComp != 0) 
		? eComp
		: (gComp != 0)
		? gComp
		: nComp ;
	}
}

public class Kattisquest {
	public static void main(String[] args) {

		TreeSet<Quest> quests = new TreeSet<Quest>(new Comp()) ;
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();

		for (int i=0; i<n; i++) {
			String command = sc.next();

			if (command.equals("query")) {
				Long e = sc.nextLong();
				long winnings = 0;
				while (quests.floor(new Quest(e, 10000000, 0)) != null) {
					Quest complete = quests.floor(new Quest(e, 10000000, 0)) ;
					quests.remove(complete) ;
					winnings += complete.gold ;
					e -= complete.energy ;
				}
			System.out.println(winnings);
			}

			else { //command == "add"
				long e = sc.nextLong();
				long g = sc.nextLong();
				quests.add(new Quest(e,g,i));
			}

		}
	}
}
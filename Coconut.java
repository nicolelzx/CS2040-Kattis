import java.util.*;
import java.lang.*;

class Hand {	
	public int player;
	public String state;

	public Hand(int player, String state) {
		this.player = player;
		this.state = state;
	}
}

public class Coconut{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int n = sc.nextInt();
		LinkedList<Hand> list = new LinkedList<Hand>();
		
		for (int i=n; i>0; i-=1){
			Hand h = new Hand(i, "folded");
			list.addFirst(h);
		}

		while (list.size()>1){
			for (int j=0; j<(s-1); j++) {
				list.addLast( list.removeFirst() );
			}
			Hand curr_hand = list.removeFirst();
			if (curr_hand.state == "folded") {
				list.addFirst( new Hand(curr_hand.player, "fist"));
				list.addFirst( new Hand(curr_hand.player, "fist"));
			}
			else if (curr_hand.state == "fist") {
				list.addLast( new Hand(curr_hand.player, "palm"));
			}
			else {
				continue;
			}
		}

		int Winner = list.get(0).player;
		System.out.println(Winner);

	}
}

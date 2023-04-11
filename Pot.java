import java.util.*;
import java.lang.*;

public class Pot{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int x = 0;
		for (int i=0; i<count; i++) {
			int num = sc.nextInt() ;
			int term = num/10 ;
			int power = num % 10 ;
			x += Math.pow(term,power) ;
		}
		System.out.println(x);

	}
}
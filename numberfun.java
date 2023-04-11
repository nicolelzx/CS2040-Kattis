import java.util.*;
import java.lang.*;

public class numberfun {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			double a = sc.nextInt();
			double b = sc.nextInt();
			double c = sc.nextInt();
			Double[] arr = new Double[]{(a+b),(a-b),(b-a),(a*b),(a/b),(b/a)};           
			if (Arrays.asList(arr).contains(c)) {
				System.out.println("Possible");
			}
			else {
				System.out.println("Impossible");
			}
		}
		
	}
}
import java.util.*;
import java.lang.*;

public class Diff{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			String result = "";
			String a = sc.nextLine();
			String b = sc.nextLine();
			for (int j=0; j< a.length(); j++) {
				if (a.substring(j)==b.substring(j)) {
					result += ".";
				}
				else {
					result += "*";
				}
			}

			System.out.println(a);
			System.out.println(b);
			System.out.println(result);
			System.out.println();
		}

	}
}
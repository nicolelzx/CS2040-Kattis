import java.util.*;
import java.lang.*;

public class lastfactorialdigit{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i=0 ; i<n ; i++) {
			int x = sc.nextInt();
			int f = 1;
			for (int j=2;j<=x;j++){
				f = f*j;
			}
			String str = Integer.toString(f);
			int digit = Character.getNumericValue( str.charAt( str.length()-1 ) );
			System.out.println(digit);

		}
	}
}
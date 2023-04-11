import java.util.*;

public class Weakvertices {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
		while ( (n = sc.nextInt()) != -1 ) {
			List<Integer> weak = new ArrayList<Integer>();
			int[][] matrix = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			for (int i=0; i<n; i++) { //row
				boolean vertex = true;
				for (int j=0; j<n-1; j++) { //in the row
					if (matrix[i][j]==0) {
						continue;
					}
					else {
						for (int k=j+1; k<n; k++) { //compare in the row
							if (matrix[i][k]==1 && matrix[j][k]==1) {
								vertex = false;
							}
						}
					}
						
				}
				if (vertex==true) {
					weak.add(i);
				}
			}

			for (int i=0; i<weak.size(); i++) {
				System.out.print(weak.get(i));
				System.out.print(" ");
			}
			System.out.println();
		}

	}
}
import java.util.*;

class UnionFind {
	public int[] p;
	public int[] rank;

	public UnionFind(int N) {
	    p = new int[N];
	    for (int i = 0; i < N; i++) {
	    	p[i] = i+1;
	    }
  	}

	public int findSet(int i) { 
		if (p[i-1] == i) return i;
		else {
	    	p[i-1] = findSet(p[i-1]);
	    	return p[i-1]; 
	    } 
	}

	public Boolean isSameSet(int i, int j) { return findSet(i-1) == findSet(j-1); }

	public void unionSet(int i, int j) { 
    	if (!isSameSet(i, j)) { 
    		for (int k=0; k<p.length; k++) {
    			if (p[k]==p[i]) {
    				p[k]=p[j];
    			}
    		}
    	}
  	}

  	public void moveToSet(int i, int j) {
  		if (!isSameSet(i,j)) {
  			p[i] = p[j];
  		}
  	}

  	public void numSumSet(int i) {
  		int x = p[i];
  		int num = 0;
  		int sum = 0;
  		for (int j=0; j<p.length; j++) {
  			if (p[j]==x) {
  				num += 1;
  				sum += j;
  			}
  		}
  		System.out.print(num + " " + sum);
  		System.out.println();
  	}
}

public class Almostunionfind {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int elements = sc.nextInt();
		int n = sc.nextInt();
		UnionFind set = new UnionFind(elements);

		for (int i=0; i<n; i++) {
			int command = sc.nextInt();
			if (command==1) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				set.unionSet(a,b);
			}
			else if (command==2) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				set.moveToSet(a,b);
			}
			else {
				int a = sc.nextInt();
				set.numSumSet(a);
			}
		}
	}
}
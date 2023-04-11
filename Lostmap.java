import java.util.*;
import java.io.*;

class Triple{
	public int v1;
	public int v2;
	public int w;
	Triple(int v1, int v2, int w) {
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}
}

class UnionFind {                                              
  public int[] p;
  public int[] rank;
  public UnionFind(int N) {
    p = new int[N];
    rank = new int[N];
    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i] = 0;
    }
  }
  public int findSet(int i) { 
    if (p[i] == i) return i;
    else {
      p[i] = findSet(p[i]);
      return p[i]; 
    } 
  }
  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      int x = findSet(i), y = findSet(j);
      // rank is used to keep the tree short
      if (rank[x] > rank[y]) 
      	p[y] = x;
      else { 
      	p[x] = y;
        if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
      } 
    } 
  }
}

class Comp implements Comparator<Triple> {
	@Override
	public int compare(Triple a, Triple b) {
		return Integer.compare(a.w, b.w);
	}
}

public class Lostmap{
	public static void main(String[] args) throws IOException {
		ArrayList<Triple> list = new ArrayList<Triple>();
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++){
			String str = br.readLine();
			String[] strarr = str.split(" ");
			for (int j=0; j<n; j++){
				int w = Integer.parseInt(strarr[j]);
				Triple edge = new Triple(i,j,w);
				list.add(edge);
			}
		}
		Collections.sort(list, new Comp());
		UnionFind set = new UnionFind(n);
		 for (int i=0; i<list.size(); i++){
		 	int u = list.get(i).v1;
		 	int v = list.get(i).v2;
		 	if (set.isSameSet(u, v)==false){
		 		set.unionSet(u,v);
		 		int new_u = u+1;
		 		int new_v = v+1;
		 		System.out.print(new_u + " " + new_v);
		 		System.out.println();
		 	}
		 }

	}
}
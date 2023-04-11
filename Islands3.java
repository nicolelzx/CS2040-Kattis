import java.util.*;
import java.lang.*;

class Duo{
	public int key;
	public int value;
	Duo(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class Islands3{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		Character[][] graph = new Character[r][c]; //GRAPH
		for (int i=0; i<r; i++) {
			String line = sc.next();
			for (int j=0; j<c; j++) {
				graph[i][j] = line.charAt(j);
			}
		}
		boolean[][] visited = new boolean[r][c]; //VISITED
		ArrayList<Duo> queue = new ArrayList<Duo>(); //QUEUE
		int islands = 0; //ISLANDS

		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (graph[i][j].equals('L') && visited[i][j]==false) {
					islands += 1;
					queue.add(new Duo(i,j));
					visited[i][j] = true;
					
					while (!queue.isEmpty()) {
						Duo cell_to_check = queue.remove(0);
						int og_r = cell_to_check.key;
						int og_c = cell_to_check.value;
						Duo up = new Duo( og_r-1, og_c );
						Duo down = new Duo( og_r+1, og_c );
						Duo left = new Duo( og_r, og_c-1 );
						Duo right = new Duo( og_r, og_c+1 );
						ArrayList<Duo> directions = new ArrayList<Duo>( Arrays.asList(up, down, left, right) );
						for (int k=0; k<directions.size(); k++) {
							int new_r = directions.get(k).key;
							int new_c = directions.get(k).value;
							if (new_r<r && new_r>=0 && new_c<c && new_c>=0) {
								Character next_cell = graph[new_r][new_c];
								if ((next_cell.equals('C') || next_cell.equals('L')) && visited[new_r][new_c]==false) {
									queue.add(new Duo(new_r, new_c));
									visited[new_r][new_c] = true;
								}
							} 
						}
					}

				}
			}
		}
		System.out.println(islands);

	}
}
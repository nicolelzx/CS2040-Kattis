import java.util.*;
import java.io.*;
import java.lang.*;

public class Teque{
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i=0; i<n; i++) {
			String str = br.readLine();
			String[] str_arr = str.split(" ");
			String order = str_arr[0];
			int num = Integer.parseInt(str_arr[1]);

			if (order=="push_front"){
				list.add(0, num);
			}

			else if (order=="push_back"){
				list.add(num);
			}

			else if (order=="push_middle"){
				if ((list.size()%2)==0) {
					int idx = list.size()/2;
					list.add(idx, num);
				}
				else {
					int idx = (list.size()+1)/2;
					list.add(idx, num);
				}
			}

			else { // "get"
				int x = list.get(num);
				pw.print(Integer.toString(x));
			}

		pw.close();

		}
	}
}

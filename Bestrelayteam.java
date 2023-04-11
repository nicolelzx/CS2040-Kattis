import java.util.*;

public class Bestrelayteam {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (i=1, i<=n, i++){
			double ogfirst = 100;
			double[] ogothers = new double[]{100.0,90.0,80.0};
			String runner = "s";
			String[] runners = new String[]{"s","s","s"};

			String line = sc.nextLine();
			String[] arr = line.split(" ");
			String name = arr[0];
			double first = Double.parseDouble(arr[1]);
			double others = Double.parseDouble(arr[2]);

			if (first<ogfirst){
				ogfirst = first;
				runner = name;
			}

			double max = Collections.max(Arrays.asList(ogothers));
			int i = ogothers.indexOf(max);
			if (others<max){
				arr[i] = others;
				runners[i] = name;
			}
			
			return ogfirst;
			return ogothers;
			return runner;
			return runners;
		}
		
		sum = ogothers[0] + ogothers[1] + ogothers[2] + ogfirst;
		System.out.println(sum);
		System.out.println(runner);
		System.out.println(Arrays.asList(runners));

	}
}
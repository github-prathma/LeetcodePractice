import java.io.*;
import java.util.*;

class FlowerPlanting {

	public static int[] gardenNoAdj(int N, int[][] paths) {
		int[] flowers = {1,2,3,4};

		List<List<Integer>> graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<Integer>());
        }
 
		for (int i=0; i < paths.length; i++) {
			graph.get(paths[i][0]).add(paths[i][1]);
			graph.get(paths[i][1]).add(paths[i][0]);
		}

		int[] output = new int[N];
		output[0] = flowers[0];

		for (int i=2; i<=N; i++) {
			List<Integer> usedFlowers = new ArrayList<>();

			for (int j=0; j<graph.get(i).size(); j++) {
				usedFlowers.add(output[graph.get(i).get(j) - 1]);
			}

			for (int f = 0; f < flowers.length; f++) {
				if (!usedFlowers.contains(flowers[f])) {
					output[i-1] = flowers[f];
					break;
				}
			}
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Number of gardens:");
		int n = Integer.parseInt(br.readLine());

		System.out.println("Number of paths:");
		int p = Integer.parseInt(br.readLine());

		int[][] paths = new int[p][2];

		for (int i = 0; i<p; i++) {
			String s = br.readLine();
			String[] sArr = s.split(" ");

			paths[i][0] = Integer.parseInt(sArr[0]);
			paths[i][1] = Integer.parseInt(sArr[1]);
		}

		int[] ans = gardenNoAdj(n, paths);
		for (int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
	}
}
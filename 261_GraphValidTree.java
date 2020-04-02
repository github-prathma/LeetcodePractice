import java.util.*;
import java.io.*;

class ValidTree {

	public static boolean dfs(int node, int parent, HashSet<Integer> visited, List<List<Integer>> adjacency) {
		if (visited.contains(node)) {
			return false;
		}
		visited.add(node);

		for (int ng : adjacency.get(node)) {
			if (parent != ng) {
				boolean res = dfs(ng, node, visited, adjacency);
				if (!res) {
					return false;
				}
			}
		}
		return true;

	}

	public static boolean validTree(int n, int[][] paths) {
		List<List<Integer>> adjacency = new ArrayList<>();

		for (int i=0; i<n; i++) {
			adjacency.add(new ArrayList<>());
		}

		for (int i=0; i<paths.length; i++) {
			adjacency.get(paths[i][0]).add(paths[i][1]);
			adjacency.get(paths[i][1]).add(paths[i][0]);
		}

		HashSet<Integer> visited = new HashSet<>();

		return dfs(0, -1, visited, adjacency) && visited.size() == n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Number of nodes: ");

		int n = Integer.parseInt(br.readLine());

		System.out.println("Number of paths: ");

		int p = Integer.parseInt(br.readLine());

		int[][] paths = new int[p][2];

		for (int i = 0; i<p; i++) {
			String s = br.readLine();
			String[] sArr = s.split(" ");

			paths[i][0] = Integer.parseInt(sArr[0]);
			paths[i][1] = Integer.parseInt(sArr[1]);
		}

		boolean ans = validTree(n, paths);
		System.out.println(ans);
	}
}
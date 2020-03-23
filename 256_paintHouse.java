import java.util.*;
import java.io.*;

class PaintHouse {

	public static int minCost(int[][] costs) {
		if (costs.length == 0) {
			return 0;
		}
		for (int i=costs.length-2; i>=0; i--) {
			costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
			costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
			costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);			
		}

		return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("No. of houses: ");

		int n = Integer.parseInt(br.readLine());

		int[][] costs = new int[n][3];

		for (int i=0; i<n; i++) {
			String s = br.readLine();
			String[] sArr = s.split(" ");

			for(int j=0; j<3; j++) {
				costs[i][j] = Integer.parseInt(sArr[j]);
			}
		}

		int ans = minCost(costs);
		System.out.println(ans);
	}
}
import java.util.*;
import java.io.*;


class MinCostClimbingStairs {

	public static int minCostClimbingStairs(int[] cost) {
		// int[] dp = new int[cost.length];
		// dp[0] = cost[0];
		// dp[1] = cost[1];

		// for (int i=2; i<dp.length; i++) {
		
		// 		dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
			
			
		// }

		// return Math.min(dp[cost.length-1], dp[cost.length-2]);

		//----constant space

		int oneStepBack = cost[0];
		int twoStepsBack = 0;

		for (int i=1; i<cost.length; i++) {
			int curr = Math.min(oneStepBack, twoStepsBack) + cost[i];
			twoStepsBack = oneStepBack;
			oneStepBack = curr;
		}

		return Math.min(oneStepBack, twoStepsBack);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] sArr  = s.split(" ");
		int[] nums = new int[sArr.length];

		for (int i=0; i<sArr.length; i++) {
			nums[i] = Integer.parseInt(sArr[i]);
		}

		System.out.println(minCostClimbingStairs(nums));
	}
}
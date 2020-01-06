import java.util.*;
import java.io.*;

class LongestIncreasingSubsequence {

	public static int LIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];

		dp[0] = 1;
		for (int i=1; i<nums.length; i++) {
			int maxLen = 0;
			for (int j=0; j<i; ++j) {
				if (nums[i] > nums[j]) {
					maxLen = Math.max(maxLen, dp[j]);
				}
			}
			dp[i] = maxLen + 1;
		}

		int maxans = Integer.MIN_VALUE;
		for (int i=0; i<dp.length; ++i) {
			if (dp[i] > maxans) {
				maxans = dp[i];
			}
		}
		return maxans;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int ans = LIS(nums);
		System.out.println(ans);
	}

}
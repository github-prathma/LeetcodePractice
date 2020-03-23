import java.util.*;
import java.io.*;

class HouseRobberII {

	public static int houseRobber1(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i=2; i<nums.length; i++) {
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
		}

		return dp[nums.length-1];
	}

	public static int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

        int[] numsExcludeFirst = new int[nums.length-1];
        int[] numsExcludeLast = new int[nums.length-1];
        
        for (int i=1; i<nums.length; i++) {
            numsExcludeFirst[i-1] = nums[i];
        }
        
        for (int i=0;i<nums.length-1; i++) {
            numsExcludeLast[i] = nums[i];
        }
        
        return Math.max(houseRobber1(numsExcludeFirst), houseRobber1(numsExcludeLast));
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] sArr = s.split(" ");

		int[] nums = new int[sArr.length];

		for (int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(sArr[i]);
		}

		int ans = rob(nums);
		System.out.println(ans);
	}
}
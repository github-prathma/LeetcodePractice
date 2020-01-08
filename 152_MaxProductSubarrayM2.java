import java.util.*;
import java.io.*;

class SubarrayProduct {

	public static int maxProduct(int[] nums) {
		int currMax = nums[0];
		int currMin = nums[0];

		int finalMax = nums[0];

		for (int i=1; i<nums.length; i++) {
			int t = currMax;

			currMax = Math.max(nums[i], Math.max(nums[i]*currMax, nums[i]*currMin));
			currMin = Math.min(nums[i], Math.min(nums[i]*currMin, nums[i]*currMax));
			if (currMax > finalMax) {
				finalMax = currMax;
			}
		}
		return finalMax;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int ans = maxProduct(nums);

		System.out.println(ans);
	}
}
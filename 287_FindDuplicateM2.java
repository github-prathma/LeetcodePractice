//linkedlist cycle detection pattern

import java.util.*;
import java.io.*;

class FindDuplicate {

	public static int findDuplicateCycleDetect(int[] nums) {
		int slow_p = nums[0];
		int fast_p = nums[0];

		slow_p = nums[slow_p];
		fast_p = nums[nums[fast_p]];

		while (slow_p != fast_p) {
			slow_p = nums[slow_p];
			fast_p = nums[nums[fast_p]];
		}

		int a_p = nums[0];
		int b_p = slow_p;

		while (a_p != b_p) {
			a_p = nums[a_p];
			b_p = nums[b_p];
		}
		return a_p;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int ans = findDuplicateCycleDetect(nums);

		System.out.println(ans);
	}
}
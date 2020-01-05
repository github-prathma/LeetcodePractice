import java.util.*;
import java.io.*;

class FindDuplicateNum {

	public static int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i<nums.length; ++i) {
			if (nums[i] == nums[i-1]) {
				return nums[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int ans = findDuplicate(nums);

		System.out.println(ans);
	}
}
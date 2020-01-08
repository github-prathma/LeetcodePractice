import java.util.*;
import java.io.*;

class SubarraySum {

	public static int countOfSubarrays(int[] nums, int k) {
		int count = 0;

		for (int i=0; i<nums.length; i++) {
			int sum = 0;
			for (int s=i; s<nums.length; s++) {
				sum += nums[s];
				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("k sum : ");
		int k = Integer.parseInt(br.readLine());

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int ans = countOfSubarrays(nums, k);

		System.out.println(ans);
	}
}
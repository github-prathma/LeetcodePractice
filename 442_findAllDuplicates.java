import java.io.*;
import java.util.*;

class FindDuplicates {

	public static List<Integer> find(int[] nums) {

		List<Integer> res = new ArrayList<>();

		for (int i=0; i<nums.length; ++i) {
			if (nums[Math.abs(nums[i]) - 1] > 0) {
				nums[Math.abs(nums[i]) - 1] *= -1;
			} else {
				res.add(Math.abs(nums[i]));
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		List<Integer> ans = find(nums);

		System.out.println(ans);
	}
}
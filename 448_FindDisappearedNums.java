import java.util.*;
import java.io.*;

class FindDisappearedNumbers {

	public static List<Integer> disappearedNums(int[] nums) {

		//index 0 to n-1 and nums 1 to n

		List<Integer> ans = new ArrayList<>();

		for (int i=0; i<nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			if (nums[index] > 0) {
				nums[index] *= -1;
			}
		}

		for (int i=1; i<=nums.length; i++) {
			if (nums[i-1] > 0) {
				ans.add(i);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}


		List<Integer> ans = disappearedNums(nums);

		for (Integer x : ans) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
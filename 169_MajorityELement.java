import java.io.*;
import java.util.*;

class MajorityElement {

	public static int majority(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int ans = majority(nums);

		
		System.out.println(ans);
	}
}
import java.util.*;
import java.io.*;

class ProductExceptSelf {

	public static int[] productOfArray(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		left[0] = 1;
		for (int i=1; i<nums.length; ++i) {
			left[i] = left[i-1]*nums[i-1];
		}

		right[nums.length-1] = 1;
		for (int i=nums.length-2; i>=0; i--) {
			right[i] = right[i+1]*nums[i+1];
		}

		int[] ans = new int[nums.length];
		for (int i=0; i<ans.length; ++i) {
			ans[i] = left[i] * right[i];
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

		int[] ans = productOfArray(nums);

		for (int x : ans) {
			System.out.print(x + " "); 
		}
		System.out.println();
	}
}
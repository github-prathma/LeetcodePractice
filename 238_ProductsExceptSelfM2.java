import java.util.*;
import java.io.*;

class ProductExceptSelfConstSpace {

	public static int[] productOfArray(int[] nums) {
		int[] left = new int[nums.length];

		left[0] = 1;
		for (int i=1; i<nums.length; ++i) {
			left[i] = left[i-1]*nums[i-1];
		}

		int r = 1;
		for (int i=nums.length-1; i>=0; i--) {
			left[i] = left[i]*r;
			r = r*nums[i];
		}

		return left;
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
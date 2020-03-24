import java.util.*;
import java.io.*;

class LargestRect2 {

	public static int calculateArea(int[] nums, int i, int j) {
		if (i>j) {
			return 0;
		}
		int minHeightIndex = i;

		for (int k=i; k<=j; k++) {
			if (nums[k] < nums[minHeightIndex]) {
				minHeightIndex = k;
			}
		}

		int fullArea = nums[minHeightIndex]*(j-i+1);
		int leftArea = calculateArea(nums, i, minHeightIndex-1);
		int rightArea = calculateArea(nums, minHeightIndex+1, j);

		return Math.max(Math.max(fullArea, leftArea), rightArea);
	}

	public static int largestRectangleArea(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		return calculateArea(nums, 0, nums.length-1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] sArr = s.split(" ");

		int[] nums = new int[sArr.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(sArr[i]);
		}

		int ans = largestRectangleArea(nums);
		System.out.println(ans);
	}
}
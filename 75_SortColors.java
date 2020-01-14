import java.util.*;
import java.io.*;

class Segregate012s {

	public static void sortColors(int[] nums) {
		int low = 0;
		int high = nums.length-1;
		int oneIndex = 0;

		while (oneIndex <= high) {
			if (nums[oneIndex] == 0) {
				int temp = nums[low];
				nums[low] = nums[oneIndex];
				nums[oneIndex] = temp;
				low++;
				oneIndex++;
			} else if (nums[oneIndex] == 2 ) {
				int temp = nums[oneIndex];
				nums[oneIndex] = nums[high];
				nums[high] = temp;
				high--;
			} else {
				oneIndex++;
			}
		}
		for (int x : nums) {
			System.out.print(x + " ");
		}
		System.out.println();

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		sortColors(nums);
	}

}
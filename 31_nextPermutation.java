import java.util.*;
import java.io.*;

class NextPermutation {

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void reverseArr(int[] nums, int pos) {
		int i = pos;
		int j = nums.length-1;
		while (i<=j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	public static void nextPermutation(int[] nums) {
		int i = nums.length-1;
		while (i > 0 && nums[i-1] >= nums[i]) {
			i--;
		}
		//if (i != nums.length-1) {
		i--;
	//	}

		if (i>=0) {
			int j = nums.length-1;
			while (j>=0 && nums[j]<=nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		// System.out.println(i);
		reverseArr(nums, i+1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		nextPermutation(nums);
		for (int x : nums) {
			System.out.print(x + " ");
		}
		System.out.println();

	}
}
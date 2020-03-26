import java.util.*;
import java.io.*;

class SingleElement {

	public static int nonDuplicate(int[] nums) {
		int i=0;
		int j=nums.length-1;

		while (i<=j) {
			int mid = (i+j)/2;

			boolean partitionEven = ((j-mid)%2 == 0);
			
			if (mid+1 < nums.length && nums[mid] == nums[mid+1]) {
				if (partitionEven == true) {
					i = mid+2;
				} else {
					j = mid-1;
				}
			} else if (mid - 1 >= 0 && nums[mid] == nums[mid-1]) {
				if (partitionEven == true) {
					j = mid-2;
				} else {
					i = mid+1;
				}
			} else {
				return nums[mid];
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		String[] sArr = s.split(" ");

		int[] nums = new int[sArr.length];

		for (int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(sArr[i]);
		}

		int ans = nonDuplicate(nums);
		System.out.println(ans);
	}
}
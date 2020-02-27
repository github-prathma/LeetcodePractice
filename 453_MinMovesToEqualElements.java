import java.util.*;
import java.io.*;

class MinMoves {

	public static int minMoves(int[] nums) {
		Arrays.sort(nums);

		int count = 0;

		for (int i = nums.length-1; i>=0; i--) {
			count = count + (nums[i] - nums[0]);
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inp = br.readLine();
		String[] sArr = inp.split(" ");
		int[] nums = new int[sArr.length];

		for (int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(sArr[i]);
		}

		int ans = minMoves(nums);	
		System.out.println(ans);
		return;
	}
}
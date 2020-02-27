import java.util.*;
import java.io.*;

class MinMovesDP {

	public static int minMoves(int[] nums) {
		Arrays.sort(nums);

		int moves = 0;

		for (int i=1; i<nums.length; i++) {
			nums[i] = nums[i] + moves;
			int diff = nums[i] - nums[i-1];
			moves += diff;
		}

		return moves;
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
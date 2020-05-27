import java.util.*;
import java.io.*;

class JumpGameGreedy {

	public static boolean canJump(int[] nums) {

		int maxJump = 0;

		for (int i=0; i<nums.length; i++) {
			if (i > maxJump || maxJump >= nums.length-1) {
				break;
			}
			maxJump = Math.max(maxJump, i+nums[i]);
		}
		return maxJump >= nums.length-1;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter size of an array");
		int n = sc.nextInt();

		int[] nums = new int[n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}

		boolean ans = canJump(nums);
		System.out.println(ans);

	}
}
import java.util.*;
import java.io.*;


//recursion backtracking (2^n tle)

class JumpGame {

	public static boolean possible(int[] nums, int index) {
        if (index == nums.length-1) {
            return true;
        }
        
        int maxJump = Integer.MIN_VALUE;
        if (index + nums[index] < nums.length-1) {
            maxJump = index + nums[index];
        } else {
            maxJump = nums.length-1;
        }
        for (int i=index+1; i<=maxJump; i++) {
            if (possible(nums, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canJump(int[] nums) {
        return possible(nums, 0);
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
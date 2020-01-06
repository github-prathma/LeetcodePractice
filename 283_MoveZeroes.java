import java.util.*;
import java.io.*;

class MoveZeroes {

	public static int[] moveZeroesToRight(int[] nums) {
		int x = 0;
		int y = 1;

		while (x < nums.length && y < nums.length) {

			if (nums[x] != 0 && nums[y] == 0) {
				x++;
				y++;
			} else if (nums[x] == 0 && nums[y] == 0) {
				y++;
			} else if (nums[x] == 0 && nums[y] != 0) {
				nums[x] = nums[y];
				nums[y] = 0;
				x++;
			} else if (nums[x] != 0 && nums[y] != 0) {
                            
                x++; 
                y++;
            }
		}
		return nums;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int[] ans = moveZeroesToRight(nums);

		for (int x : ans) {
			System.out.print(x + " "); 
		}
		System.out.println();
	}
}
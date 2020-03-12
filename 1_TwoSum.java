import java.util.*;
import java.io.*;

class TwoSum {

	public static int[] twosum(int[] nums, int target) {
		HashMap<Integer, Integer> mapIndexNum = new HashMap<>();
		int[] ans = new int[2];

		for (int i=0; i<nums.length; i++) {
			int x = target - nums[i];

			if (mapIndexNum.containsKey(x)) {
				ans[0] = mapIndexNum.get(x);
				ans[1] = i;
				return ans;
			}

			mapIndexNum.put(nums[i], i);
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();

		String[] lineInp = line.split(" ");

		int[] nums = new int[lineInp.length];

		for (int i=0; i<lineInp.length; i++) {
			nums[i] = Integer.parseInt(lineInp[i]);
		}

		int target = Integer.parseInt(br.readLine());

		int[] ans = twosum(nums, target);

		for (int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+ " " );
		}
		System.out.println();
	}	
}
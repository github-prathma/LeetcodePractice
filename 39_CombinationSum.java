import java.io.*;
import java.util.*;

class Combinations {

	public static void allCombinations (List<List<Integer>> result, List<Integer> nums, List<Integer> perm, int target, int index) {
		if (target == 0) {
			// System.out.println(perm);
			result.add(new ArrayList<>(perm));
			return;
		} else {
			for (int i=index; i<nums.size(); ++i) {
				if (nums.get(i) > target) {
					return;
				}
				perm.add(nums.get(i));
				// System.out.println(perm);

				allCombinations(result, nums, perm, target-nums.get(i), i);
				perm.remove(perm.size()-1);

			}
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> numsL = new ArrayList<>();

		List<Integer> perm = new ArrayList<>();

		for (int x : candidates) {
			Integer p = Integer.valueOf(x);
			numsL.add(p);
		}
		Collections.sort(numsL);

		allCombinations(result, numsL, perm, target, 0);

		return result;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		System.out.println("Enter target :");
		int target = Integer.parseInt(br.readLine());

		List<List<Integer>> ans = combinationSum(nums, target);

		System.out.println(ans);
	}

}
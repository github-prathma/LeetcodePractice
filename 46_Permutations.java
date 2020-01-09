import java.util.*;
import java.io.*;

class Permutations {
	
	public static void allPermutations (List<List<Integer>> result, List<Integer> nums, int pos, List<Integer> perm) {

		if (perm.size() == nums.size()) {
			System.out.println(perm);
			result.add(new ArrayList<>(perm));
			// System.out.println(result);

			return;
		} else {
			// System.out.println(cand);
			for (int i=0; i<nums.size(); ++i) {
				if (perm.contains(nums.get(i))) {
					continue;
				}
				// System.out.println(perm);
				perm.add(nums.get(i));
				// System.out.println(perm);
				allPermutations(result, nums, pos+1, perm);
				perm.remove(perm.size()-1);
			}

		}
	}
	public static List<List<Integer>> permutes(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> numsL = new ArrayList<>();

		List<Integer> perm = new ArrayList<>();

		for (int x : nums) {
			Integer p = Integer.valueOf(x);
			numsL.add(p);
		}

		allPermutations (result, numsL, 0, perm);
				// System.out.println(result);

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

		List<List<Integer>> ans = permutes(nums);

		System.out.println(ans);
	}
}
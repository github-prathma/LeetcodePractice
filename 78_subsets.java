import java.util.*;
import java.io.*;

class Subsets {

	public static void allSubsets(List<List<Integer>> result, List<Integer> nums, List<Integer> perm, int pos, int k) {
		if (perm.size() == k) {
			System.out.println(perm);
			result.add(new ArrayList<>(perm));
			return;
		} else {
			for (int i=pos; i<nums.size(); i++) {
				perm.add(nums.get(i));
				allSubsets(result, nums, perm, i+1, k);
				perm.remove(perm.size()-1);
			}
		}
	}
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> numsL = new ArrayList<>();
		for (int i=0; i<nums.length; i++) {
			Integer x = Integer.valueOf(nums[i]);
			numsL.add(x);
		}

		for (int k=0; k <= nums.length; k++) {
			allSubsets(result, numsL, new ArrayList<>(), 0, k);
		}
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

		List<List<Integer>> ans = subsets(nums);

		System.out.println(ans);
	}
}
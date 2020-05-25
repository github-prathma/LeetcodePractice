import java.io.*;
import java.util.*;

class CombSum2 {

	public static void allPossibleSums(int[] candidates, int target, List<Integer> comb, int index, Set<List<Integer>> result) {

		if (target < 0 || index > candidates.length) {
			return;
		}
		if (target == 0) {
			System.out.println(comb);
			List<Integer> copy = new ArrayList<>(); // directly wont add in list<list> hence make copy
			copy.addAll(comb);
			result.add(copy);
			// System.out.println(result);
			return;
		}

		for (int i=index; i < candidates.length; i++) {
				comb.add(candidates[i]);
				target = target-candidates[i];

				allPossibleSums(candidates, target, comb, i+1, result);
				
				comb.remove(comb.size()-1);
				target = target+candidates[i];
				
		}

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> uniqueCombs = new HashSet<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        allPossibleSums(candidates, target, comb, 0, uniqueCombs);

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> r : uniqueCombs) {
        	result.add(r);
        }
        return result;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter size of an array");
		int n = sc.nextInt();

		System.out.println("Enter target:");
		int target = sc.nextInt();

		int[] nums = new int[n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		List<List<Integer>> ans = combinationSum2(nums, target);
		System.out.println(ans);

	}
}
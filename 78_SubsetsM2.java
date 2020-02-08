import java.util.*;
import java.io.*;

class Subsets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		result.add(new ArrayList<>());
		int k = 1;
		for (int i=0; i<nums.length; i++) {
			List<Integer> nL = new ArrayList<>();
			for (int j=i; j<nums.length; j++) {
				nL.add(nums[j]);
				if (nL.size() == k) 
				result.add(new ArrayList<>(nL));
			}
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
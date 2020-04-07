import java.util.*;
import java.io.*;

class TargetArray {
 
	public static int[] createTargetArray(int[] nums, int[] index) {

		List<Integer> res = new ArrayList<>();

		for (int i=0; i<nums.length; i++) {
			res.add(index[i], nums[i]);
		}
		return res.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] sArr = s.split(" ");

		int[] nums = new int[sArr.length];

		for (int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(sArr[i]);
		}

		String s1 = br.readLine();
		String[] sArr1 = s1.split(" ");

		int[] index = new int[sArr1.length];

		for (int i=0; i<index.length; i++) {
			index[i] = Integer.parseInt(sArr1[i]);
		}

		int[] ans = createTargetArray(nums, index);
		for (int x : ans) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
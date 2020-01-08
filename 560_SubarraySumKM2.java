import java.util.*;
import java.io.*;

// 1,2,3,4,5 , cumulative till jth index , sum[j]
// if sum[j]-sum[i] = k .. then from i to j there is k sum subarray
// hence sum[i] = sum[j]-k;.. this if for current sum if sum-k is already encountered then there is k sum array
class SubarraySumM2 {

	public static int countOfSubarrays(int[] nums, int k) {
		int count = 0;

		HashMap<Integer, Integer> mp = new HashMap<>();
		mp.put(0,1);
		int sum = 0;
		for (int i=0; i<nums.length; i++) {
			sum = sum+nums[i];
			if (mp.containsKey(sum-k)) {
				count+=mp.get(sum-k);
			}
			mp.put(sum, mp.getOrDefault(sum, 0)+1);
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("k sum : ");
		int k = Integer.parseInt(br.readLine());

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int ans = countOfSubarrays(nums, k);

		System.out.println(ans);
	}
}
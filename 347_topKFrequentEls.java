import java.util.*;
import java.io.*;

class TopKFrequent {

	public static List<Integer> topk(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();

		HashMap<Integer, Integer> frequencynums = new HashMap<>();

		TreeMap<Integer, List<Integer>> numsWithFreqkey = new TreeMap<>(Collections.reverseOrder());

		for (int x : nums) {
			frequencynums.put(x, frequencynums.getOrDefault(x, 0)+1);
		}

		for (Map.Entry<Integer, Integer> entry : frequencynums.entrySet()) {
			Integer key = entry.getValue();
			if (numsWithFreqkey.containsKey(key)) {
				numsWithFreqkey.get(key).add(entry.getKey());
			} else {
				List<Integer> l = new ArrayList<>();
				l.add(entry.getKey());
				numsWithFreqkey.put(key, l);
			}
		}

		for (Map.Entry<Integer, List<Integer> > entry : numsWithFreqkey.entrySet()) {
				for (Integer x : entry.getValue()) {
					res.add(x);
					k--;
					if (k == 0) {
						break;
					}
				}
				if (k==0) {
					break;
				}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] sArr = s.split(" ");

		int[] nums = new int[sArr.length];

		for (int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(sArr[i]);
		}

		int k = Integer.parseInt(br.readLine());

		List<Integer> ans = topk(nums, k);
		System.out.println(ans);
	}
}
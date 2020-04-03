import java.util.*;
import java.io.*;

class NumbersSmaller {

 	public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];

        for (int i=0; i<nums.length; i++) {
        	freq[nums[i]]++;
        }

        int totalCount = 0;

        for (int i=0; i<freq.length; i++) {
        	if (freq[i] > 0) {
        		int val = freq[i];
        		freq[i] = totalCount;
        		totalCount = totalCount+val;
        	}
        }

        int[] ans = new int[nums.length];

        for (int i=0; i<ans.length; i++) {
        	ans[i] = freq[nums[i]];
        }
        return ans;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] sArr = s.split(" ");

		int[] nums = new int[sArr.length];

		for (int i = 0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(sArr[i]);
		}


		int[] ans = smallerNumbersThanCurrent(nums);
		for (int x : ans) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}

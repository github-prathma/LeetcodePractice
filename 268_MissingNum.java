import java.util.*;
import java.io.*;


class MissingNumber {

	public static int missingNumber(int[] nums) {
		int len = nums.length;
        
        int oSum = (len * (len + 1))/2;
        
        int gSum = 0;
        
        for (int i=0; i<nums.length; i++) {
            gSum += nums[i];
        }
        
        return oSum - gSum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inp = br.readLine();
		String[] sArr = inp.split(" ");
		int[] nums = new int[sArr.length];

		for (int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(sArr[i]);
		}

		int ans = missingNumber(nums);	
		System.out.println(ans);
		return;
	}
}
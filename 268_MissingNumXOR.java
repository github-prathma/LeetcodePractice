import java.util.*;
import java.io.*;

/*
Index	0	1	2	3
Value	0	1	3	4
​	
=4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
=(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
=0∧0∧0∧0∧2
=2
​	
*/

class MissingNumberXOR {

	public static int missingNumber(int[] nums) {
		int len = nums.length;

		int missingNumber = len;

		for (int i=0; i<nums.length; i++) {
			missingNumber ^= (i ^ nums[i]);
		}
        
        return missingNumber;
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
import java.util.*;
import java.io.*;

class SubarraySum {

	public static int maxProduct(int[] nums) {
		int maxProd = Integer.MIN_VALUE;
        
        for (int i=0; i<nums.length; i++) {
            int product = 1;
            for (int s = i; s<nums.length; s++) {
                product *= nums[s];
                maxProd = Math.max(maxProd, product);
            }
        }
        return maxProd;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int ans = maxProduct(nums);

		System.out.println(ans);
	}
}
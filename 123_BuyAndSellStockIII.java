import java.util.*;
import java.io.*;

class BuyAndSellIII {

	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int[] ltor = new int[prices.length];
		int currMin = prices[0];
		ltor[0] = 0;

		for (int i=1; i<prices.length; i++) {
			ltor[i] = Math.max(ltor[i-1], prices[i]-currMin);
			currMin = Math.min(currMin, prices[i]);
		}

		int[] rtol = new int[prices.length];
		int currMax = prices[prices.length-1];
		rtol[prices.length-1] = 0;

		for (int i=prices.length-2; i>=0; i--) {
			rtol[i] = Math.max(rtol[i+1], currMax-prices[i]);
			currMax = Math.max(currMax, prices[i]);
		}

		int ans = Integer.MIN_VALUE;
		for (int i=0; i<prices.length; i++) {
			ans = Math.max(ans, ltor[i]+rtol[i]);
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

		int ans = maxProfit(nums);
		System.out.println(ans);
	}
}
import java.util.*;
import java.io.*;

class LargestRect {

	public static int largestRectangleArea(int[] nums) {
		if (heights.length == 0) {
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        
        for (int i=0; i<heights.length; ++i) {
            int minHeight = Integer.MAX_VALUE;
            for (int j=i; j<heights.length; ++j) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight*(j-i+1));
            }
        }
        
        return maxArea;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s - br.readLine();
		String[] sArr = s.split(" ");

		int[] nums = new int[sArr.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(sArr[i]);
		}

		int ans = largestRectangleArea();
		System.out.println(ans);
	}
}
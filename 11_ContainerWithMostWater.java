import java.util.*;
import java.io.*;

class ContainerWithMaxWater {

	public static int largestContainer(int[] heights) {

		int maxArea = 0;
		int i = 0;
		int j = heights.length-1;

		while (i < j) {
			int area = Math.min(heights[i], heights[j]) * (j-i);

			maxArea = Math.max(maxArea, area);

			if (heights[i] < heights[j]) {
				i++;
			} else {
				j--;
			}
		}

		return maxArea;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int ans = largestContainer(nums);

		System.out.println(ans);
	}

}
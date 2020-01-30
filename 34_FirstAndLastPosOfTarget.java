import java.util.*;
import java.io.*;

class FirstLastPos {

	public static int[] positions(int[] nums, int target) {
		int l=0;
        int h = nums.length-1;
        
        int[] ans = new int[2];
        
        while (l<=h) {
            int mid = (l+h)/2;
            
            if (nums[mid] == target) {
                int i = mid;
                int j = mid;
                while (i>=0 && nums[i] == target) {
                    i--;
                }
                while (j<nums.length && nums[j] == target) {
                    j++;
                }
                ans[0] = i+1;
                ans[1] = j-1;
                return ans;
            } else if (nums[mid] < target) {
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        
        ans[0] = -1;
        ans[1] = -1;
        return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] strs = s.split(" ");

		int[] nums = new int[strs.length];

		for (int i = 0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}

		int target = Integer.parseInt(br.readLine());

		int[] ans = positions(nums, target);
		for (int x : ans) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
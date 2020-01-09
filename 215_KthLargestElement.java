import java.util.*;
import java.io.*;

class KthLargest {

	public static int kthLargestEl(int[] nums, int k) {
		Arrays.sort(nums);

		int l = 0;
        int r = nums.length-1;
        
        while (l <= r) {
            int mid = (l+r)/2;
            
            if (mid == nums.length-k) {
                return nums[mid];
            } else if (mid > nums.length-k) {
                r = mid-1; 
            } else {
                l = mid+1;
            }
        }
        
        return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}
		System.out.println("kth largest element k: ");
		int k = Integer.parseInt(br.readLine());

		int ans = kthLargestEl(nums, k);

		System.out.println(ans);
	}
}
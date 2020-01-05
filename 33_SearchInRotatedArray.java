import java.io.*;
import java.util.*;

class SearchRotatedArray {

	public static int rotateIndex(int[] nums) {
		int l = 0;
		int r = nums.length-1;
    
        if (nums[l] < nums[r]) {
            return 0;
        }
		while (l<=r) {
			int mid = (l+r)/2;

		    if (nums[mid] > nums[mid+1]) {
				return mid+1;
			} else {
                if (nums[mid] < nums[l]) {
				    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
		}
		return 0;
	}

	public static int targetSearch(int[] nums, int target, int l, int r) {
		while (l <= r) {
			int mid = (l+r)/2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				l = mid+1;
			} else {
				r = mid-1;
			}
		}
		return -1;
	}

 	public static int search(int[] nums, int target) {
    	if (nums.length == 0) {
        	return -1;
        } 
        if (nums.length == 1) {
        	if (nums[0] == target) {
        		return 0;
        	} else {
        		return -1;
        	}
        }

        int smallestInd = rotateIndex(nums);
    
        // System.out.println(smallestInd);
		if (nums[smallestInd] == target) {
			return smallestInd;
		}

		if (smallestInd == 0) {
			return targetSearch(nums, target, 0, nums.length-1);
		}

		if (nums[0] > target) {
			return targetSearch(nums, target, smallestInd, nums.length-1);
		}
		return targetSearch(nums, target, 0, smallestInd);
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int target = Integer.parseInt(br.readLine());

		int ans = search(nums, target);
		System.out.println(ans);

	}
}
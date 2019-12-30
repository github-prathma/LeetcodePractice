import java.util.*;
import java.io.*;

class PeakIndex {

	public static int peakIndexInMountain(int[] A) {
		int low = 0;
		int high = A.length-1;

		while (low <= high) {
			int mid = (low + high)/2;

			if (mid == 0 || mid == A.length - 1) {
				return -1;
			}
			if (A[mid] > A[mid+1] && A[mid] > A[mid-1]) {
				return mid;
			} else if (A[mid] < A[mid+1]) {
				low = mid+1;
			} else if (A[mid] < A[mid-1]) {
				high = mid-1;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputNums = input.split(" ");
        int[] nums = new int[inputNums.length];

        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(inputNums[i]);
        }

        int ans = peakIndexInMountain(nums);
        System.out.println(ans);
    }
 
}
import java.util.*;
import java.io.*;

class FixedPoint {
    public static int fixedP(int[] A) {
        int start = 0; 
        int end = A.length;

        if (A.length == 1) {
            if (A[0] == 0) {
                return 0;
            }
        }
        while (start < end-1) {
            int mid = (start+end)/2;

            if (A[mid] >= mid) {
                end = mid;
            } else if (A[mid] < mid) {
                start = mid;
            } 
        }
        if (A[start] == start) {
            return A[start];
        } else if (A[end] == end) {
            return A[end];
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        String[] allNums = inp.split(" ");

        int[] nums = new int[allNums.length];

        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(allNums[i]);
        }

        int ans = fixedP(nums);
        System.out.println(ans);

    }
}
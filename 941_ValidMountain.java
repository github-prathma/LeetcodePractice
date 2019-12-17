import java.util.*;
import java.io.*;

class ValidMountain {

    public static boolean validMountainArray(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int i=0;
        while (i < nums.length-1 && nums[i] < nums[i+1]) {
            ++i;
        }
        if (i == 0) {
            return false;
        } else if (i == nums.length-1) {
            if (nums[i] < nums[i-1]) {
                return true;
            } else {
                return false;
            }
        } else {
            ++i;
            while (i < nums.length && nums[i] < nums[i-1]) {
                ++i;
            }
            if (i == nums.length) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line  = br.readLine();
        String[] splitl = line.split(" ");

        int[] nums = new int[splitl.length];
        for (int i=0; i<nums.length; ++i) {
            nums[i] = Integer.parseInt(splitl[i]);
        }

        boolean ans = validMountainArray(nums);
        System.out.println(ans);
    }
}
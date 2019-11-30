import java.io.*;
import java.util.*;

class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int res = 0;
        
        for (int i=0; i<nums.length-2; i++) {
            int l=i+1;
            int r=nums.length-1;
            while (l<r) { 
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum-target) < closestSum) {
                    closestSum = Math.abs(sum-target);
                    res = sum;
                }
                
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                }
            }
        }

        return res;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] input = line.split(" ");
        int[] nums = new int[input.length];

        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        String line2 = br.readLine();
        int target = Integer.parseInt(line2);

        int ans = threeSumClosest(nums, target);
        System.out.println(ans);
    }
}
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;

//O(nlogn)
class TwoSumsLessThanK {

    public int twoSumsLessThanK(int[] nums, int K) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        int max = -1;
        while (start < end) {
            if (nums[start] + nums[end] > K || nums[start]+nums[end] == K) {
                end--;
            } else {
                if (nums[start]+nums[end] > max) {
                    max = nums[start]+nums[end];
                }
                start++;
            }
        }
        return max;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();

        String[] input = line1.trim().split(" ");
        int[] nums = new int[input.length];

        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        String line2 = br.readLine();
        int K = Integer.parseInt(line2);

        TwoSumsLessThanK twoSum = new TwoSumsLessThanK();
        int ans = twoSum.twoSumsLessThanK(nums, K);
        System.out.println("Max sum less than K = " + ans);
    }
}
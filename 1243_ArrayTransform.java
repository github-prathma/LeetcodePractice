import java.util.*;
import java.io.*;

class ArrayTransform {
    public static List<Integer> transformedArr(int[] nums) {
        boolean isChange = true;

        while (isChange) {
            isChange = false;
            int p = nums[0], t=0;
            for (int i=1; i<nums.length-1; i++) {
                t = nums[i];
                // System.out.println(p);
                if (nums[i] > p && nums[i] > nums[i+1]) {
                    nums[i] -= 1;
                    isChange = true;
                } else if (nums[i] < p && nums[i] < nums[i+1]) {
                    // System.out.println("enter");
                    nums[i] += 1;
                    // System.out.println(nums[i]);
                    isChange = true;
                }
                p = t;
            }
        }
        // for (int i=0; i<nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println();

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            result.add(nums[i]);
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputNums = input.split(" ");
        int[] nums = new int[inputNums.length];

        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(inputNums[i]);
        }

        List<Integer> ans = transformedArr(nums);
        for (int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
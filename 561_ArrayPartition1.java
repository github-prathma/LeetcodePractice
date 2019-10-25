import java.util.*;
import java.io.*;

class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i=0; i<nums.length-1; i+=2) {
            sum = sum + Math.min(nums[i], nums[i+1]);
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inpStr = br.readLine();
        String[] inputStrings = inpStr.split(" ");
        int[] nums = new int[inputStrings.length];

        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(inputStrings[i]);
        }
        ArrayPartition1 ap = new ArrayPartition1();
        int ans = ap.arrayPairSum(nums);
        System.out.println(ans);
    }
}
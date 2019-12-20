import java.util.*;
import java.io.*;

class MaxApples {
    public static int maxNumApples(int[] nums) {
        Arrays.sort(nums);

        int sum=0, count=0;
        for (int i=0; i<nums.length; ++i) {
            sum += nums[i];
            if (sum <= 5000) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l = br.readLine();
        String[] l1 = l.split(" ");

        int[] nums = new int[l1.length];

        for (int i=0; i<nums.length; ++i) {
            nums[i] = Integer.parseInt(l1[i]);
        }

        int ans = maxNumApples(nums);
        System.out.println(ans);
    }
}
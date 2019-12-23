import java.util.*;
import java.io.*;

class CountNums {

    public static int countNumWithEvenDigits(int[] nums) {

        int countNums = 0;
        for (int i=0; i<nums.length; ++i) {
            int x = nums[i];
            int c = 0;
            while (x != 0) {
                x = x/10;
                c++;
            }
            if (c % 2 == 0) {
                countNums++;
            }
        }
        return countNums;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] nums = line.split(" ");

        int[] num = new int[nums.length];

        for (int i=0; i<num.length; ++i) {
            num[i] = Integer.parseInt(nums[i]);
        }
        int ans = countNumWithEvenDigits(num);
        System.out.println(ans);
    }
}
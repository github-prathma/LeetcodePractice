import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;

//using sorting , runtime 3ms, O(nlogn)
class ContainDuplicatesSort {

    public boolean checkIfDuplicatesPresent(int[] nums) {
        Arrays.sort(nums);

        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String[] g = line1.trim().split(" ");
        int[] inputArray = new int[g.length];

        for (int i=0; i<g.length; i++) {
            inputArray[i] = Integer.parseInt(g[i]);
        }

        ContainDuplicatesSort cd = new ContainDuplicatesSort();
        boolean ans = cd.checkIfDuplicatesPresent(inputArray);
        System.out.println(ans);
    }
}
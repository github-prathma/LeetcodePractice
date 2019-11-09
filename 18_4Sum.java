import java.io.*;
import java.util.*;

class FourSum {
    public static List<List<Integer>> tuples4Sum(int[] nums, int target) {
        // System.out.println("enftgkg");
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);

        for (int i=0; i<nums.length-3; i++) {
            for (int j=i+1; j<nums.length-2; j++) {
                int l = j+1;
                int r = nums.length-1;
                while (l<r) {
                    int s = nums[i]+nums[j]+nums[l]+nums[r];

                    if (s > target) {
                        r--;
                    } else if (s < target) {
                        l++;
                    } else {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(nums[i]);
                        tuple.add(nums[j]);
                        tuple.add(nums[l]);
                        tuple.add(nums[r]);
                        if (!resultList.contains(tuple)) {
                            resultList.add(tuple);
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return resultList;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] array = line.split(" ");
        int[] nums = new int[array.length];

        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }

        String line2 = br.readLine();
        int target = Integer.parseInt(line2);

        List<List<Integer>> ans = tuples4Sum(nums, target);
        for (int i=0; i<ans.size(); i++) {
            for (int j=0; j<ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    } 
}
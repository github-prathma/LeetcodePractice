import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;

//using hashmap
class ContainDuplicates {

    public boolean checkIfDuplicatesPresent(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i])+1);
            } else {
                mp.put(nums[i], 1);
            }
        }

        Set<Integer> keys = mp.keySet();
        int[] keyEntries = new int[keys.size()];

        int index = 0;
        for (Integer element: keys) {
            keyEntries[index++] = element.intValue();
        }

        for (int i=0; i<keyEntries.length; i++) {
            if (mp.get(keyEntries[i]) > 1) {
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

        ContainDuplicates cd = new ContainDuplicates();
        boolean ans = cd.checkIfDuplicatesPresent(inputArray);
        System.out.println(ans);
    }
}
import java.util.*;
import java.io.*;

class LastStoneWeight {
    public static int lastStoneW(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 1) {
            int s1 = pq.remove();
            int s2 = pq.remove();

            if (Math.abs(s1-s2) != 0) {
                pq.add(Math.abs(s1-s2));
            }
        }
        if (pq.size() == 1) {
            return pq.remove();
        }
        return 0;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l = br.readLine();
        String[] l1 = l.split(" ");

        int[] nums = new int[l1.length];

        for (int i=0; i<nums.length; ++i) {
            nums[i] = Integer.parseInt(l1[i]);
        }

        int ans = lastStoneW(nums);
        System.out.println(ans);
    }
}
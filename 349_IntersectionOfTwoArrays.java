import java.util.*;
import java.io.*;

class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st = new HashSet<>();
        for (int i=0; i<nums1.length; ++i) {
            st.add(nums1[i]);
        }

        Set<Integer> ans = new HashSet<>();
        for (int i=0; i<nums2.length; ++i) {
            if (st.contains(nums2[i])) {
                ans.add(nums2[i]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String n1 = br.readLine();
        String[] n1s = n1.split(" ");
        int[] nums1 = new int[n1s.length];

        for (int i=0; i<n1s.length; ++i) {
            nums1[i] = Integer.parseInt(n1s[i]);
        }

        String n2 = br.readLine();
        String[] n2s = n2.split(" ");
        int[] nums2 = new int[n2s.length];
        for (int i=0; i<n2s.length; ++i) {
            nums2[i] = Integer.parseInt(n2s[i]);
        }

        int[] ans = intersection(nums1, nums2);
        for (int i=0; i<ans.length; ++i) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
import java.util.*;
import java.io.*;

class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = 0;
        int l2 = 0;

        List<Integer> intersect = new ArrayList<>();
        while (l1 < nums1.length && l2 < nums2.length) {
          // System.out.println("ind === " + l1 + " ,, " + l2);

            int numl1 = nums1[l1];
            int numl2 = nums2[l2];
            // System.out.println("ttt=== " + numl1 + " === " + numl2);
            if (numl1 == numl2) {
                intersect.add(numl1);
                while (l1 < nums1.length && numl1 == nums1[l1]) {
                    l1++;
                }
                while (l2 < nums2.length && numl2 == nums2[l2]) {
                    l2++;
                }
                continue;
            }

            if (numl1 < numl2) {
                while (l1 < nums1.length && numl1 == nums1[l1]){
                    l1++;
                }
            } else {
               while (l2 < nums2.length && numl2 == nums2[l2]) {
                    l2++;
                } 
            }
            
        }

        return intersect.stream().mapToInt(Integer::intValue).toArray();
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
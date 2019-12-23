import java.util.*;

import jdk.internal.jline.internal.InputStreamReader;

import java.io.*;

class AnagramMapping {

    public static int[] mapping(int[] A, int[] B) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i=0; i<B.length; ++i) {
            mp.put(B[i], i);
        }

        for (int i=0; i<A.length; ++i) {
            A[i] = mp.get(A[i]);
        }
        return A;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1 = br.readLine();
        String[] l1Nums = l1.split(" ");
        int[] nums1 = new int[l1Nums.length];

        for (int i=0; i<nums1.length; ++i) {
            nums1[i] = Integer.parseInt(l1Nums[i]);
        }

        String l2 = br.readLine();
        String[] l2Nums = l1.split(" ");
        int[] nums2 = new int[l2Nums.length];

        for (int i=0; i<nums2.length; ++i) {
            nums2[i] = Integer.parseInt(l2Nums[i]);
        }

        int[] ans = mapping(nums1, nums2);
        for (int i=0; i<ans.length; ++i) {
            System.out.println(ans[i] + " ");
        }
        System.out.println();
    }
}
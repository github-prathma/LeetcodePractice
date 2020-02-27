import java.util.*;
import java.io.*;

class Intersection2PointerMethod {

	public static int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0) {
            return nums1;
        }
        if (nums2.length == 0) {
            return nums2;
        }
		int l1 = nums1.length;
		int l2 = nums2.length;
		int i=0; 
		int j=0;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> intersectionList = new ArrayList<>();

		if (l1 < l2) {
			while (j < l2 && nums2[j] < nums1[i]) {
				j++;
			}	
		} else {
			while (i < l1 && nums1[i] < nums2[j]) {
				i++;
			}
		}

		while (i < l1 && j < l2) {
			if (nums1[i] == nums2[j]) {
				intersectionList.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}

		return intersectionList.stream().mapToInt(Integer :: intValue).toArray();
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String[] s1Arr = s1.split(" ");
		int[] nums1 = new int[s1Arr.length];

		for (int i=0; i<nums1.length; i++) {
			nums1[i] = Integer.parseInt(s1Arr[i]);
		}

		String s2 = br.readLine();
		String[] s2Arr = s2.split(" ");
		int[] nums2 = new int[s2Arr.length];

		for (int i=0; i<nums2.length; i++) {
			nums2[i] = Integer.parseInt(s2Arr[i]);
		}

		int[] ans = intersect(nums1, nums2);
		for (int i=0; i<ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}
}
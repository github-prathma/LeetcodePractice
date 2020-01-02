import java.util.*;
import java.io.*;

class SquaresOfArray {

	public static int[] squares(int[] A) {

		Integer[] nums = new Integer[A.length];

		for (int i = 0; i < A.length; ++i) {
			Integer x = Integer.valueOf(A[i]);
			nums[i] = x;
		}
	
		Arrays.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if (a < 0) {
					a = a*-1;
				}
				if (b < 0) {
					b = b*-1;
				}
				return a-b;
			}
		});

	
		int[] res = new int[nums.length];

		for (int i = 0; i < nums.length; ++i) {
			res[i] = nums[i].intValue() * nums[i].intValue();
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int[] ans = squares(nums);

		for (int x : ans) {
			System.out.print(x + " "); 
		}
		System.out.println();
	}
}
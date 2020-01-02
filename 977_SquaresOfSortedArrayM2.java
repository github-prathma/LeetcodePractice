import java.io.*;
import java.util.*;

class SquaresArray {

	public static int[] reverseArray(int[] A) {
		for(int i = 0; i < A.length / 2; i++) {
    		int temp = A[i];
    		A[i] = A[A.length - i - 1];
    		A[A.length - i - 1] = temp;
		}
		return A;
	}

	public static int[] squaresOfArray(int[] A) {

		int i = 0; 
		int j = A.length-1;

		int[] res = new int[A.length];

		int k = 0;
		while ((i < A.length && A[i] < 0) && (j >= 0 && A[j]>0)) {
			if (A[i]*A[i] >= A[j]*A[j]) {
				res[k++] = A[i]*A[i];
				i++;
			} else {
				res[k++] = A[j]*A[j];
				j--;
			}
		}

		while (j>=0 && A[j] > 0) {
			res[k++] = A[j]*A[j];
			j--;
		}

		while (i < A.length && A[i] < 0) {
			res[k++] = A[i]*A[i];
			i++;
		}

		for (int x : res) {
			System.out.println(x);
		}

		int[] ans = reverseArray(res);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] str = s.split(" ");

		int[] nums = new int[str.length];

		for (int i=0; i<nums.length; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}

		int[] ans = squaresOfArray(nums);

		for (int x : ans) {
			System.out.print(x + " "); 
		}
		System.out.println();
	}
}
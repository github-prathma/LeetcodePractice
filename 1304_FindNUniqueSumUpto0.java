import java.util.*;
import java.io.*;

class FindNUniqueNums {

	public static int[] uniqueNums(int n) {

		int[] ans = new int[n];


		if (n%2 == 0) {
			int x = 0;
			int k = 0;
			for (int i=1; i<=n/2; i++) {
				x = x-1;
				ans[k++] = x;
			}

			x = 0;
			for (int i=1; i<=n/2; i++) {
				x = x+1;
				ans[k++] = x;
			}
		} else {
			int x = 0;
			int k = 0;
			for (int i=1; i<=n/2; i++) {
				x = x-1;
				ans[k++] = x;
			}
			ans[k++] = 0;
			x = 0;
			for (int i=1; i<=n/2; i++) {
				x = x+1;
				ans[k++] = x;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ans = uniqueNums(n);

		for (int x : ans) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
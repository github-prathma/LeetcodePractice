import java.util.*;
import java.io.*;

class EditDistance {

	public static int minDistance(String w1, String w2) {

		int n = w1.length();
		int m = w2.length();

		int[][] dp = new int[n+1][m+1];

		for (int i=0; i<=n; i++) {
			dp[i][0] = i;
		}

		for (int j=0; j<=m; j++) {
			dp[0][j] = j;
		}

		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (w1.charAt(i-1) == w2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
				}
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String w1 = sc.nextLine();

		String w2 = sc.nextLine();

		int ans = minDistance(w1, w2);

		System.out.println(ans);

	}
}
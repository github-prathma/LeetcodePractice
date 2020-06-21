import java.util.*;
import java.io.*;

class DistinctSubsequences {

	public static int numDistinct(String s, String t) {

		int n = s.length();
		int m = t.length();

		int[][] dp = new int[n+1][m+1];

		for (int j=0; j<m; j++) {
			dp[n][j] = 0;
		}


		for (int i=0; i<=n; i++) {
			dp[i][m] = 1;
		}

		for (int i=n-1; i>=0; i--) {
			for (int j=m-1; j>=0; j--) {
				dp[i][j] = dp[i+1][j];

				if (s.charAt(i) == t.charAt(j)) {
					dp[i][j] += dp[i+1][j+1];
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		String s = br.readLine();
		
		String t = br.readLine();

		int ans = numDistinct(s, t);

		System.out.println(ans);
	}
}
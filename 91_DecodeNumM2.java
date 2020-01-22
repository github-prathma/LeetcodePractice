import java.io.*;
import java.util.*;

class DecodeWays {

	public static int decodeNumWays (String s) {
		int[] dp = new int[s.length()+1];
		dp[0] = 1;

		for (int i=1; i<=s.length(); i++) {
			if (s.charAt(i-1) != '0') {
				dp[i] += dp[i-1];
			}
			if (i>=2) {
				String str = Character.toString(s.charAt(i-2))+Character.toString(s.charAt(i-1));
				System.out.println(str);
				if (Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26) {
					dp[i] += dp[i-2];
				}
			}
		}
		return dp[s.length()];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		int x = decodeNumWays(s);
		System.out.println(x);
	}

}
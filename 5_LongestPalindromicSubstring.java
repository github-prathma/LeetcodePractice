import java.io.*;
import java.util.*;

class LongestPalindrome {

	public static String longestPal(String s) {

		 if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        boolean[][] palMatrix = new boolean[s.length()][s.length()];

		int maxLen = 1;
		int start = 0;

		for (int i=0; i<s.length(); ++i) {
			palMatrix[i][i] = true;
		}

		for (int i=0; i<s.length()-1; ++i) {
			if (s.charAt(i) == s.charAt(i+1)) {
				palMatrix[i][i+1] = true;
				maxLen = 2;
				start = i;
			}
		}

		for (int len = 3; len <= s.length(); ++len) {
			for (int i=0; i<s.length()-len+1; ++i) {
				int j = i+len-1;
				if (s.charAt(j) == s.charAt(i) && palMatrix[i+1][j-1] == true) {
					palMatrix[i][j] = true;
					start = i;
					maxLen = len;
				}
			}
		}
    
        // System.out.println(maxLen + " " + start);
		return s.substring(start, Math.min(start + maxLen, s.length()));

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

		String s = br.readLine();

		String ans = longestPal(s);
		System.out.println(ans);

	}
}
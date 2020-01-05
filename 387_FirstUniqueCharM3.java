import java.util.*;
import java.io.*;

class FirstUnique {

	public static int firstUniqueChar(String s) {
		if (s.length() == 0) {
            return -1;
        }
	    int[] chars = new int[26];
        for (int i=0; i<26; ++i) {
            chars[i] = Integer.MAX_VALUE;
        }
        
        for (int i=0; i<s.length(); ++i) {
            if (chars[s.charAt(i) - 'a'] == Integer.MAX_VALUE) {
                chars[s.charAt(i) - 'a'] = i;
            } else {
                chars[s.charAt(i) - 'a'] = s.length()+1;
            }
        }
        
        int minInd = Integer.MAX_VALUE;
        
        for (int x : chars) {
            if (minInd > x) {
                minInd = x;
            }
        }
        return (minInd == s.length()+1) ? -1 : minInd;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int ans = firstUniqueChar(s);
		System.out.println(ans);
	}
}
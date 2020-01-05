import java.util.*;
import java.io.*;

class UniqueCharacter {

	public static int firstUniqueChar(String s) {
		int[] chars = new int[26];

		for (int i=0; i<s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
		}

		for (int i=0; i<s.length(); i++) {
			if (chars[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int ans = firstUniqueChar(s);
		System.out.println(ans);
	}
}
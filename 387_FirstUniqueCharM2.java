import java.util.*;
import java.io.*;

class FirstUnique {

	public static class CountIndex {
		int count;
		int startInd;

		CountIndex (int index) {
			this.count = 1;
			this.startInd = index;
		}
	}

	public static int firstUniqueChar(String s) {
		HashMap<Character, CountIndex> mp = new HashMap<>();

		for (int i=0; i<s.length(); i++) {
			if (mp.containsKey(s.charAt(i))) {
				CountIndex ci = mp.get(s.charAt(i));
				ci.count++;
				mp.put(s.charAt(i), ci);
			} else {
				mp.put(s.charAt(i), new CountIndex(i));
			}
		}

		int startIndex = Integer.MAX_VALUE;

		for (int i=0; i<s.length(); i++) {
			if (mp.get(s.charAt(i)).count == 1 && startIndex > mp.get(s.charAt(i)).startInd) {
				startIndex = mp.get(s.charAt(i)).startInd;
			}
		}
		return startIndex == Integer.MAX_VALUE ? -1 : startIndex;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int ans = firstUniqueChar(s);
		System.out.println(ans);
	}
}
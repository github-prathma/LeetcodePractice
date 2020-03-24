import java.util.*;
import java.io.*;

class MinWindowOpt {

	public static class FilteredSCharIndex  {
		int index;
		char c;

		FilteredSCharIndex(int i, char c) {
			this.index = i;
			this.c = c;
		}
	}

	public static String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		HashMap<Character, Integer> tCharsCount = new HashMap<>();

		for (int tchar = 0; tchar < t.length(); tchar++) {
			tCharsCount.put(t.charAt(tchar), tCharsCount.getOrDefault(t.charAt(tchar), 0)+1);
		}

		int requiredChars = tCharsCount.size();

		List<FilteredSCharIndex> filteredS = new ArrayList<>();

		for (int schar = 0; schar < s.length(); ++schar) {
			if (tCharsCount.containsKey(s.charAt(schar))) {
				filteredS.add(new FilteredSCharIndex(schar, s.charAt(schar)));
			}
		}

		int i=0;
		int j=0;

		int winSize = -1;
		int lSub = 0;
		int rSub = 0;

		HashMap<Character, Integer> filteredSCharsCount = new HashMap<>();

		int formedChars = 0;

		while(j < filteredS.size()) {
			char ch = filteredS.get(j).c;

			filteredSCharsCount.put(ch, filteredSCharsCount.getOrDefault(ch,0)+1);

			if (tCharsCount.containsKey(ch) && tCharsCount.get(ch).intValue() == filteredSCharsCount.get(ch).intValue()) {
				formedChars++;
			}

			while (i<=j && formedChars == requiredChars) {
				int start = filteredS.get(i).index;
				int end = filteredS.get(j).index;
				if (winSize == -1 || winSize > end-start+1) {
					winSize = end-start+1;
					lSub = start;
					rSub = end;
				}

				char ch_ = filteredS.get(i).c;

				filteredSCharsCount.put(ch_, filteredSCharsCount.get(ch_)-1);

				if (tCharsCount.containsKey(ch_) && filteredSCharsCount.get(ch_).intValue() < tCharsCount.get(ch_).intValue()) {
					formedChars--;
				}
				i++;
			}

			j++;

		}
    	
    	if (winSize == -1) {
    		return "";
    	}
    	return s.substring(lSub, rSub+1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		String ans = minWindow(s, t);
		System.out.println(ans);
	}
}
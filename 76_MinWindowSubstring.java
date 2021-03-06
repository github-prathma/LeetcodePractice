import java.util.*;
import java.io.*;

class MinWindow {

	public static String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
          return "";
        }

        int i = 0;
		int j = 0;
		HashMap<Character, Integer> tCharsCount = new HashMap<>();

		for (int tchar = 0; tchar < t.length(); tchar++) {
			tCharsCount.put(t.charAt(tchar), tCharsCount.getOrDefault(t.charAt(tchar), 0)+1);
		}

		int requiredChars = tCharsCount.size();
    
        // System.out.println(tCharsCount);
		HashMap<Character, Integer> sCharsCount = new HashMap<>();

		int formedStringChars = 0;

		int winSize = -1;
		int lSub = 0;
		int rSub = 0;

		while (j<s.length()) {
			sCharsCount.put(s.charAt(j), sCharsCount.getOrDefault(s.charAt(j), 0)+1);
        
//             if (sCharsCount.get(s.charAt(j)) == tCharsCount.get(s.charAt(j))) {
//             System.out.println(sCharsCount.get(s.charAt(j)) == tCharsCount.get(s.charAt(j)));
                
//             }
            
			if (tCharsCount.containsKey(s.charAt(j)) && sCharsCount.get(s.charAt(j)).intValue() == tCharsCount.get(s.charAt(j)).intValue()) {
                // System.out.println("formed == "+formedStringChars);
				formedStringChars++;
			}

			//if (formedStringChars == requiredChars) {
			
				while (i<=j && formedStringChars == requiredChars) {
                    // System.out.println("hgygygy");
					if (winSize == -1 || j-i+1 < winSize) {
						winSize = j-i+1;
						lSub = i;
						rSub = j;
					}
					sCharsCount.put(s.charAt(i), sCharsCount.get(s.charAt(i))-1);

					if (tCharsCount.containsKey(s.charAt(i)) && sCharsCount.get(s.charAt(i)).intValue() < tCharsCount.get(s.charAt(i)).intValue()) {
						formedStringChars--;
					}
					
					i++;
				}
			//}
			j++;
		}
        // System.out.println("left == " + lSub);
        // System.out.println("right == " + rSub);

		if (winSize == -1) {
			return "";
		} else {
			return s.substring(lSub, rSub+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		String ans = minWindow(s, t);
		System.out.println(ans);
	}
}
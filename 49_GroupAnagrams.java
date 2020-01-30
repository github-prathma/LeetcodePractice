import java.io.*;
import java.util.*;

class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
    	
    	HashMap< String, List<String> > mp = new HashMap<>();

    	for (String s : strs) {
    		int[] count = new int[26];
    		for (int i=0; i<s.length(); i++) {
    			count[s.charAt(i)-'a']++;
    		}

    		StringBuilder sb = new StringBuilder();
    		for (int i = 0; i<26; i++) {
    			sb.append("#");
    			sb.append(count[i]);
    		}

    		String mpKey = sb.toString();

    		if (!mp.containsKey(mpKey)) {
    			List<String> mpVal = new ArrayList<>();
    			mpVal.add(s);
    			mp.put(mpKey, mpVal);
    		} else {
    			mp.get(mpKey).add(s);
    		}
    	}    

    	List<List<String>> res = new ArrayList<>();
    	for (List<String> obj : mp.values()) {
    		res.add(obj);
    	}
    	return res;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] allS = s.split(" ");

		List<List<String>> anagrams = groupAnagrams(allS);

		System.out.println(anagrams);
	}
}
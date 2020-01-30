import java.io.*;
import java.util.*;

class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String> > mp = new HashMap<>();

        for (String s : strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String k = String.valueOf(sArr);
            if (!mp.containsKey(k)) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(s);
                mp.put(k, anagrams);
            } else {
                mp.get(k).add(s);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> l : mp.values()) {
            res.add(l);
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
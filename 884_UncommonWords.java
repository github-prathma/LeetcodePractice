import java.util.*;
import java.io.*;

class UncommonWords {

	public static String[] listOfWords(String A, String B) {

		String[] Awords = A.split(" ");
		String[] Bwords = B.split(" ");

		HashMap<String, Integer> mp = new HashMap<>();

		for (String s : Awords) {
			mp.put(s, mp.getOrDefault(s, 0) + 1);
		}

		for (String s : Bwords) {
			mp.put(s, mp.getOrDefault(s, 0) + 1);
		}

		List<String> res = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : mp.entrySet()) {
			if (entry.getValue() == 1) {
				res.add(entry.getKey());
			}
		}

		return res.toArray(new String[res.size()]);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();
		String B = br.readLine();

		String[] ans = listOfWords(A, B);
		for (String s : ans) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
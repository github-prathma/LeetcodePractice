import java.util.*;
import java.io.*;

class KeyboardRow {

	public static String[] findWords(String[] words) {
		String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

		List<String> res = new ArrayList<>();

		for (String e : words) {
			Character c = Character.toLowerCase(e.charAt(0));
			int rowInd = -1;
			if (rows[0].indexOf(c) != -1) {
				rowInd = 0;
			} else if (rows[1].indexOf(c) != -1) {
				rowInd = 1;
			} else if (rows[2].indexOf(c) != -1) {
				rowInd = 2;
			}
			if (rowInd == -1) {
				break;
			} else {
				boolean found = true;
				for (int i=0; i<e.length(); ++i) {
					if (rows[rowInd].indexOf(Character.toLowerCase(e.charAt(i))) == -1) {
						found = false;
						break;
					}
				}
				if (found == true) {
					res.add(e);
				}
			}
		}
		return res.toArray(new String[res.size()]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] s1 = s.split(" ");

		String[] ans = findWords(s1);
		for (String l : ans) {
			System.out.print(l + " ");
		}
		System.out.println();
	}
}
import java.util.*;
import java.io.*;

class GenerateParantheses {

	public static boolean isValid(String s) {
		int balance = 0;
		for (int i=0; i<s.length(); ++i) {
			if (s.charAt(i) == '(') {
				balance++;
			} else {
				balance--;
			}

			if (balance < 0) {
				return false;
			}
		}

		return (balance == 0);
	}

	public static void generate(List<String> res, String curr, int open, int close, int max) {

		if (curr.length() == max) {
			if (isValid(curr) == true) {
				res.add(curr);
			}
		} else {
			if (open < max) {
				generate(res, curr+'(', open+1, close, max);
			} 
			if (close < max) {
				generate(res, curr+')', open, close+1, max);
			}
		}
	}

	public static List<String> generateParan(int n) {
		// System.out.print(n);
		List<String> strings = new ArrayList<>();
		generate(strings, "", 0, 0, 2*n);
		return strings;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

		String s = br.readLine();

		int n = Integer.parseInt(s);
		
		List<String> ans = generateParan(n);

		for (String x : ans) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
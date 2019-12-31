import java.util.*;
import java.io.*;

class RemoveOuterParantheses {

	public static String removeParantheses(String S) {

		String s = "";
		Stack<Character> st = new Stack<>();

		for (int i=0; i<S.length(); ++i) {
			Character c = S.charAt(i);
			if (c == '(') {
				st.add(c);
				if (st.size() > 1) {
					s = s+c;
				}
			} else {
				st.pop();
				if (!st.isEmpty()) {
					s = s + c;
				} 
			}
		}

		return s;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		String res = removeParantheses(s);
		System.out.println(res);
	}
}
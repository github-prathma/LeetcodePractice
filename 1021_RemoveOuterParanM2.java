import java.util.*;
import java.io.*;

class RemoveParantheses {

//StringBuilder is very fast then concatening character in a string
	public static String remove(String S) {

		StringBuilder sb = new StringBuilder();
		
		int count = 0;

		for (Character c : S.toCharArray()) {
			if (c == '(') {
				count += 1;
			}

			if (count > 1) {
				sb.append(c);
			}

			if (c == ')') {
				count -=1;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		String res = remove(s);
		System.out.println(res);
	}
}
import java.io.*;
import java.util.*;

class DecodeString {

	public static String decode(String s) {
		char[] sArr = s.toCharArray();
		Stack<Character> st = new Stack<>();

		for (int i=0; i<s.length(); ++i) {
			if (s.charAt(i) == ']') {
				StringBuilder opStrB = new StringBuilder();
				while (st.peek() != '[') {
					opStrB.append(st.pop());
				}
				st.pop();
				
				String opStr = opStrB.reverse().toString();

				StringBuilder freqStr = new StringBuilder();
				while (!st.isEmpty() && Character.isDigit(st.peek())) {
					freqStr.append(st.pop());
				}
				Integer count = Integer.parseInt(freqStr.reverse().toString());

				for (int k=1; k<=count; k++) {
					for (char c : opStr.toCharArray()) {
						st.push(c);
					}
				}

			} else {
				st.push(s.charAt(i));
			}
		}
		
		StringBuilder sb = new StringBuilder();

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.reverse().toString();
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String ans = decode(s);
		System.out.println(ans);
	}
} 
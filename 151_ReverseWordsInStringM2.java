import java.util.*;
import java.io.*;

class ReverseWordsM2 {


	public static void reverseString(StringBuilder sb, int start, int end) {
		while (start < end) {
			char tmp = sb.charAt(start);
			sb.setCharAt(start++, sb.charAt(end));
			sb.setCharAt(end--, tmp);
		}
	}

	public static void reverseAllWords(StringBuilder sb) {
		int start = 0;
		int end = 0;

		while (start < sb.length()) {

			while(end < sb.length() && sb.charAt(end) != ' ') {
				end++;
			}
			end-=1;
			reverseString(sb, start, end);
			start = end+2;
			end = end+2;
		}
	}

	public static StringBuilder multipleSpacesTrim(String s) {
		int i=0;
		int j = s.length()-1;

		while (i<s.length() && s.charAt(i) == ' ') {
			i++;
		}

		while (j >= 0 && s.charAt(j) == ' ') {
			j--;
		}

		StringBuilder sb = new StringBuilder();

		while (i <= j) {
			char c = s.charAt(i);

			if (c != ' ') {
				sb.append(c);
			} else {
				while (s.charAt(i) == ' ') {
					i++;
				}
				sb.append(' ');
				sb.append(s.charAt(i));
			}
			i++;
		}

		return sb;
	}

	public static String reverseWords(String s) {
		StringBuilder sb = multipleSpacesTrim(s);
		reverseString(sb, 0, sb.length()-1);
		reverseAllWords(sb);
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = br.readLine();
			String ans = reverseWords(s);
			System.out.println(ans);
	}
}
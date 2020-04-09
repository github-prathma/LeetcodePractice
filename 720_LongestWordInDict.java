import java.util.*;
import java.io.*;

class LongestWord {

	int alphaSize = 26;

	class TrieNode {
		TrieNode[] children;
		boolean end;

		public TrieNode() {
			children = new TrieNode[alphaSize];
		}
	}

	TrieNode root;

	public LongestWord() {
		root = new TrieNode();
	}

	public void insert(String word) {
			TrieNode temp = root;
			for (int i=0; i<word.length(); i++) {
				System.out.println("Char == = " + word.charAt(i));
				if (temp.children[word.charAt(i)-'a'] == null) {
					temp.children[word.charAt(i)-'a'] = new TrieNode();
				}
				temp = temp.children[word.charAt(i)-'a'];
			}
			temp.end = true;
	}

	public String longestWord(String[] words) {

		for (String word : words) {
			insert(word);
		}

		String res = "";
		int longestLength = 0;

		for (String word : words) {
			longestLength = 0;

			TrieNode curr = root;

			for (char ch : word.toCharArray()) {
				curr = curr.children[ch - 'a'];
				if (curr.end == true) {
					longestLength++;
				} else {
					break;
				}
			}

			if (curr.end && longestLength == word.length()) {
				if(word.length() > res.length()) {
					res = word;
				} else if (word.length() == res.length()) {
					if (word.compareTo(res) < 0) {
						res=word;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String wrds = br.readLine();
		String[] wordsArr = wrds.split(" ");

		LongestWord lg = new LongestWord();

		String ans = lg.longestWord(wordsArr);
		System.out.println(ans);
	}
}
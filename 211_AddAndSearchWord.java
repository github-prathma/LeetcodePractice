import java.util.*;
import java.io.*;

class WordDictionary {

	public static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEnd;

		TrieNode() {
			for (int i=0; i<26; ++i) {
				children[i] = null;
			}
			isEnd = false;
		}
	}

	static TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode temp = root;

		for (int i=0; i<word.length(); ++i) {
			if (temp.children[word.charAt(i) - 'a'] == null) {
				temp.children[word.charAt(i) - 'a'] = new TrieNode();
			}
			temp = temp.children[word.charAt(i)-'a'];
		}
		temp.isEnd = true;
	}

	public boolean searchWordHelper(String word, int index, TrieNode current) {

		if (index == word.length()) {
			return current.isEnd;
		}

		Character c = word.charAt(index);
		if (c == '.') {
			for (int i=0; i<26; ++i) {
				if (current.children[i] != null && searchWordHelper(word, index+1, current.children[i])) {
					return true;
				}
			}
			return false;

		} else if (current.children[c - 'a'] != null) {
			return searchWordHelper(word, index+1, current.children[c-'a']);
		}
		return false;

	}
	
	public boolean searchWord(String word) {
		return this.searchWordHelper(word, 0, root);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		WordDictionary wd = new WordDictionary();

		boolean isEnd = false;
		while (isEnd == false) {
			String query = br.readLine();
			String word = br.readLine();
			switch(query) {
				case "search":
						boolean ans = wd.searchWord(word);
						System.out.println(ans);
						break;
				case "add":
						wd.addWord(word);
						break;
				case "end":
							isEnd = true;
							break;
				default:
						isEnd = true;
						break;
			}
			if (isEnd == true) {
				break;
			}
		}

	}
}
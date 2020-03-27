import java.util.*;
import java.io.*;

class ReverseWords {

	    public static String reverseWords(String s) {
        	String[] words = s.split("\\s+");
        	Stack<String> st = new Stack<>();
        
        	for (String w : words) {
            	// System.out.println(w);
            	st.add(w);
        	}
        
        	String res = "";
        	while(!st.empty()) {
            	res = res + " "+ st.pop();
        	}
        
        	return res.trim();
    	}

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = br.readLine();
			String ans = reverseWords(s);
			System.out.println(ans);
		}
}
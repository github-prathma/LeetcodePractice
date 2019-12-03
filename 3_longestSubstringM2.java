import java.io.*;
import java.util.*;

class SlidingWindowAlgo {
    public static int longestSubstringUniqueChars(String s) {
        int temp = 0;
        HashSet<Character> setChars = new HashSet<>();

        int i=0; 
        int j=0;

        while (i<s.length() && j<s.length()) {
            if (!setChars.contains(s.charAt(j))) {
                setChars.add(s.charAt(j));
                temp = Math.max(temp, j-i+1);
                j++;
            } else {
                setChars.remove(s.charAt(i));
                i++;
            }
        }
        return temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l = br.readLine();
        int ans = longestSubstringUniqueChars(l);
        System.out.println(ans);
    }
}
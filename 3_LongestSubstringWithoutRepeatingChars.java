import java.io.*;
import java.util.*;

class LongestSubstring {
    public static int longestSubString(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int[] chars = new int[128];
        int temp = 0;

        for (int i=0; i<s.length(); ++i) {
            boolean uniqueChars = false;
            String str = "";
            for (int j=i; j<s.length(); ++j) {
                str = s.substring(i, j+1);
                chars[(int)s.charAt(j)]++;
                if (chars[(int)s.charAt(j)] > 1) {
                    str = s.substring(i, j);
                    break;
                } else {
                    uniqueChars = true;
                }
            }
            if (uniqueChars && str.length() > temp) {
                temp = str.length();
            }
            for (int k=0; k<128; ++k) {
                chars[k] = 0;
            }
        }
        return temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l = br.readLine();
        int ans = longestSubString(l);
        System.out.println(ans);
    }
}
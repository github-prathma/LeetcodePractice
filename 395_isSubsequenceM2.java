import java.util.*;
import java.io.*;

class IsSubseq {
    public static boolean isSubsequence(String s, String t) {
        int ind = 0;

        //check index of every char of s in t, if found, 
        //check next char of s further from remaining part of t (after found index).
        for (int i=0; i<s.length(); ++i) {
            int idx = t.indexOf(s.charAt(i), ind);
            if (idx != -1) {
                ind = idx+1;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        boolean ans = isSubsequence(s, t);
        System.out.println(ans);
    }
}
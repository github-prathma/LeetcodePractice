import java.io.*;
import java.util.*;

// given two strings s and p, count all possibilities after removing only one digit either from s or from p.
class RemoveOneDigit {
    public static String removeCharAt(String s, int p) {
        return s.substring(0, p) + s.substring(p+1);
    }

    public static int removeDigit(String s, String p) {
        HashMap<String, Set<String> > mp = new HashMap<>();
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                String temp = s;
                temp = removeCharAt(temp, i);
                if (temp.compareTo(p) < 0) {
                    if (mp.containsKey(temp)) {
                        mp.get(temp).add(p);
                    } else {
                        Set<String> st = new HashSet<>();
                        st.add(p);
                        mp.put(temp, st);
                    }
                }
            }
        }

        for (int i=0; i<p.length(); ++i) {
            if (p.charAt(i) >= '0' && p.charAt(i) <= '9') {
                String temp = p;
                temp = removeCharAt(temp, i);
                if (temp.compareTo(s) > 0) {
                    if (mp.containsKey(s)) {
                        mp.get(s).add(temp);
                    } else {
                        Set<String> st = new HashSet<>();
                        st.add(temp);
                        mp.put(s, st);
                    }
                }
            }
        }

        // System.out.println(mp);

        int count = 0;
        for (Map.Entry<String, Set<String> > entry : mp.entrySet()) {
            count+=entry.getValue().size();
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        int ans = removeDigit(s, t);
        System.out.println(ans);
    }
}
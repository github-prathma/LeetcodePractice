import java.util.*;
import java.io.*;

class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];

        for (int i=0; i<p.length(); i++) {
            chars[p.charAt(i)-'a']++;
        }

        List<Integer> res = new ArrayList<>();

        for (int i=0; i<s.length()-p.length()+1; ++i) {
            int j = i+p.length()-1;

            int[] chars1 = new int[26];
            for (int k=i; k<=j; ++k) {
                chars1[s.charAt(k)-'a']++;
            }

            boolean isAnagram = true;
            for (int c=0; c<26; ++c) {
                if (chars[c] != chars1[c]) {
                    isAnagram = false;
                    break;
                }
            }

            if (isAnagram) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        List<Integer> res = findAnagrams(s, p);
        for (int x:res) {
            System.out.print(x+" ");
        }
        System.out.println();
    }
}
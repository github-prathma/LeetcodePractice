import java.io.*;
import java.util.*;

class FindAnagram {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();

        int[] charsS = new int[26];
        int[] charsP = new int[26];

        int l1 = s.length();
        int l2 = p.length();

        if (l1==0 || l1<l2) {
            return results;
        }

        for(int i=0; i<l2; i++) {
            charsS[s.charAt(i) - 'a']++;
            charsP[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(charsS, charsP)) {
            results.add(0);
        }

        for (int i=1; i<=l1-l2; ++i) {
            charsS[s.charAt(i-1) - 'a']--;
            charsS[s.charAt(i+l2-1) - 'a']++;
            if (Arrays.equals(charsS, charsP)) {
                results.add(i);
            }
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1 = br.readLine();
        String l2 = br.readLine();

        List<Integer> anagrams = findAnagrams(l1, l2);
        for (Integer x : anagrams) {
            System.out.print(x + " ");
        }
        System.out.println();

    }
}
import java.util.*;
import java.io.*;

class SlidingWindowOptimized {
    public static int slidingWindowWithSkip(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int temp=0;

        int i=0;
        for (int j=0; j<s.length(); j++) {
            if (mp.containsKey(s.charAt(j))) {
                i = Math.max(i, mp.get(s.charAt(j))+1);
            }
            mp.put(s.charAt(j), j);
            temp = Math.max(temp, j-i+1);

        }
        return temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l = br.readLine();
        int ans = slidingWindowWithSkip(l);
        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

class MaxCommon {
    public static int maxLCS(String input) {
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];

        for (int i=0; i<input.length(); i++) {
            chars2[input.charAt(i) - 'a']++;
        }

        int ans = 0;
        for (int i=0; i<input.length(); i++) {
            chars1[input.charAt(i) - 'a']++;
            chars2[input.charAt(i) - 'a']--;

            int temp = 0;
            for (int j=0; j<26; j++) {
                temp += Math.min(chars1[j], chars2[j]);
            }
            if (temp > ans) {
                ans = temp;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        int ans = maxLCS(line1);
        System.out.println(ans);
    }
}
import java.util.*;
import java.io.*;

class SingleRowKeyboard {
    public static int calcTime (String keyboard, String word) {
        int[] alphas = new int[26];
        for (int i=0; i<keyboard.length(); ++i) {
            alphas[keyboard.charAt(i) - 'a'] = i;
        }

        int time = 0;
        for (int i = 0; i<word.length(); ++i) {
            if (i == 0) {
                time += alphas[word.charAt(i)-'a'];
            } else {
                int a1 = alphas[word.charAt(i-1) - 'a'];
                int a2 = alphas[word.charAt(i) - 'a'];
                time += Math.abs(a1-a2);
            }
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String keyboard = br.readLine();
        String word = br.readLine();

        int ans = calcTime(keyboard, word);
        System.out.println(ans);
    }
}
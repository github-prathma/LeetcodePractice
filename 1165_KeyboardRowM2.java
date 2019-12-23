import java.util.*;
import java.io.*;

class SingleRowKeyboard {
    public static int calcTime (String keyboard, String word) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i=0; i<keyboard.length(); ++i) {
            mp.put(keyboard.charAt(i), i);
        }

        int pos = 0;
        int time = 0;
        for (int i = 0; i<word.length(); ++i) {
            int curr = mp.get(word.charAt(i));
            time += Math.abs(curr-pos);
            pos = curr;
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
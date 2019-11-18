import java.io.*;
import java.util.*;

class BullsAndCows {
    public static String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int[] countDigsSecret = new int[10];
        int[] countDigsGuess = new int[10];
        int cows = 0; 
        int bulls = 0;
        for (int i=0; i<secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s==g) {
                bulls++;
            } else {
                countDigsGuess[g]++;
                countDigsSecret[s]++;
            }
        }
        for (int i=0; i<10; i++) {
            cows += Math.min(countDigsGuess[i], countDigsSecret[i]);
        }
        sb.append(bulls);
        sb.append('A');
        sb.append(cows);
        sb.append('B');
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String secret = br.readLine();
        String guess = br.readLine();
        String ans = getHint(secret, guess);
        System.out.println(ans);
    }
}
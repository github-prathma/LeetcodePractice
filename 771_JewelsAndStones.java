import java.util.*;
import java.io.*;

class JewelsAndStones {
    
    public static int numJewelsInStones(String J, String S) {
        Set<Character> stJ = new HashSet<>();
        for (int i=0; i<J.length(); ++i) {
            stJ.add(J.charAt(i));
        }

        int countJewels = 0;
        for (int i=0; i<S.length(); ++i) {
            if (stJ.contains(S.charAt(i))) {
                countJewels++;
            }
        }
        return countJewels;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String j = br.readLine();
        String s = br.readLine();

        int ans = numJewelsInStones(j, s);
        System.out.println(ans);
    }
}
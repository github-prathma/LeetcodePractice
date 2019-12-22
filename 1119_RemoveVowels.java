import java.util.*;
import java.io.*;

class RemoveVowelsChar {
    public static String stringAfterRemoval(String S) {
        String temp = "";

        for (int i = 0; i<S.length(); ++i) {
            Character c = S.charAt(i);
            if (c == 'a' || c == 'e'|| c == 'i' || c == 'o' || c == 'u') {
                continue;
            } else {
                temp += c;
            }
        }
        return temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line  = br.readLine();
        String ans = stringAfterRemoval(line);
        System.out.println(ans);
    }
}
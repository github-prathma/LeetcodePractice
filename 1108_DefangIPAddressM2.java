import java.util.*;
import java.io.*;

class DefangIPAddress {

    public static String defangAddress(String S) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : address.toCharArray()) {
            if (c != '.') {
                sb.append(c);
            } else {
                sb.append("[.]");
            }
        }
        
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String ans = defangAddress(s);
        System.out.println(ans);
    }
}
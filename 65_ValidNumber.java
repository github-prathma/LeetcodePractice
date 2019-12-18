import java.util.*;
import java.io.*;

class ValidNumber  {
    public static boolean validCheck(String s) {
        boolean hasE = false;
        boolean hasPoint = false;
        boolean hasSign = false;
        
        String left = "";
        String right = "";
        
        char[] charStr = s.trim().toCharArray();
        
        for (int i=0; i<charStr.length; ++i) {
            switch (charStr[i]) {
                case 'e':
                case 'E':
                    if (hasE || left.length() == 0 || (left.compareTo(".") == 0)) {
                        return false;
                    }
                    hasE = true;
                    break;
                case '.':
                    if (hasPoint || hasE) {
                        return false;
                    }
                    left += ".";
                    hasPoint = true;
                    break;
                case '-':
                case '+':
                    if (hasE && right.length() > 0) {
                        return false;
                    } else if (!hasE && left.length() > 0) {
                        return false;
                    } else if (!hasE && hasSign) {
                        return false;
                    }
                    hasSign = true;
                    break;
                default:
                    if (charStr[i] >= '0' && charStr[i] <= '9') {
                        if (!hasE) {
                            left += charStr[i];
                        } else {
                            right += charStr[i];
                        }
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if (left.length() == 0 || (left.compareTo(".") == 0) || (hasE && right.length() == 0) || (right.compareTo(".") == 0)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l = br.readLine();
        boolean ans = validCheck(l);
        System.out.println(ans);
    }
}
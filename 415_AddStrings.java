import java.util.*;
import java.io.*;

class AddStrings {
    public String addTwoStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        String result = "";

        int carry = 0;

        while (i >= 0 && j >= 0) {
            int dig1 = num1.charAt(i) - 48;
            int dig2 = num2.charAt(j) - 48;

            int digAns = dig1 + dig2 + carry;
            int charInString = digAns%10;
            result = result + (char)(charInString + 48);
            carry = digAns/10;
            i--;
            j--;
        }
        // System.out.println("i == " + i);
        if (i >= 0) {
            while (i>=0) {
                int dig1 = num1.charAt(i) - 48;
                int digAns = dig1 + carry;
                int charInString = digAns%10;
                result = result + (char)(charInString + 48);
                carry = digAns/10;
                i--;
            }
        } else {
            while (j>=0) {
                int dig1 = num2.charAt(j) - 48;
                int digAns = dig1 + carry;
                int charInString = digAns%10;
                result = result + (char)(charInString + 48);
                carry = digAns/10;
                j--;
            }
        }
        if (carry == 1) {
            result = result + (char)(carry + 48);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        sb = sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num1 = br.readLine();
        String num2 = br.readLine();

        AddStrings as = new AddStrings();
    
        String ans = as.addTwoStrings(num1, num2);

        System.out.println(ans);
    }
}
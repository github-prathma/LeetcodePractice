import java.util.*;
import java.io.*;

//O(n) 21ms
class AddStringsMethod2 {
    public String addTwoStrings(String num1, String num2) {
        int numOfDigits = Math.max(num1.length(), num2.length());

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<numOfDigits; i++) {
            int sum = carry;
            if (num1.length() > i) {
                sum += (num1.charAt(num1.length() - 1 - i) - 48);
            }
            if (num2.length() > i) {
                sum += (num2.charAt(num2.length() - 1 - i) - 48);
            }
            if (sum < 10) {
                sb.insert(0, sum);
                carry = 0;
            } else {
                sb.insert(0, sum);
                carry = 1;
            }
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num1 = br.readLine();
        String num2 = br.readLine();

        AddStringsMethod2 as = new AddStringsMethod2();
    
        String ans = as.addTwoStrings(num1, num2);

        System.out.println(ans);
    }
}
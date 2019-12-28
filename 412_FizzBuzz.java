import java.util.*;
import java.io.*;

class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i=1; i<=n; ++i) {
            boolean divBy3 = false;
            boolean divBy5 = false;
            if (i%5 == 0) {
                divBy5 = true;
            }
            if (i%3 == 0) {
                divBy3 = true;
            }

            String numAns = "";
            if (divBy3) {
                numAns += "Fizz";
            }
            if (divBy5) {
                numAns += "Buzz";
            }
            if (numAns.compareTo("") == 0) {
                numAns += Integer.toString(i);
            }
            ans.add(numAns);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> ans = fizzBuzz(n);

        for (String s : ans) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
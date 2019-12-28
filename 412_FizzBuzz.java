import java.util.*;
import java.io.*;

class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i=1; i<=n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i%3 == 0) {
                ans.add("Fizz");
            } else if (i%5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
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
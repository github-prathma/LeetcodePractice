import java.util.*;
import java.io.*;

class SubstractSumAndProd {

    public static int subtractProductSum(int n) {
        int prod = 1;
        int sum = 0;
        while (n!=0) {
            int dig = n%10;
            prod *= dig;
            sum += dig;
            n = n/10;
        }
        return (prod - sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l1 = br.readLine();
        int n = Integer.parseInt(l1);
        int ans = subtractProductSum(n);
        System.out.println(ans);
    }
}
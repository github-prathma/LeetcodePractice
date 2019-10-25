import java.util.*;
import java.io.*;

//Recursive solution
class AddDigits {

    int addDigs(int num) {
        if (num < 10) {
            return num;
        }
        return addDigs(num/10 + num%10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();

        AddDigits ad = new AddDigits();
        int ans = ad.addDigs(inp);
        System.out.println(ans);
        sc.close();
    }
}

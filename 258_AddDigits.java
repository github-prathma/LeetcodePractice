import java.util.*;
import java.io.*;

class AddDigits {

    int addDigs(int num) {
        return 1 + ((num -1) % 9);
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

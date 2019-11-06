import java.util.*;
import java.io.*;

class ArrangeCoins {
    public static int fullstairRows(int n) {
        int temp = n;
        int count = 0;
        for (int i=1; i<=temp; i++) {
            if (n >= i) {
                count++;
            } else {
                break;
            }
            n = n-i;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCoins = sc.nextInt();

        int ans = fullstairRows(numCoins);
        System.out.println("complete rows = " + ans);
        sc.close();
    }
}
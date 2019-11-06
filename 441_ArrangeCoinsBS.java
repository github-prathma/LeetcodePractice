import java.util.*;
import java.io.*;

class BSMethod {
    public static int fullstairRows(int num) {
        int start = 0;
        int end = num;

        while (start <= end) {
            int mid = (start + end)/2;
            int sumOfCoinsTillMid = mid*(mid+1)/2;

            if (sumOfCoinsTillMid == num) {
                return mid;
            } else if (sumOfCoinsTillMid > num) {
                end = mid - 1;
            } else {
                start = mid+1;
            }
        }
        return start-1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCoins = sc.nextInt();

        int ans = fullstairRows(numCoins);
        System.out.println("complete rows = " + ans);
        sc.close();
    }
}
import java.io.*;
import java.util.*;

class ArmstrongNum {
    public boolean isArmstrong(int N) {
        int temp = N;
        int digCountNum = N;
        int countDigs = 0;
        while (digCountNum != 0) {
            countDigs++;
            digCountNum = digCountNum/10;
        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i=0; i<10; i++) {
            double k = Math.pow(i, countDigs);
            int powRes = (int)Math.round(k);
            mp.put(i, powRes);
        }

        int sum = 0;
        while (N != 0) {
            int x = N%10;
            sum = sum + mp.get(x);
            N = N/10;
        }
        if (sum == temp) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        ArmstrongNum an = new ArmstrongNum();
        boolean ans = an.isArmstrong(input);
        System.out.println(ans);
        sc.close();
    }
}
import java.util.*;
import java.io.*;

class ArmstrongNum2 {
    public boolean isArmstrong(int N) {
       int k = (int)(Math.log10(N)+1);
       int x = N;
       int sum = 0;

       while (x != 0) {
           sum += Math.pow(x % 10, k);
           x = x/10;
       }
       return sum == N;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int input = sc.nextInt();

        ArmstrongNum2 an = new ArmstrongNum2();
        boolean ans = an.isArmstrong(input);
        System.out.println(ans);
        sc.close();
    }
}
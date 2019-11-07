import java.util.*;
import java.io.*;

class RectangleOverlap {
    public static boolean isOverlap(int[] rec1, int[] rec2){
        if (rec2[0] >= rec1[2]) {
            return false;
        }
        if (rec2[3] <= rec1[1]) {
            return false;
        }
        if (rec2[2] <= rec1[0]) {
            return false;
        }
        if (rec2[1] >= rec1[3]) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = br.readLine();

        String[] allNums = inp.split(" ");

        int[] r1 = new int[allNums.length];

        for (int i=0; i<r1.length; i++) {
            r1[i] = Integer.parseInt(allNums[i]);
        }

        String inp1 = br.readLine();

        String[] allNums1 = inp1.split(" ");

        int[] r2 = new int[allNums1.length];

        for (int i=0; i<r2.length; i++) {
            r2[i] = Integer.parseInt(allNums1[i]);
        }

        boolean ans = isOverlap(r1, r2);
        System.out.println(ans);
    }
}
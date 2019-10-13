import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;

//greedy algorithm O(n)

/*sorted both arrays because suppose array1 = [1,2,3] and array2 = [5,1] according to without sort = ans will be 1 
but it should be 2 according to max ouput.
*/
class AssignCookies {

    public int maxAssignedCookies(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0;
        int j=0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        String[] g = line1.trim().split(" ");
        int[] greedFactors = new int[g.length];

        for (int i=0; i<g.length; i++) {
            greedFactors[i] = Integer.parseInt(g[i]);
        }

        String line2 = br.readLine();
        String[] c = line2.trim().split(" ");
        int[] cookiesSize = new int[c.length];

        for (int i=0; i<c.length; i++) {
            cookiesSize[i] = Integer.parseInt(c[i]);
        }

        AssignCookies ac = new AssignCookies();
        int ans = ac.maxAssignedCookies(greedFactors, cookiesSize);
        System.out.println(ans);
    }
}
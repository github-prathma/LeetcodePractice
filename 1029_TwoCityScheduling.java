import java.util.*;
import java.io.*;

class TwoCity {

    public static int minCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] cost1, int[] cost2) {
                int diff1 = cost1[0]-cost1[1];
                int diff2 = cost2[0]-cost2[1];
                return diff1-diff2;
            }
        });

        int sum=0;
        int len = costs.length;

        for (int i=0; i<len/2; ++i) {
            sum+=costs[i][0];
        }

        for (int i=len/2; i<len; ++i) {
            sum += costs[i][1];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] costs = new int[n][2];

        for (int i=0; i<n; ++i) {
            String c = br.readLine();
            String[] cs = c.split(" ");
            for (int j=0; j<2; ++j) {
                costs[i][j] = Integer.parseInt(cs[j]);
            }
        }

        int ans = minCost(costs);
        System.out.println(ans);
    }
}
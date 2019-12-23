import java.util.*;
import java.io.*;

class MinTimeVisit {

    public static int calcMinTime(int[][] points) {
        int res = 0;
       for (int i=1; i<points.length; ++i) {
           int x1 = Math.abs(points[i][0] - points[i-1][0]);
           int y1 = Math.abs(points[i][1] - points[i-1][1]);
           res+=Math.max(x1, y1);
       }
       return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("No. of points: ");

        int n = Integer.parseInt(br.readLine());

        int[][] points = new int[n][2];

        for (int i=0; i<points.length; ++i) {
            String l = br.readLine();
            String[] lcoord = l.split(" ");
            points[i][0] = Integer.parseInt(lcoord[0]);
            points[i][1] = Integer.parseInt(lcoord[1]);
        }

        int ans = calcMinTime(points);
        System.out.println(ans);
    }
}
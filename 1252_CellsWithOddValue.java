import java.util.*;
import java.io.*;

/*
0 1 2
3 4 5
6 7 8
9 10 11
rows = 4, columns = 3

to find the index of kth element where k = 0 to rows*colums
suppose k = 8
8/columns == row index
8%columns == col index

8/3 = 2
8%3 = 2 
hence cell index = (2,2)
*/
class CellsWithOddValue {

    public static int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[51];
        int[] cols = new int[51];

        for (int i=0; i<indices.length; ++i) {
            rows[indices[i][0]]++;
        }
        for (int i=0; i<indices.length; ++i) {
            cols[indices[i][1]]++;
        }


        int count = 0;
        for (int i=0; i<n*m; ++i) {
            int r = i/m;
            int c = i%m;

            if ((rows[r] + cols[c]) % 2 != 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        System.out.println("No. of indices: ");
        int k = Integer.parseInt(br.readLine());

        int[][] indx = new int[k][2];
        for (int i=0; i<k; ++i) {
            String l = br.readLine();
            String[] l1 = l.split(" ");
            indx[i][0] = Integer.parseInt(l1[0]);
            indx[i][1] = Integer.parseInt(l1[1]);
        }
        int ans = oddCells(n, m, indx);
        System.out.println(ans);
    }
}
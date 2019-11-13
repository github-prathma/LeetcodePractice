import java.util.*;
import java.io.*;

class MaxInAllPaths {
    public static int globalMax = -1;
    public static void maxInPaths(int[][] mat, int row, int col, int min) {
        int min2 = min;
        if (row < mat.length && col < mat[0].length) {
            if (mat[row][col] < min2) {
                min2 = mat[row][col];
            }
        }
        if (row == mat.length-1 && col == mat[0].length-1) {
            if (min2 > globalMax) {
                globalMax = min2;
            }
            return;
        } else if (row == mat.length-1) {
            maxInPaths(mat, row, col+1, min2);
        } else if (col == mat[0].length-1) {
            maxInPaths(mat, row+1, col, min2);
        } else {
            maxInPaths(mat, row+1, col, min2);
            maxInPaths(mat, row, col+1, min2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] mat = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        maxInPaths(mat, 0, 0, mat[0][0]);
        System.out.println(globalMax);    
        sc.close();
    }
}
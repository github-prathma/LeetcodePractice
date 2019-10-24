import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.Queue;

// DP solution 

class Matrix01Method3 {

    public int[][] adjacent0s(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        
        if (numRows == 0) {
            return matrix;
        }

        int[][] dist = new int[numRows][numCols];
        for (int i=0; i<numRows; i++) {
            for (int j=0; j<numCols; j++) {
                dist[i][j] = Integer.MAX_VALUE - 100000;
            }
        }

        // top or left
        for (int i=0; i<numRows; i++) {
            for (int j=0; j<numCols; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i-1][j]+1);
                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j-1]+1);
                    }
                }
            }
        }

        //bottom or right
        for (int i=numRows - 1; i>=0; i--) {
            for (int j=numCols-1; j>=0; j--) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i < numRows-1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i+1][j]+1);
                    }
                    if (j < numCols-1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j+1]+1);
                    }
                }
            }
        }

        return dist;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter no. of rows");
        int r = Integer.parseInt(br.readLine());

        System.out.println("Enter no. of cols");
        int c = Integer.parseInt(br.readLine());

        int[][] input = new int[r][c];

        for (int i=0; i<r; i++) {
            String l1 = br.readLine();
            String[] l1Split = l1.split(" ");
            for (int j = 0; j<c; j++) {

                input[i][j] = Integer.parseInt(l1Split[j]);
            }
        }

        System.out.println("Distance matrix");
        Matrix01Method3 m = new Matrix01Method3();
        int[][] dist = m.adjacent0s(input);

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }      
    }
}

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.Queue;

// bfs solution 16ms

class Matrix01Method2 {
    private class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] adjacent0s(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        
        if (numRows == 0) {
            return matrix;
        }

        int[][] dir = { {-1,0}, {1, 0}, {0, -1}, {0, 1} };

        int[][] dist = new int[numRows][numCols];

        Queue<Point> bfsQueue = new LinkedList<Point>();

        for (int i=0; i<numRows; i++) {
            for (int j=0; j<numCols; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    bfsQueue.add(new Point(i, j));
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!bfsQueue.isEmpty()) {
            Point p = bfsQueue.poll();

            for (int i=0; i<4; i++) {
                int newR = p.r + dir[i][0];
                int newC = p.c + dir[i][1];
                
                if (newR >= 0 && newC >= 0 && newR < numRows && newC < numCols) {
                    if (dist[newR][newC] > dist[p.r][p.c] + 1) {
                        dist[newR][newC] = dist[p.r][p.c] + 1;
                        bfsQueue.add(new Point(newR, newC));
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
        Matrix01Method2 m = new Matrix01Method2();
        int[][] dist = m.adjacent0s(input);

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }      
    }
}
